package com.foreseers.tj.service.impl;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreseers.tj.mapper.UserLookHistoryMapper;
import com.foreseers.tj.model.UserLookHistory;
import com.foreseers.tj.service.UserLookHistoryService;

@Service
public class UserLookHistoryServiceImpl implements UserLookHistoryService {

	private static final Logger log = LoggerFactory.getLogger(UserLookHistoryServiceImpl.class);
	
	@Autowired
	private UserLookHistoryMapper userLookHistoryMapper;
	
	@Override
	public String updateUserLook(int userid, int lookid) {
		// TODO Auto-generated method stub
		try {
			UserLookHistory userLookHistory = new UserLookHistory();
			userLookHistory.setUserid(userid);
			userLookHistory.setLookid(lookid);
			UserLookHistory  userLookHistoryinfo = userLookHistoryMapper.selectByUserLookHistory(userLookHistory);
			log.info("userLookHistoryinfo:"+userLookHistoryinfo);
			if(userLookHistoryinfo == null) {
				log.info("用户没有查看过此用户");
				LocalDate localDate = LocalDate.now();
				DateTimeFormatter  dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//	DateFormatter  dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String looktime = localDate.format(dateformat);
				userLookHistory.setLooktime(looktime);
				userLookHistoryMapper.insertSelective(userLookHistory);
				log.info("将信息插入到数据库");
			}
			return "success";
			
		}catch(Exception r) {
			log.error("更新失败");
			return "fail";
		}
		
	}

}
