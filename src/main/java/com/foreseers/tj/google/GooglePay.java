package com.foreseers.tj.google;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foreseers.tj.action.BaseAction;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;

@Controller
@RequestMapping("/google")
public class GooglePay extends BaseAction {

	private final static Logger log = LoggerFactory.getLogger(GooglePay.class);
	@Autowired
	private GooglePayService googlePayService;
	
	@RequestMapping("/check")
	@ResponseBody
	public ResultType check(HttpServletRequest request) throws Exception {
	//	String pubkey = "";
		log.info("支付检验方法");
	//	String signtureData =  "";
	//	String signture = "";
		String signtureData = request.getParameter("signtureData");   //google 支付返回的字符串
//		String signture = request.getParameter("signture");       //返回的签名
//		if(signtureData == null || signture == null) {
//			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
//		}
	
		Boolean result = googlePayService.check(signtureData);
		
		return ResultType.creat(result);
	}
	
}
