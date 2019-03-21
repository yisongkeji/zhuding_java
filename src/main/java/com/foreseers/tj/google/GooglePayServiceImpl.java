package com.foreseers.tj.google;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.httptest;

@Service
@Transactional
public class GooglePayServiceImpl implements GooglePayService {

	private final static Logger log = LoggerFactory.getLogger(GooglePayServiceImpl.class);
	
	
	@Override
	public Map check(String signtureData,String type) throws Exception {
	
		JSONObject body = JSON.parseObject(signtureData);  //购买结果
		String productId = body.getString("productId");   //商品ID
		String purchaseToken = body.getString("purchaseToken");  
		
		log.info("item"+productId);
		log.info("code"+purchaseToken);
		//支付校验,调用命书接口判断
		// String access_token = getToken();  //得到token
		String url = "https://api2047.foreseers.com/Dating/verifyInapp"; //命书接口地址
		Map<String,Object> map = new HashMap<>();
		map.put("item", productId);
		map.put("code", purchaseToken);
		map.put("os", type);
		/*
		String result =  httptest.sendPostDataByJson(url, JSON.toJSONString(map), "utf-8");
		log.info("得到命书的接口的返回值"+result);
		//判断是否购买成功。
		JSONObject jsn = JSON.parseObject(result);
		*/
		Map<String,Object> returnmap = new HashMap<>();
		returnmap.put("productId", productId);
		returnmap.put("purchaseToken", purchaseToken);
		returnmap.put("status", 1);
		//如果成功，判断是购买的什么，进行相应的操作。并通知前端购买成功
		/*
		if(jsn.getString("errCode").equals("200")) {
			log.info("支付成功");
		//	returnmap.put("status", 1);
			//进行相应的操作	
		}else {
			//如果校验是失败的
			log.info("支付失败");
		//	returnmap.put("status", 0);
		}
		*/
		log.info("返回值："+returnmap);
		return returnmap;
		
		
	}
	
	/*
	 * 获得token
	 */
	public String getToken() throws ClientProtocolException, IOException {
		log.info("获取token");
		//获得token的连接地址
		String url = "https://accounts.google.com/o/oauth2/token";
		String getaccess_token = "https://accounts.google.com/o/oauth2/token?grant_type=refresh_token&client_id=563766724382-i21rnc5797hr1dvtu8o0t31lu71gu6sb.apps.googleusercontent.com&client_secret=xUawulHpjGo81RgZleM56unW&refresh_token=1/EGrzSJK-HAx1Li0PaRNBX7E2jVuphgDz7N-YDbFFm1Q";
		Map<String,String> map = new HashMap();
		map.put("client_id", "563766724382-i21rnc5797hr1dvtu8o0t31lu71gu6sb.apps.googleusercontent.com");
		map.put("grant_type", "refresh_token");
		map.put("client_secret", "xUawulHpjGo81RgZleM56unW");
		map.put("refresh_token", "1/EGrzSJK-HAx1Li0PaRNBX7E2jVuphgDz7N-YDbFFm1Q");
	//	httptest httptest = new httptest();
	//	String data = httptest.sendPostData(url, "UTF-8");   //sendPostDataByMap
		String data =  sendPostDataByJson(getaccess_token,JSON.toJSONString(map), "utf-8");
		log.info(data);
		JSONObject jsn = JSON.parseObject(data);
		String access_token = jsn.getString("access_token");
		log.info(access_token);
		return access_token;
	}
	
	 
	
/*
	public static boolean verify(String publicKey,String signtureData,String ssigntureign) throws Exception {

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		byte[] encodedKey = Base64.decodeBase64(publicKey);
		PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
		java.security.Signature signature = java.security.Signature.getInstance("SHA1WithRSA");
		signature.initVerify(pubKey);
		signature.update( signtureData.getBytes() );
		boolean bverify = signature.verify( Base64.decodeBase64(ssigntureign) );	
		log.info("验证值：bverify："+bverify);
        return bverify;
    }
*/
    public  String sendPostDataByJson(String url, String json, String encoding) throws ClientProtocolException, IOException {
        String result = "";

       log.info("调用接口");
        // 创建httpclient对象
       CloseableHttpClient httpClient = HttpClients.createDefault();
      //  HttpClient httpClient = new DefaultHttpClient(); 
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
       log.info("得到httpPost");
        // 设置参数到请求对象中
    //   httpPost.setProtocolVersion(HttpVersion.HTTP_1_0);
     //  httpPost.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
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

}
