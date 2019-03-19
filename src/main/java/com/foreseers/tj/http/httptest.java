package com.foreseers.tj.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

//import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.google.GooglePayServiceImpl;

/**
 * http客户端
 * 
 * 
 * @author：qi
 * @date：2019年1月24日 
 */
public class httptest {

	private final static Logger log = LoggerFactory.getLogger(httptest.class);
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
        log.info("调用接口");
        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        log.info("得到httpClient");
        HttpPost httpPost = new HttpPost(url);
        log.info("得到httpPost");
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

       log.info("调用接口");
        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
       log.info("得到httpPost");
        // 设置参数到请求对象中
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type:","application/json");
        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
        log.info("得到response");
        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
      	log.info(response.getStatusLine().getStatusCode()+"");
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
    
    /**
     * post请求传输数据
     * 
     * @param url
     * @param encoding
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String sendPostData(String url, String encoding) throws ClientProtocolException, IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建get方式请求对象
        HttpPost httpPost = new HttpPost(url);
     //   httpPost.addHeader("Content-type", "application/json");
        // 通过请求对象获取响应对象
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

    public  String sendPostDataByJson1(String url, String json, String encoding) throws ClientProtocolException, IOException {
        String result = "";

       log.info("调用接口");
        // 创建httpclient对象
       CloseableHttpClient httpClient = HttpClients.createDefault();
      //  HttpClient httpClient = new DefaultHttpClient(); 
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
       log.info("得到httpPost");
        // 设置参数到请求对象中
       httpPost.setProtocolVersion(HttpVersion.HTTP_1_0);
       httpPost.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
       StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type:","application/json");
        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
      //  HttpResponse response = httpClient.execute(httpPost);
        log.info("得到response");
        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
      	log.info(response.getStatusLine().getStatusCode()+"");
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();

        return result;
    }

    
 //  @Test
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
        int i = 84;
        int a[] = {62};
        Map<String, Object> mapd = new HashMap<String, Object>();
        mapd.put("accountId", i);
        mapd.put("target",a);
        mapd.put("debug", "false");
       System.out.println(JSON.toJSONString(mapd));
       
       String url1 = "https://accounts.google.com/o/oauth2/token"; 
       String getaccess_token = "https://accounts.google.com/o/oauth2/token?grant_type=refresh_token&client_id=563766724382-i21rnc5797hr1dvtu8o0t31lu71gu6sb.apps.googleusercontent.com&client_secret=xUawulHpjGo81RgZleM56unW&refresh_token=1/EGrzSJK-HAx1Li0PaRNBX7E2jVuphgDz7N-YDbFFm1Q";      
   	Map<String,String> map1 = new HashMap();
	map.put("client_id", "563766724382-i21rnc5797hr1dvtu8o0t31lu71gu6sb.apps.googleusercontent.com");
	map.put("grant_type", "refresh_token");
	map.put("client_secret", "xUawulHpjGo81RgZleM56unW");
	map.put("refresh_token", "1/EGrzSJK-HAx1Li0PaRNBX7E2jVuphgDz7N-YDbFFm1Q");
        String rebody = sendPostDataByJson1(getaccess_token,JSON.toJSONString(map1), "utf-8");
       System.out.println(rebody);
       
       /*
       final String CLIENT_ID = "563766724382-i21rnc5797hr1dvtu8o0t31lu71gu6sb.apps.googleusercontent.com";
		final String CLIENT_SECRET = "xUawulHpjGo81RgZleM56unW";
		final String REFRESH_TOKEN = "1/EGrzSJK-HAx1Li0PaRNBX7E2jVuphgDz7N-YDbFFm1Q";

       URL urlGetToken = new URL("https://accounts.google.com/o/oauth2/token");
       HttpURLConnection connectionGetToken = (HttpURLConnection) urlGetToken.openConnection();
       connectionGetToken.setRequestMethod("POST");
       connectionGetToken.setDoOutput(true);
       OutputStreamWriter writer  = new OutputStreamWriter(connectionGetToken.getOutputStream());
       writer.write("refresh_token="+REFRESH_TOKEN+"&");
	    writer.write("client_id="+CLIENT_ID+"&"); 
	    writer.write("client_secret="+CLIENT_SECRET+"&");
	    writer.write("grant_type=refresh_token"); 
	    writer.close();
	    if(connectionGetToken.getResponseCode() == HttpURLConnection.HTTP_OK){
	    	StringBuilder sb = new StringBuilder();
	    	BufferedReader reader = new BufferedReader(
	    			new InputStreamReader(connectionGetToken.getInputStream(), "utf-8"));
	    	String strLine = "";
	    	while((strLine = reader.readLine()) != null){
	    		sb.append(strLine);
	    	}
	    	JSONObject jo = JSONObject.parseObject((sb.toString()));
	    	String ACCESS_TOKEN = jo.getString("access_token");
	    	System.out.println(jo);
	    	System.out.println(ACCESS_TOKEN);

    }
 */
   }
}
