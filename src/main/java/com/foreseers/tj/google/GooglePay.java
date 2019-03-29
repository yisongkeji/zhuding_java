package com.foreseers.tj.google;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.action.BaseAction;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.service.UserService;

@Controller
@RequestMapping("/google")
public class GooglePay extends BaseAction {

	private final static Logger log = LoggerFactory.getLogger(GooglePay.class);
	@Autowired
	private GooglePayService googlePayService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/check")
	@ResponseBody
	public ResultType check(HttpServletRequest request) throws Exception {
	//	String pubkey = "";
		log.info("支付检验方法");
	
	
		String productId = request.getParameter("productId");   //google 支付返回的字符串
		String purchaseToken = request.getParameter("purchaseToken");   //google 支付返回的字符串
		String userid = request.getParameter("userid");
		log.info("请求参数：productId："+productId);
		log.info("请求参数：purchaseToken："+purchaseToken);
		log.info("请求参数：userid："+userid);
		
		if(productId == null || purchaseToken == null || userid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}

		Map result = googlePayService.check(productId,purchaseToken,userid);
		
		return ResultType.creat(result);
	}
	
	/*
	@RequestMapping("/testvip")
	@ResponseBody
	public String testvip() throws ParseException {
		int userid = 68;
		int vipdate = 30;
		
		String result =  userService.userSetvip(userid, vipdate);
		
		log.info("result");
		
		return result;
	}
	*/
}
