package com.foreseers.tj.google;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
	
	
		String signtureData = request.getParameter("signtureData");   //google 支付返回的字符串
		String type = request.getParameter("type");   //google 支付返回的字符串
		log.info(signtureData);
		
		if(signtureData == null ) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
//		log.info(signtureData.toJSONString());
		Map result = googlePayService.check(signtureData,type);
		
		return ResultType.creat(result);
	}
	
}
