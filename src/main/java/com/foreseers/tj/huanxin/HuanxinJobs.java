package com.foreseers.tj.huanxin;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.foreseers.tj.action.UserCanumsAction;
import com.foreseers.tj.service.UserCanumsService;

@Component
public class HuanxinJobs {

	//private static Logger log = LoggerFactory.getLogger(HuanxinJobs.class);
	 private static Logger log = LoggerFactory.getLogger(HuanxinJobs.class);
	
	 @Autowired
	 private UserCanumsService userCanumsService;
	 
	//@Scheduled(cron="0 0,55 0,17 ? * ? ")
	//@Scheduled(cron="0 0,14 0,11 ? * ? ")
	@Scheduled(cron="0 0 1 * * ?")
	public void getMessages() throws ClientProtocolException, IOException {
		
		//System.out.println("现在的时间是："+new Date());
	  	huanxin hx = new huanxin();
		hx.gettime();
		String token =  hx.getToken();
		//System.out.println(token);
		hx.getMessage(token);
		log.info("保存前一天的聊天记录");
	}
	
	/*
	 * 每天晚上十二点，更新用户的擦子数
	 */
	@Scheduled(cron="0 0 0 * * ?")
	public void updateUserNums() {
		log.info("更新会员擦子数方法");
		LocalTime localtime = LocalTime.now(); 
		log.info("现在的时间："+localtime);
//		UserCanumsAction userCanumsAction = new UserCanumsAction();
//		userCanumsAction.updateUserNums();
		userCanumsService.updateUserNums();
	}
	
}
