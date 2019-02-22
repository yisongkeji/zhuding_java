package com.foreseers.tj.action;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.service.UserCanumsService;
import com.foreseers.tj.service.UserService;

@Controller
@RequestMapping("/userCanums")
public class UserCanumsAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(UserCanumsAction.class);
	
	@Autowired
	private UserCanumsService userCanumsService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/updatenums")
	@ResponseBody
	public int updatenums(HttpServletRequest request) {
		log.info("进入更新擦子数方法");
		int userid = Integer.parseInt(request.getParameter("userid"));
		User user =  userService.selectByPrimaryKey(userid);
		int vip = user.getVip();      //vip标识
		int ststus = 0;
		int num = 0;	
		int everyday = 0;
		int vipeveryday = 0;
		UserCanums userCanums = userCanumsService.selectByUserKey(userid);
		if (userCanums.getEveryday() == 0) {
			//普通用户今天还未领取
			num = 3;
			everyday = 1;

		}
		//判断vip用户是否已领取
		if(userCanums.getVipeveryday() == 0) { //vip用户还未领取
				num = 23;
				vipeveryday= 1;
		}		
		if(num != 0 || everyday != 0 || vipeveryday != 0) {
			UserCanums userCanumsinfo = new UserCanums();
			userCanumsinfo.setId(userCanums.getId());
			userCanumsinfo.setNums(num);
			userCanumsinfo.setEveryday(everyday);
			userCanumsinfo.setVipeveryday(vipeveryday);
			userCanumsService.updateByPrimaryKeySelective(userCanumsinfo);
		}else { //都已经领取
			ststus = 1;  
		}

		
		return ststus;
	}
	
}
