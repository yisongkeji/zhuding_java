package com.foreseers.tj.huanxin;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HuanxinJobs {

	//private static Logger log = LoggerFactory.getLogger(HuanxinJobs.class);
	 private static Logger log = LoggerFactory.getLogger(HuanxinJobs.class);
	
	//@Scheduled(cron="0 0,55 0,17 ? * ? ")
	//@Scheduled(cron="0 0 1 * * ?")  //每天一点的执行
	@Scheduled(cron="0 0,14 0,11 ? * ? ")
	public void getMessages() throws ClientProtocolException, IOException {
		
		//System.out.println("现在的时间是："+new Date());
	  	huanxin hx = new huanxin();
		hx.gettime();
		String token =  hx.getToken();
		//System.out.println(token);
		hx.getMessage(token);
		log.info("保存前一天的聊天记录");
	}
	
	
}
