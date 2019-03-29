package com.foreseers.tj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foreseers.tj.model.DtProduct;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.service.DtProductService;

@Controller
@RequestMapping("/product")
public class DtProductAction extends BaseAction{

	private final static Logger log = LoggerFactory.getLogger(DtProductAction.class);
	
	@Autowired
	private DtProductService dtProductService;
	
	/*
	 * 获得商品列表
	 */
	@RequestMapping("/getProduct")
	@ResponseBody
	public ResultType getProduct(HttpServletRequest request) {
		log.info("进入商品列表方法");
		List list = dtProductService.getProduct();
		
		return ResultType.creat(list);
	}
	
	
	/*
	 * 获得命书商品列表		
	@RequestMapping("/getIapList")
	@ResponseBody
	public ResultType getIapList() {
		
		List list = dtProductService.getIapList();
		
		return ResultType.creat(list);
	}
	 */
	
}
