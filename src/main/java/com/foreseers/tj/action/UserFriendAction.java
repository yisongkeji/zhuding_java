package com.foreseers.tj.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserService;

@Controller
@RequestMapping("/userfriend")
public class UserFriendAction extends BaseAction{

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserFriendService userFriendService;
	
	/*
	 * 获取好友的username
	 */
	@RequestMapping("/getname")
	@ResponseBody
	public ResultType getuserFriend(HttpServletRequest request) throws BusinessExpection  {
		
	String userlist = request.getParameter("userlist");
	
	if( userlist == null ) {
		throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
	}
		List<Map> rutrnlist = new ArrayList<Map>();
		
		String[] data = userlist.split(",");	
	     for(int i=0;i<data.length;i++) {
	    Map<String,Object> returnmap = new HashMap<String,Object>();
	    	 int userid = Integer.parseInt(data[i]);
	    //	 System.out.println(data[i]);
	    	 User user = userService.selectByPrimaryKey(userid);
	    	 if(user != null) {
	    	 user.getUsername();
	    	 user.getHead();
	    	 returnmap.put("userid", userid);
	    	 returnmap.put("username", user.getUsername());
	    	 returnmap.put("userhead",  user.getHead());
	    	 rutrnlist.add(returnmap);
	    	 }/*
	    	 else {
	    		 returnmap.put("userid", userid);
	    		 returnmap.put("error", "没有这个用户");
	    		 rutrnlist.add(returnmap);
	    	 }
	    	 */
	     }	
	     
		return ResultType.creat(rutrnlist);   
	}
	
	/*
	 * 判断用户 的好友数量是否到达上线
	 */
	@RequestMapping("isfull")
	public String isfull(HttpServletRequest request) {
		String facebook = request.getParameter("facebookid");
		User user = userService.QueryUser(facebook);
		
		return null;
	}
	/*
	 * 添加好友成功
	 */
	@RequestMapping("/addfriend")
	@ResponseBody
	public ResultType addfriend(HttpServletRequest request) throws BusinessExpection {
		String userid= request.getParameter("userid");
		String friendid = request.getParameter("friendid");
		if(userid != null || friendid != null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		int reation = Integer.parseInt(request.getParameter("reation"));
		
		UserFriend userFriend = new UserFriend();
		userFriend.setUserId(userid);
		userFriend.setFriendId(friendid);
		userFriend.setUserReation(reation);
		userFriendService.insertSelective(userFriend);
		
		return ResultType.creat(userFriend);
	}
	
	
}
