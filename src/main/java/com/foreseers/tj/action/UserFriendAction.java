package com.foreseers.tj.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(UserFriendAction.class);
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
	log.info("进入获得好友用户名信息方法");
	String userid = request.getParameter("userid");
	log.info("请求参数：userid："+userid);
	
	if( userid == null ) {
		log.error("参数不正确");
		throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
	}
	
	List<String> userlist =  userFriendService.selectlist(userid);
		List<Map> rutrnlist = new ArrayList<Map>();
		
		
	     for(int i=0;i<userlist.size();i++) {
	    Map<String,Object> returnmap = new HashMap<String,Object>();
	    	 int id = Integer.parseInt( userlist.get(i));
	    	 UserFriend userFriend = userFriendService.selectUserFriend(userid,userlist.get(i)); //查询好友的关系
	    	 int lookhead = 0;
	    	 if(userFriend != null) {
	    		 lookhead = userFriend.getLookhead();
	    	 }
	    	 User user = userService.selectByPrimaryKey(id);
	    	 if(user != null) {
	    	 user.getUsername();
	    	 user.getHead();
	    	 returnmap.put("userid", id);
	    	 returnmap.put("username", user.getUsername());
	    	 if(lookhead == 1) {
	    		 returnmap.put("userhead",  user.getHead());
	    	 }else {
	    		 returnmap.put("userhead",  user.getPicture());
	    	 }
	    	 
	    	 rutrnlist.add(returnmap);
	    	 }
	     }	
	     log.info("返回值："+rutrnlist.toString());
		return ResultType.creat(rutrnlist);   
	}
	
	/*
	 * 判断用户 的好友数量是否到达上线
	 */
	@RequestMapping("/isfull")
	@ResponseBody
	public ResultType isfull(HttpServletRequest request) throws BusinessExpection {
		log.info("进入判断好友数量方法");
		int status = 0;
		int userint = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		String facebook = request.getParameter("facebookid");
		String friid = request.getParameter("friendid");
		log.info("facebook:"+facebook);
		log.info("请求好友id:"+friid);
		if(facebook == null || friid == null) {
			log.error("参数不正确");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}

		User user = userService.QueryUser(facebook);
	//	log.info("user:"+user);
		User userfriend = userService.selectByPrimaryKey(Integer.parseInt(friid));
		int userfriendnum =  Integer.parseInt(user.getReservedvar()); //获取用户的好友的用户数量上线
		int userfri =  Integer.parseInt(userfriend.getReservedvar());
		int userid = user.getId();
		//System.out.println(userid+"");
		int usercount = userFriendService.selectcountnum(userid+"");
		int userfir = userFriendService.selectcountnum(friid);
		if(usercount >= userfriendnum) {  //达到好友上线
			status = 1;
			log.info("自己的好友数量达到上线");
			if(userfir >= userfri ) {
				status = 2;
				log.info("请求的好友的好友数量达到上线");
			}
		}else {
			userint = userfriendnum - usercount;
			log.info("自己的好友数量剩余值："+userint);

		}

		map.put("status", status);
		map.put("userint", userint);
		log.info("返回值："+map);
		return ResultType.creat(map);
	}
	
	
	/*
	 * 添加好友成功
	 */
	@RequestMapping("/addfriend")
	@ResponseBody
	public ResultType addfriend(HttpServletRequest request) throws BusinessExpection {
		log.info("进入添加好友方法");
		String userid= request.getParameter("userid");
		String friendid = request.getParameter("friendid");
		int reation = Integer.parseInt(request.getParameter("reation"));
		log.info("请求参数：userid:"+userid);
		log.info("请求参数:friendid:"+friendid);
		log.info("请求参数:reation:"+reation);
		if(userid == null || friendid == null  ) {
			log.error("参数不正确");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String friendtime =  format.format(date);
		
		UserFriend userFriend = new UserFriend();
		userFriend.setUserId(userid);
		userFriend.setFriendId(friendid);
		userFriend.setUserReation(reation);
		userFriend.setFirendtime(friendtime);  //保存添加好友 的时间
		userFriendService.insertSelective(userFriend);
		log.info("返回值："+userFriend);
		return ResultType.creat(userFriend);
	}
	
	/*
	 * 修改好友相对应的权限
	 */
	@RequestMapping("/friendTime")
	@ResponseBody
	public ResultType friendTime(HttpServletRequest request) throws BusinessExpection {
		log.info("进入修改用户好友相对应权限方法");
		String userid= request.getParameter("userid");
		String friendid = request.getParameter("friendid");
		String lookhead= request.getParameter("lookhead");
		String sendpix= request.getParameter("sendpix");
		String lookimages= request.getParameter("lookimages");
		log.info("请求参数：userid："+userid);
		log.info("请求参数：friendid："+friendid);
		log.info("请求参数：lookhead："+lookhead);
		log.info("请求参数：sendpix："+sendpix);
		log.info("请求参数：lookimages："+lookimages);
		if(userid == null || friendid == null) {
			log.error("请求参数不合法");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		UserFriend userFriend = userFriendService.selectUserFriend(userid, friendid); 
		log.info("userFriend"+userFriend);
		String result = "";
		if(userFriend != null) { //存在好友关系
			log.info("存在好友关系");
			if(userFriend.getUserReation() == 0) {  //两用户是好友
				log.info("两人是好友");
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("lookimages", lookimages);
				map.put("sendpix", sendpix);
				map.put("lookhead", lookhead);
				map.put("uid", userFriend.getId());
				log.info("map"+map);
				result = userFriendService.friendTime(map);
				log.info("result"+result);
			}
		}
		if(result.equals("success")) {
		return ResultType.creat(result);
		}else {
			return ResultType.creat(result,"fail");		
		}
		
	}
	
}
