package com.foreseers.tj.huanxin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpHuanxin {

	
	 public  CloseableHttpResponse sendPostDataByJson(String url, String json, String encoding,String token) throws ClientProtocolException, IOException {
	        String result = "";


	        // 创建httpclient对象
	        CloseableHttpClient httpClient = HttpClients.createDefault();

	        // 创建post方式请求对象
	        HttpPost httpPost = new HttpPost(url);

	        // 设置参数到请求对象中
	       
	        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
	        stringEntity.setContentEncoding("utf-8");
	        httpPost.setEntity(stringEntity);
	        httpPost.setHeader("Content-Type:","application/json");
	        if(token!= null) {
	        	httpPost.setHeader("Authorization", "Bearer "+token);
	        }
	        // 执行请求操作，并拿到结果（同步阻塞）
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	        // 获取结果实体
	        // 判断网络连接状态码是否正常(0--200都数正常)
//	        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//	            result = EntityUtils.toString(response.getEntity(), "utf-8");
//	        }

	        // 释放链接
	    //    response.close();

	        return response;
	    }
	
	  /**
	     * get请求传输数据
	     * 
	     * @param url
	     * @param encoding
	     * @return
	     * @throws ClientProtocolException
	     * @throws IOException
	     */
	    public CloseableHttpResponse sendGetData(String url, String encoding,String token) throws ClientProtocolException, IOException {
	        String result = "";

	        // 创建httpclient对象
	        CloseableHttpClient httpClient = HttpClients.createDefault();

	        // 创建get方式请求对象
	        HttpGet httpGet = new HttpGet(url);
	        httpGet.addHeader("Content-type", "application/json");
	        if(token!= null) {
	        	httpGet.setHeader("Authorization", "Bearer "+token);
	        }
	        // 通过请求对象获取响应对象
	        CloseableHttpResponse response = httpClient.execute(httpGet);

	        // 获取结果实体
	        // 判断网络连接状态码是否正常(0--200都数正常)
//	        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//	            result = EntityUtils.toString(response.getEntity(), "utf-8");
//	        }
	        // 释放链接
	    //    response.close();

	        return response;
	    }
	 
	 @Test
	  public void testSendPostDataByJson() throws ClientProtocolException, IOException {
		    
	       String hstr=  "http://a1.easemob.com/1106190114019314/foreseers/users";
	       Map<String, String> maph = new HashMap<String, String>();
	        maph.put("username", "2");
	        maph.put("password", "123");	
	        
	        String url=  "http://a1.easemob.com/1106190114019314/foreseers/token";
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("grant_type","client_credentials");
	        map.put("client_id","YXA6HlxXgBiWEemPQ-MnLEqLUg");
	        map.put("client_secret","YXA6GloiOfyJ83aGrpEkFlIaQ3X1dsc");
	        
	        
	        CloseableHttpResponse rebody = sendPostDataByJson(url, JSON.toJSONString(map), "utf-8",null);
	          System.out.println(rebody.getStatusLine().getStatusCode());
	          String result =  EntityUtils.toString(rebody.getEntity(),"utf-8");
	          JSONObject job = JSON.parseObject(result);
	          String token = job.getString("access_token");
	       //   String token = "qkwjbejq";
	          System.out.println(token);
	          rebody.close();
	          String urll =  "http://a1.easemob.com/1106190114019314/foreseers/chatmessages/2019012310"; 
//	          Map<String, String> mapd = new HashMap<String, String>();
//	          mapd.put("Authorization","Bearer ${"+token+"}");
//	          System.out.println("Bearer ${"+token+"}");
	          CloseableHttpResponse rebodyd = sendGetData(urll,"utf-8",token);
	          System.out.println(rebodyd.getStatusLine().getStatusCode());
	          System.out.println(EntityUtils.toString(rebodyd.getEntity(), "utf-8"));
	          
	          rebodyd.close();
	       //   System.out.println(rebody.getStatusLine().getStatusCode());
	       //   System.out.println(EntityUtils.toString(rebody.getEntity(),"utf-8"));
	        
	 }
	 
	 
}
