package com.foreseers.tj.huanxin;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.mapper.ChatMessageMapper;
import com.foreseers.tj.model.ChatMessage;
import com.foreseers.tj.util.ApplicationContextProvider;


public class huanxin {

	private static final Logger log = LoggerFactory.getLogger(huanxin.class);

	
	StringBuffer  huanxinurl = new StringBuffer("http://a1.easemob.com/1106190114019314/foreseers/"); //阿里云
	

//	StringBuffer  huanxinurl = new StringBuffer("http://a1.easemob.com/1106190114019314/zzzz/");
	
	 String filePath = "/chatFiles/";

	public void gettime(){
		log.info("现在的时间是："+new Date());
	}
	
	private ChatMessageMapper chatMessageMapper;
	
	public huanxin() {
		this.chatMessageMapper = ApplicationContextProvider.getBean(ChatMessageMapper.class);
	}
	/*
	 * 得到token
	 */
	public String getToken() throws ClientProtocolException, IOException {
		String url = huanxinurl.toString()+"token";
		String token = "";
		HttpHuanxin httphuanxin = new HttpHuanxin();
        Map<String, String> map = new HashMap<String, String>();
        //阿里云
	        map.put("grant_type","client_credentials");
	        map.put("client_id","YXA6HlxXgBiWEemPQ-MnLEqLUg");
	        map.put("client_secret","YXA6GloiOfyJ83aGrpEkFlIaQ3X1dsc");
        //本地
//	      map.put("grant_type","client_credentials");
//	      map.put("client_id","YXA6d67OQCKfEem14fvKxRhkWw");
//	      map.put("client_secret","YXA6P9FFmiAc6FozZ4m5UsxK7E0_kmw");
	       CloseableHttpResponse rebody =  httphuanxin.sendPostDataByJson(url, JSON.toJSONString(map), "utf-8", null);
	       if(rebody.getStatusLine().getStatusCode() == 200) {
	    	   String result =  EntityUtils.toString(rebody.getEntity(),"utf-8");
	    	   JSONObject job = JSON.parseObject(result);
	    	    token = job.getString("access_token");
	       }else {
	    	   getToken();
	       }
	       
		return token;
	}
	
