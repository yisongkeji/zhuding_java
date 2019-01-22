package com.foreseers.tj.huanxin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class HttpHuanxin {

	
	 public  CloseableHttpResponse sendPostDataByJson(String url, String json, String encoding) throws ClientProtocolException, IOException {
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
	
	 @Test
	  public void testSendPostDataByJson() throws ClientProtocolException, IOException {
		    
	       String hstr=  "http://a1.easemob.com/1106190114019314/foreseers/users";
	       Map<String, String> maph = new HashMap<String, String>();
	        maph.put("username", "2");
	        maph.put("password", "123");	
	        
	        CloseableHttpResponse rebody = sendPostDataByJson(hstr, JSON.toJSONString(maph), "utf-8");
	          System.out.println(rebody.getStatusLine().getStatusCode());
	          System.out.println(EntityUtils.toString(rebody.getEntity(),"utf-8"));
	          rebody.close();
	          System.out.println(rebody.getStatusLine().getStatusCode());
	          System.out.println(EntityUtils.toString(rebody.getEntity(),"utf-8"));
	        
	 }
	 
	 
}
