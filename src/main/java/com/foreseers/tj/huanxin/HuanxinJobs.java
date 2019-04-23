package com.foreseers.tj.huanxin;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.foreseers.tj.action.UserCanumsAction;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.User;
import com.foreseers.tj.service.UserCanumsService;
import com.foreseers.tj.service.UserService;

@Component
public class HuanxinJobs {

	 private static Logger log = LoggerFactory.getLogger(HuanxinJobs.class);
	
	 @Autowired
	 private UserCanumsService userCanumsService;
	 
	 @Autowired
	 private UserService userService;
	 
	 /*
	  *每天一点 保存前一天的聊天记录
	  */
	@Scheduled(cron="0 0 1 * * ?")
	public void getMessages() throws ClientProtocolException, IOException {
		
	  	huanxin hx = new huanxin();
		hx.gettime();
		String token =  hx.getToken();
		//System.out.println(token);
		hx.getMessage(token);
		log.info("保存前一天的聊天记录");
		//删除下载的压缩包
		 hx.delpackage();
		log.info("删除下载的文件");
	}
	
	/*
	 * 每天晚上十二点，更新用户的擦子数
	 */
	@Scheduled(cron="0 0 0 * * ?")
	public void updateUserNums() {
		log.info("更新会员擦子数方法");
		LocalTime localtime = LocalTime.now(); 

		userCanumsService.updateUserNums();
	}
	
	/*
	 * 注册测试用户
	 
//	@Scheduled(cron = "0 15 15 22 4 ?")
	public void insertUserBath() throws ClientProtocolException, IOException, BusinessExpection, InterruptedException {
		int num = 0;
		
		log.info("现在的时间是："+new Date());
		
		while(num < 50)
		{
			num++;
			Map<String,Object> parmap = new HashMap<>();
			parmap.put("username", "测试"+num);
			parmap.put("date", "1993-04-16");
			parmap.put("time", "15:00:00");
			parmap.put("gender", "F");
			parmap.put("facebookid", "100000000"+num);
			parmap.put("zone", 28);
			parmap.put("country", "香港");
			parmap.put("city", "九龍");
			parmap.put("area", "香港");
			parmap.put("spare", "");
			parmap.put("spare1", "好兆年行");
			parmap.put("lat", "22.3031636");
			parmap.put("lng", "114.175174");
			parmap.put("zoneString", "UTC+08:00");
			User user = userService.insertUser(parmap);
			User userinfo = new User();
			userinfo.setId(user.getId());
			userinfo.setHead("https://chat.foreseers.cn:443/132/dad295a5ca84508a472763e383695e98.jpg");
			userinfo.setPicture("https://chat.foreseers.cn:443/132/1555487664595.jpg");
			userService.updateByPrimaryKeySelective(userinfo);
			log.info("注册成功");
			Thread.sleep(10000);
		}
		
	}
	*/
}
