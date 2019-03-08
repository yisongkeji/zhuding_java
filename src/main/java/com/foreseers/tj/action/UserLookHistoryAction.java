package com.foreseers.tj.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.service.UserLookHistoryService;

import sun.reflect.generics.tree.ReturnType;

@Controller
@RequestMapping("/userLook")
public class UserLookHistoryAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(UserLookHistoryAction.class);
	@Autowired
	private UserLookHistoryService userLookHistoryService;
	
	@RequestMapping("/updateUserLook")
	@ResponseBody
	public ResultType updateUserLook(HttpServletRequest request) throws BusinessExpection {
		log.info("进入更新谁看过我列表");
		String userid =  request.getParameter("userid");
		String lookid = request.getParameter("lookid");
		log.info("请求参数：userid"+userid);
		log.info("请求参数：lookid"+lookid);			
		if(userid == null || lookid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		String result =  userLookHistoryService.updateUserLook(Integer.parseInt(userid),Integer.parseInt(lookid));

		if(result.equals("success")) {
			return ResultType.creat(result);
		}else {
			return ResultType.creat(result,"fail");
		}
		
	}
	/*
	 * 查询谁看过我
	 */
	@RequestMapping("/showUserLook")
	@ResponseBody
	public ResultType showUserLook(HttpServletRequest request) throws BusinessExpection {
		log.info("进入展示谁看过我列表");
		String userid =  request.getParameter("userid");
		log.info("请求参数：userid"+userid);
		if(userid == null ) {
			log.error("参数不合法");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		
		List<List> returnlist =  userLookHistoryService.showUserLook(Integer.parseInt(userid));
		
		log.info("返回参数："+returnlist);
		return ResultType.creat(returnlist);
	}
	
	/*
	 * 通过时间查询谁看过我
	 */
	@RequestMapping("/showByDate")
	@ResponseBody
	public ResultType showByDate(HttpServletRequest request) throws BusinessExpection {
		String id =request.getParameter("userid");
		String date = request.getParameter("datetime");
		if(id == null || date == null) {
			log.error("参数不合法");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		int userid = Integer.parseInt(id);
		
		List<Map> list = userLookHistoryService.showBydate(userid,date);
		log.info("返回的参数："+list);
		return ResultType.creat(list);
	}
}
