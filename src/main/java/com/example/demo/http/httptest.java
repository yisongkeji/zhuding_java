package com.example.demo.http;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * http客户端
 * 
 * 
 * @author：WangYuanJun
 * @date：2017年12月20日 下午8:26:51
 */
public class httptest {

    /**
     * post请求传输map数据
     * 
     * @param url
     * @param map
     * @param encoding
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String sendPostDataByMap(String url, Map<String, String> map, String encoding) throws ClientProtocolException, IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        // 装填参数
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Entry<String, String> entry : map.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        // 设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, encoding));

        // 设置header信息
        // 指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();

        return result;
    }

    /**
     * post请求传输json数据
     * 
     * @param url
     * @param json
     * @param encoding
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public  String sendPostDataByJson(String url, String json, String encoding) throws ClientProtocolException, IOException {
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
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();

        return result;
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
    public String sendGetData(String url, String encoding) throws ClientProtocolException, IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建get方式请求对象
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-type", "application/json");
        // 通过请求对象获取响应对象
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();

        return result;
    }
/*
    @Test
    public void testSendPostDataByMap() throws ClientProtocolException, IOException {
        String url = "http://localhost:8080/httpService/sendPostDataByMap";
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "wyj");
        map.put("city", "南京");
        String body = sendPostDataByMap(url, map, "utf-8");
        System.out.println("响应结果：" + body);
    }
*/
    @Test
    public void testSendPostDataByJson() throws ClientProtocolException, IOException {
       // String url = "http://www.easemob.com/1122161011178276/testapp/token";
    	
    	String url = "https://api2047.foreseers.com/Dating/personalAnalysis";
    //	BigInteger big = new BigInteger();
    	BigDecimal  accountId = new BigDecimal("467979503606542");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "1988-05-10");
        map.put("time", "19:00:00");
      //  map.put("isLeap", null);
        map.put("gender", "M");
        map.put("accountId",1);
        
        String urld = "https://api2047.foreseers.com/Dating/matching";
        int i = 3;
        int a[] = {2};
        Map<String, Object> mapd = new HashMap<String, Object>();
        mapd.put("accountId", i);
        mapd.put("target",a);
        mapd.put("debug", "false");
      //  System.out.println(JSON.toJSONString(mapd));
        
        /*环信
       String hstr=  "http://a1.easemob.com/1122161011178276/testapp/token";
       Map<String, String> maph = new HashMap<String, String>();
        maph.put("grant_type", "client_credentials");
        maph.put("grant_type", "YXA6Irz_oI-GEead-FFvbfaMbQ");
        maph.put("grant_type", "YXA6VsR5JypETS3iPFvNNxYklmho0Vw");
       */  
        
        String rebody = sendPostDataByJson(urld, JSON.toJSONString(mapd), "utf-8");
        JSONObject ojb = JSON.parseObject(rebody);
        System.out.println(ojb);
        JSONArray result =   ojb.getJSONArray("result");
		for(int j = 0;j<result.size();j++) {					
			JSONObject resultjson = JSON.parseObject(result.get(j).toString());
			int user_id = resultjson.getInteger("user_id");
			
		//	System.out.println(user_id);
			String score = resultjson.get("score").toString();
			String desc = resultjson.get("desc").toString();
			JSONObject comment = JSON.parseObject(resultjson.get("comment").toString());
			String commentdesc = comment.get("desc").toString();
			String commentgood = comment.get("good").toString();
			String commentbad = comment.get("bad").toString();
			JSONObject characteristic = JSON.parseObject(resultjson.get("characteristic").toString());
			String characteristicdesc = characteristic.get("desc").toString();
			String characteristicgood = characteristic.get("good").toString();
			String characteristicbad = characteristic.get("bad").toString();
			JSONObject mind = JSON.parseObject(resultjson.get("mind").toString());
			String mindscore = mind.get("score").toString();
			String minddesc = mind.get("desc").toString();
			JSONObject body = JSON.parseObject(resultjson.get("body").toString());
			String bodyscore = body.get("score").toString();
			String bodydesc = body.get("desc").toString();
			JSONObject character = JSON.parseObject(resultjson.get("character").toString());
			String characterscore = character.get("score").toString();
			String characterdesc = character.get("desc").toString();
			
			System.out.println(score);
		System.out.println(commentdesc);
//			System.out.println(characterscore);
//			System.out.println(characterdesc);
		}
//        for(int z = 0;z<result.size();z++) {
//        	JSONObject test = result.getJSONObject(z);
//        	String  comment = test.getString("comment");
//        	JSONObject commentjs = JSON.parseObject(comment);
//        	//System.out.println(commentjs.get("desc"));
//        }

  /*
                接收ziwei的方法
        JSONArray  jsonArray  =   ojb.getJSONArray("ziwei");
    	StringBuffer ziwei =  new StringBuffer();
    	String s4 = null;
        for(int j= 0;j<jsonArray.size();j++) {
			  String ziwei1 = jsonArray.get(j).toString();
			  s4 = ziwei.append(ziwei1+",").toString();       
        }
        String s = s4.substring(0,s4.length()-1);
        System.out.println(s);
        */
    }
 
		
/*
    @Test
    public void testSendGetData() throws ClientProtocolException, IOException {
        String url = "http://localhost:8080/httpService/sendGetData?name=wyj&city=南京";
        String body = sendGetData(url, "utf-8");
        System.out.println("响应结果：" + body);
    }
*/
}
