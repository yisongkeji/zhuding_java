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

import com.foreseers.tj.action.BaseAction;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;

@Controller
@RequestMapping("/LifeBook")
public class LifeBookController extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(LifeBookController.class);
	@Autowired
	private LifeBookService lifeBookService;
	
	/*
	 * 创建命书
	 */
	@RequestMapping("/lifeBook")
	@ResponseBody
	public ResultType lifeBook(HttpServletRequest request) throws BusinessExpection,  IOException {
		log.info("进入创建命书方法");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
	//	String isLeap = request.getParameter("isLeap");
		String gender = request.getParameter("gender");
		String timezone = request.getParameter("timezone");
		String userid = request.getParameter("userid");
		
		if(userid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		
		Map<String,String> map = new HashMap<>();
		map.put("name", name);
		map.put("date", date);
		map.put("time", time);
		map.put("gender", gender);
		map.put("timezone", timezone);
		map.put("userid", userid);
	//	map.put("isLeap", isLeap);
		log.info("请求的参数：map:"+map);
		
		Map retuenmap =  lifeBookService.lifeBook(map);
		
		return ResultType.creat(retuenmap);
	}
	
	/*
	 * 命书用户详情
	 */
	@RequestMapping("/lifebookUser")
	@ResponseBody
	public ResultType lifebookUser(HttpServletRequest request) throws BusinessExpection {
		String lifeuserid = request.getParameter("lifeuserid");
		if(lifeuserid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		
		Map retuenmap =  lifeBookService.lifebookUser(Integer.parseInt(lifeuserid));
		
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
	public ResultType lifeBookDetail(HttpServletRequest request) throws NumberFormatException, ClientProtocolException, IOException, BusinessExpection {
		
		String name =  request.getParameter("name");
		String lifeuserid = request.getParameter("lifeuserid");
		log.info("请求参数：name:"+name);
		log.info("请求参数：lifeuserid:"+lifeuserid);
		if(name == null || lifeuserid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		List list = lifeBookService.lifeBookDetail(name,Integer.parseInt(lifeuserid));
		
		return ResultType.creat(list);
	}
	
	
	/*
	 * 算命详细信息
	 */
	@RequestMapping("/lifeBookDetailname")
	@ResponseBody
	public  ResultType lifeBookDetailname(HttpServletRequest request) throws BusinessExpection {
		log.info("进入算命详细信息接口");
		String lifesuerid = request.getParameter("lifesuerid");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		log.info("请求的参数：lifesuerid："+lifesuerid);
		log.info("请求的参数：name："+name);
		log.info("请求的参数：title："+title);
		if(lifesuerid == null || name == null || title == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		
		Map<String,String> map = new HashMap<>();
		map.put("name", name);
		map.put("title", title);
		map.put("lifesuerid", lifesuerid);
		
		List returnlist = lifeBookService.lifeBookDetailname(map);
		
		log.info("返回的参数："+returnlist);
		return ResultType.creat(returnlist);
	}
	
	
	
	/*
	 * 命书用户目录
	 */
	@RequestMapping("/lifeUser")
	@ResponseBody
	public ResultType lifeUser(HttpServletRequest request) throws BusinessExpection {
		log.info("进入命书用户列表接口");
		String userid = request.getParameter("userid");
		log.info("请求参数：userid："+userid);
		if(userid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		List<Map> returnlist =  lifeBookService.lifeUser(Integer.parseInt(userid));
		
		log.info("返回的参数："+returnlist);
		
		return ResultType.creat(returnlist);
	}
	
	
	/*
	 * 删除命书用户
	 */
	@RequestMapping("/deletelifeUser")
	@ResponseBody
	public ResultType deletelifeUser(HttpServletRequest request) throws BusinessExpection {
		String userid = request.getParameter("userid");
		String lifeuserid = request.getParameter("lifeuserid");
		log.info("请求参数：userid："+userid);
		log.info("请求参数：lifeuserid："+lifeuserid);
		if(userid == null || lifeuserid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		Boolean result =  lifeBookService.deletelifeUser(Integer.parseInt(userid),Integer.parseInt(lifeuserid));
		if(result) {
			return ResultType.creat(result);
		}
		
		return ResultType.creat(result,"fail");
	}
	
}
