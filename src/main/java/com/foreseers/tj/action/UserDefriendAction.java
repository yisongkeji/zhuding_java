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
import com.foreseers.tj.service.UserDefriendService;

import sun.reflect.generics.tree.ReturnType;

@Controller
@RequestMapping("/userDefriend")
public class UserDefriendAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(UserDefriendAction.class);
	@Autowired
	private UserDefriendService userDefriendService;
	
	
	/*
	 * 添加黑名单
	 */
	@RequestMapping("/pullDefriend")
	@ResponseBody
	public ResultType pullDefriend(HttpServletRequest request) {
		log.info("进入拉黑用户方法");
		String userid =  request.getParameter("userid");
		String blackid = request.getParameter("blackid");
		
		String result = userDefriendService.pullDefriend(Integer.parseInt(userid),Integer.parseInt(blackid));
		if(result.equals("success")) {
			log.info("拉黑成功");
			return ResultType.creat(result);
		}else {
			log.error("拉黑失败");
			return ResultType.creat(result,"fail");
		}
		
	}
	
	/*
	 * 获取黑名单列表
	 */
	@RequestMapping("/getBlackList")
	@ResponseBody
	public ResultType getBlackList(HttpServletRequest request) throws BusinessExpection {
		log.info("获取黑名单");
		String userid =  request.getParameter("userid");
		if(userid == null) {
			log.error("参数不合法");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		List<Map> returnlist = userDefriendService.getBlackList(Integer.parseInt(userid));
		log.info("返回的结果："+returnlist);
		return ResultType.creat(returnlist);
	}
	
	/*
	 * 移除黑名单
	 */
	@RequestMapping("/removeUser")
	@ResponseBody
	public ResultType removeUser(HttpServletRequest request) {
		log.info("进入移除黑名单操作");
		String userid = request.getParameter("userid");
		String blackid = request.getParameter("blackid");
		
		String result = userDefriendService.removeUser(Integer.parseInt(userid),Integer.parseInt(blackid));
		
		if(result.equals("success")) {
			log.info("移除成功");
			return ResultType.creat(result);
		}else {
			log.error("移除失败");
			return ResultType.creat(result,"fail");
		}
		
	}
	
}
