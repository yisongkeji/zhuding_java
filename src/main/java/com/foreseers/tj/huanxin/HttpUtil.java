package com.foreseers.tj.huanxin;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpUtil {
	 
	 
	   private static Logger log = LoggerFactory.getLogger(HttpUtil.class);
	 
	 
	    public static String getEasemobChatMessageDownloadUrl(String getUrl, String token) {
	        String downloadUrl = "";
	        try {
	            URL url = new URL(getUrl);    //把字符串转换为URL请求地址
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
	            //设置Head参数
	            connection.setRequestProperty("Content-Type", " application/json");//设定 请求格式 json，也可以设定xml格式的
	            connection.setRequestProperty("Accept-Charset", "utf-8");  //设置编码语言
	            connection.setRequestProperty("Connection", "keep-alive");  //设置连接的状态
	            connection.setRequestProperty("Authorization", token);
	            connection.connect();// 连接会话
	            // 获取输入流
	            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
	            String line;
	            StringBuilder sb = new StringBuilder();
	            while ((line = br.readLine()) != null) {// 循环读取流
	                sb.append(line);
	            }
	            br.close();// 关闭流
	            connection.disconnect();// 断开连接
	            //返回结果处理
	            JSONArray jsonArray = JSON.parseArray("[" + sb.toString() + "]");
	            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	            JSONArray urlJSON = JSON.parseArray(jsonObject.get("data").toString());
	            downloadUrl = ((JSONObject) urlJSON.get(0)).get("url").toString();
	        } catch (Exception e) {
	            return "fail";
	        }
	        return downloadUrl;
	    }
	 
	 
	    /**
	     * 通过url下载文件到本地
	    **/
	    public static String  downloadFileByUrls(String urlStr,String fileName,String savePath){
	        try {
	            URL url = new URL(urlStr);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            //设置超时间为3秒
	            conn.setConnectTimeout(3 * 1000);
	            //防止屏蔽程序抓取而返回403错误
	            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
	            //得到输入流
	            InputStream inputStream = conn.getInputStream();
	            //获取自己数组
	            byte[] getData = readInputStream(inputStream);
	            //文件保存位置
	            File saveDir = new File(savePath);
	            if (!saveDir.exists()) {
	                saveDir.mkdir();
	            }
	            File file = new File(saveDir + File.separator + fileName);
	            FileOutputStream fos = new FileOutputStream(file);
	            fos.write(getData);
	            if (fos != null) {
	                fos.close();
	            }
	            if (inputStream != null) {
	                inputStream.close();
	            }
	            return "ok";
	        }catch (Exception e){
	            e.printStackTrace();
	            return "fail";
	        }
	    }
	 
	 
	 
	 
	    /**
	     * 从输入流中获取字节数组
	     */
	    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        while((len = inputStream.read(buffer)) != -1) {
	            bos.write(buffer, 0, len);
	        }
	        bos.close();
	        return bos.toByteArray();
	    }
	}
