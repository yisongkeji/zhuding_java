package com.foreseers.tj.google;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.httptest;
import com.foreseers.tj.mapper.LifebookMapper;
import com.foreseers.tj.mapper.UserTransactionMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.DtProduct;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.Lifebook;
import com.foreseers.tj.model.ReturnProduct;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.model.UserTransaction;
import com.foreseers.tj.service.DtProductService;
import com.foreseers.tj.service.UserCanumsService;
import com.foreseers.tj.service.UserService;

@Service
@Transactional
public class GooglePayServiceImpl implements GooglePayService {

	private final static Logger log = LoggerFactory.getLogger(GooglePayServiceImpl.class);
	
	@Autowired
	private DtProductService dtProductService;
	@Autowired
	private UserCanumsService userCanumsService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserTransactionMapper userTransactionMapper;
	@Autowired
	private LifebookMapper lifebookMapper;
	
	@Override
	@Transactional
	public Map check(String productId,String purchaseToken,String userid,String lifeuserid) throws Exception {
	
		
		
		log.info("item"+productId);
		log.info("code"+purchaseToken);
		//支付校验,调用命书接口判断

		String url = "https://api2047.foreseers.com/Dating/verifyInapp"; //命书接口地址
		Map<String,Object> map = new HashMap<>();
		map.put("item", productId);
		map.put("code", purchaseToken);
		map.put("os", "android");
		
		String result =  httptest.sendPostDataByJson(url, JSON.toJSONString(map), "utf-8");
		log.info("得到命书支付校验的返回值"+result);
		//判断是否购买成功。
		JSONObject jsn = JSON.parseObject(result);
		
		Map<String,Object> returnmap = new HashMap<>();
		returnmap.put("productId", productId);
		returnmap.put("purchaseToken", purchaseToken);

		//如果成功，判断是购买的什么，进行相应的操作。并通知前端购买成功
	//	if(jsn.getString("errCode").equals("200")) {
		
		if(jsn.getString("errCode").equals("200")) {
			
		
			String orderId = jsn.getString("orderId");
			if(orderId != "" && orderId != null) {	
				log.info("支付成功");			
				String item = jsn.getString("item");
				log.info("检验结果返回的item："+item);
			
				//通过返回的item，判断购买的是什么， 进行相应的操作	
				DtProduct dtProduct = dtProductService.selectByProductID(productId);  //通过订单查询商品
			
				log.info("查询到的商品："+dtProduct);

				updateUser(dtProduct,userid);   //更新用户的擦子或者vip
				
				if(productId.equals("com.foreseers.chat.iap100")) {
					log.info("购买的全套命书");
					List<ReturnProduct>  list = dtProductService.getIapList();
					log.info("iaplist:"+list);
					UserTransaction userTransaction = new UserTransaction();
					for(int i= 0; i< list.size();i++) {
						ReturnProduct returnProduct = list.get(i);
						log.info("returnProduct :" +returnProduct);
						log.info("商品ID："+returnProduct.getGoogleID());
						if(!returnProduct.getGoogleID().equals("com.foreseers.chat.iap6")) {
							log.info("不是2018流年運程");
							//判断表里是否存在
							UserTransaction userTransactioninfo = new UserTransaction();
							userTransactioninfo.setLifeuserId(Integer.parseInt(lifeuserid));
							userTransactioninfo.setItem(returnProduct.getGoogleID());;
							UserTransaction userTransaction1 = userTransactionMapper.selectByUserTransaction(userTransactioninfo);
							if(userTransaction1 == null) {
							//
								Lifebook lifebook = lifebookMapper.selectByPrimaryKey(Integer.parseInt(lifeuserid));
								userTransaction.setLifeuserId(Integer.parseInt(lifeuserid));
								userTransaction.setUserDate(lifebook.getDate());
								userTransaction.setUserTime(lifebook.getTime());
								userTransaction.setUserName(lifebook.getName());
								userTransaction.setGender(lifebook.getGender());							
								userTransaction.setUserId(Integer.parseInt(userid));
								userTransaction.setItem(returnProduct.getGoogleID());
								userTransaction.setCode(purchaseToken);
								userTransaction.setOs("A");
								userTransaction.setTransactionId(orderId);  
								
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Date date = new Date();
								String createTime = format.format(date);
								userTransaction.setCreateTime(createTime);
								log.info("将交易信息保存到数据库："+userTransaction);
								userTransactionMapper.insertSelective(userTransaction); //保存到数据库
							}
						}
					}
					
					
				}else {
				//保存交易记录		
					UserTransaction userTransaction = new UserTransaction();
					if(lifeuserid == null) {
						User user = userService.selectByPrimaryKey(Integer.parseInt(userid));
						userTransaction.setUserDate(user.getDate());
						userTransaction.setUserTime(user.getTime());
						userTransaction.setUserName(user.getUsername());
						userTransaction.setGender(user.getSex());
					}else {
						Lifebook lifebook = lifebookMapper.selectByPrimaryKey(Integer.parseInt(lifeuserid));
						userTransaction.setLifeuserId(Integer.parseInt(lifeuserid));
						userTransaction.setUserDate(lifebook.getDate());
						userTransaction.setUserTime(lifebook.getTime());
						userTransaction.setUserName(lifebook.getName());
						userTransaction.setGender(lifebook.getGender());
					}
					
					userTransaction.setUserId(Integer.parseInt(userid));
					userTransaction.setItem(productId);
					userTransaction.setCode(purchaseToken);
					userTransaction.setOs("A");
					userTransaction.setTransactionId(orderId);  
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = new Date();
					String createTime = format.format(date);
					userTransaction.setCreateTime(createTime);
					log.info("将交易信息保存到数据库："+userTransaction);
					userTransactionMapper.insertSelective(userTransaction); //保存到数据库
				}
				//保存交易记录
				returnmap.put("status", 1);
				
       
			 }else {
					//如果校验是失败的
					log.info("支付失败");
					returnmap.put("status", 0);
			 } 
			 		
				
		}else {
			//如果校验是失败的
			log.info("支付失败");
			returnmap.put("status", 0);
		}
		
		log.info("返回值："+returnmap);
		return returnmap;
		
		
	}
	

  public void updateUser(DtProduct dtProduct,String userid) throws NumberFormatException, ParseException, BusinessExpection {
	
	try {
		//DtProduct dtProduct = (DtProduct)parmap.get("DtProduct");
		//String userid = (String)parmap.get("userid");
		
		if(dtProduct.getType().equals("item")) {
			//购买的擦字数
			int num = dtProduct.getSpareint();
			log.info("购买的擦子数为："+num);
			//进行更新擦子数的方法
			UserCanums userCanums = new UserCanums();
			userCanums.setUserid(Integer.parseInt(userid));
			userCanums.setBuynums(num);
			userCanumsService.updateBuyNums(userCanums);
			log.info("更新用户的擦子数");
			//保存交易记录
			
			//保存交易记录
		}
		if(dtProduct.getType().equals("vip")) {
			//购买的vip
			int vip = dtProduct.getSpareint();
			log.info("购买的vip的天数为："+vip);
			//进行更新用户的vip的操作
			log.info("更新用户的会员时间");
			String result =  userService.userSetvip(Integer.parseInt(userid), vip);
			if(result.equals("success")) {
				log.info("更新数据库成功");
			}else {
				
				throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"更新会员vip时间出错");
			}			
			//保存交易记录
			
			//保存交易记录
		}

	}catch(Exception e) {
		log.error(e.getMessage());
		throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"更新用户信息出错");
	}
		
		
		
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

}
