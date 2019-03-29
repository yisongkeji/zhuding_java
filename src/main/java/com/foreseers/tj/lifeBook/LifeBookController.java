package com.foreseers.tj.lifeBook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.ResultType;

@Controller
@RequestMapping("/LifeBook")
public class LifeBookController {

	private static final Logger log = LoggerFactory.getLogger(LifeBookController.class);
	@Autowired
	private LifeBookService lifeBookService;
	
	/*
	 * 创建命书
	 */
	@RequestMapping("/lifeBook")
	@ResponseBody
	public ResultType lifeBook(HttpServletRequest request) throws BusinessExpection, ClientProtocolException, IOException {
		log.info("进入创建命书方法");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
	//	String isLeap = request.getParameter("isLeap");
		String gender = request.getParameter("gender");
		String timezone = request.getParameter("timezone");
		String userid = request.getParameter("userid");
		
		
		Map<String,String> map = new HashMap<>();
		map.put("name", name);
		map.put("date", date);
		map.put("time", time);
		map.put("gender", gender);
		map.put("timezone", timezone);
		map.put("userid", userid);
	//	map.put("isLeap", isLeap);
		
		Map retuenmap =  lifeBookService.lifeBook(map);
		
		return ResultType.creat(retuenmap);
	}
	
	/*
	 * 命书目录
	 */
	@RequestMapping("/lifeBookCate")
	@ResponseBody
	public ResultType lifeBookCate(HttpServletRequest request) throws ClientProtocolException, IOException {
		
		String lifeuserid  = request.getParameter("lifeuserid");
		
		List<Map> list = lifeBookService.lifeBookCate(Integer.parseInt(lifeuserid));
		return ResultType.creat(list);
	}
	
	/*
	 * 算命
	 */
	@RequestMapping("/lifeBookDetail")
	@ResponseBody
	public String lifeBookDetail(HttpServletRequest request) throws NumberFormatException, ClientProtocolException, IOException, BusinessExpection {
		
		String name =  request.getParameter("name");
		String lifeuserid = request.getParameter("lifeuserid");
		log.info("name:"+name);
		lifeBookService.lifeBookDetail(name,Integer.parseInt(lifeuserid));
		
		return null;
	}
	
	/*
	 * 命书用户目录
	 */
	@RequestMapping("/lifeUser")
	@ResponseBody
	public ResultType lifeUser(HttpServletRequest request) {
		log.info("进入命书用户列表接口");
		String userid = request.getParameter("userid");
		List<Map> returnlist =  lifeBookService.lifeUser(Integer.parseInt(userid));
		
		log.info("返回的参数："+returnlist);
		
		return ResultType.creat(returnlist);
	}
}