	public void getMessage(String token) throws ClientProtocolException, IOException {
		HttpHuanxin httphuanxin = new HttpHuanxin();
		 String  mesurl = "";
		
		List<String> hourList = DateUtils.getOneDayHourList(DateUtils.getBeforeDayDate(new Date(), 1)); //获取前一天的各个时间点：2019012200
		log.info("得到的时间list:"+hourList);
		for(String hour :hourList) {  
			try {
			String url = huanxinurl.toString()+"chatmessages/"+hour;
			System.out.println(url);
			CloseableHttpResponse rebodyd =	httphuanxin.sendGetData(url,"utf-8", token);
			System.out.println(rebodyd.getStatusLine().getStatusCode());
			
			if(rebodyd.getStatusLine().getStatusCode() == 200) { //正常返回
				//  String result = EntityUtils.toString(result.getEntity(), "utf-8");
				  String result = EntityUtils.toString(rebodyd.getEntity(), "utf-8");
				  System.out.println(result);
	        	  JSONObject job = JSON.parseObject(result);
	        	  JSONArray data = job.getJSONArray("data");
	        	  for(int i= 0;i<data.size();i++) {
	        	  JSONObject resultjson = JSON.parseObject(data.get(i).toString());
	        	  mesurl =   resultjson.getString("url");	
	        	  if(mesurl != null) {
	        		  String fileName = hour+".gz";
	        		  String downLoadResult = HttpUtil.downloadFileByUrls(mesurl, fileName,filePath);
	        		  log.info("下载压缩包:"+downLoadResult);
	        		  if("ok".equals(downLoadResult)) {
	        			  //解压文件
		        		  String outPutFilePath = unZipFile(filePath + fileName);
		        		  log.info("解压后的文件："+outPutFilePath);
		        		  //读取文件
		        		  if(outPutFilePath.length()>0) {
		        			  String content = readFile2String(outPutFilePath);
		        			  log.info("读取到文件："+content);
		        			  if(content.length()>0) { //如果有文件
		        				  handleContent(content);
		        			  }
		        		  }
	        		  }
	        	  }
	        }
			}else {
				if(rebodyd.getStatusLine().getStatusCode() == 401) { //token过期
					String tokens = getToken();
					getMessage(tokens);
				}
			}
			//延时执行,环信下载接口有限流
			 Thread.sleep(10000);
			}catch(Exception e) {	
				 e.printStackTrace();
			}	
		}//遍历集合 获取聊天信息
		
	}
	 //解压压缩包
    private String unZipFile(String filePath) {
        //解压gz压缩包
        String ouPutFile = "";
        try {
            //建立gzip压缩文件输入流
            FileInputStream fIn = new FileInputStream(filePath);
            //建立gzip解压工作流
            GZIPInputStream gzIn = new GZIPInputStream(fIn);
            //建立解压文件输出流
            ouPutFile = filePath.substring(0,filePath.lastIndexOf('.'));
            FileOutputStream fOut = new FileOutputStream(ouPutFile);
            int num;
            byte[] buf=new byte[1024];
 
 
            while ((num = gzIn.read(buf,0,buf.length)) != -1)
            {
                fOut.write(buf,0,num);
            }
            gzIn.close();
            fOut.close();
            fIn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ouPutFile;
    }
    /**
     * 读取文件内容
    **/
    private String readFile2String(String outPutFilePath) {
        String content = "";
        String encoding = "UTF-8";
        File file = new File(outPutFilePath);
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            content = new String(fileContent, encoding).trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return content;
    }
	// 读取文件，保存到数据库中
    public void handleContent(String content) {
        JSONArray jsonArray = JSON.parseArray("[" + content + "]");
     //   List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
        for(int i = 0; i < jsonArray.size(); i++){
            ChatMessage chatMessage = new ChatMessage();
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            JSONArray bodyJsons = (JSONArray)((JSONObject) jsonObject.get("payload")).get("bodies");
            for(int j = 0; j < bodyJsons.size(); j ++) {
                JSONObject bodyJson = (JSONObject) bodyJsons.get(j);
                chatMessage.setMsgId(jsonObject.getString("msg_id"));
                //chatMessage.setTimestamp(new Date(Long.parseLong(jsonObject.getString("timestamp"))).toString());
                Date date = new Date(Long.parseLong(jsonObject.getString("timestamp")));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = df.format(date);
                chatMessage.setUsertime(timestamp);
                chatMessage.setDirection(jsonObject.getString("direction"));
                chatMessage.setToUser(jsonObject.getString("to"));
                chatMessage.setFromUser(jsonObject.getString("from"));
                chatMessage.setMsg(bodyJson.getString("msg"));
                chatMessage.setType(bodyJson.getString("type"));
                chatMessage.setUrl(bodyJson.getString("url"));
                chatMessage.setSecret(bodyJson.getString("secret")); //上传图片返回的字符串，只有含有secret才能下载此图片
                chatMessage.setFilename(bodyJson.getString("filename"));
                chatMessage.setThumb(bodyJson.getString("thumb"));
                chatMessage.setThumbSecret(bodyJson.getString("thumb_secret"));
                chatMessage.setAddr(bodyJson.getString("addr"));
                chatMessage.setLat(bodyJson.getDouble("lat"));
                chatMessage.setLng(bodyJson.getDouble("lng"));
               // chatMessageList.add(chatMessage);
                log.info("聊天记录："+chatMessage.toString());
                
                chatMessageMapper.insertSelective(chatMessage);
              log.info("聊天记录保存到数据库成功");
              
            }
        }
       
    }
    
    /*
     * 
     */
    public void delpackage() {
    	
    	File file = new File(filePath);
    	if(!file.exists()) {
    		log.error("文件夹不存在");
    	}
    	if(file.isDirectory()) {
    		String[]  childs = file.list();
    		log.info("文件夹下的文件："+childs);
    		for(String child : childs) {
    			File file1 = new File(file,child);
    			file1.delete();
    		}
    	}	
    	
    }
    
    
}
