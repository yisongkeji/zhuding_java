package com.foreseers.tj.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreseers.tj.mapper.UserCaHistoryMapper;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.service.UserCaHistoryService;

@Service
public class UserCaHistoryServiceImpl implements UserCaHistoryService {

	@Autowired
	private UserCaHistoryMapper userCaHistoryMapper;
	
	@Override
	public int insertSelective(UserCaHistory record) {
		// TODO Auto-generated method stub
		return userCaHistoryMapper.insertSelective(record);
	}

	@Override
	public String userCaHistoryService(String userid, String caid) {
		// TODO Auto-generated method stub
		try {
		UserCaHistory userCaHistory = new UserCaHistory();
		userCaHistory.setUserid(Integer.parseInt(userid));
		userCaHistory.setCaid(Integer.parseInt(caid));
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = format.format(date);	
		userCaHistory.setUsertime(datetime);
		userCaHistoryMapper.insertSelective(userCaHistory);   //保存到数据库
		
		return "success";
				
		}catch(Exception e) {
			return "fail";
		}	
		
	}

	@Override
	public UserCaHistory selectByUserCaHistory(UserCaHistory userCaHistory) {
		// TODO Auto-generated method stub
		return userCaHistoryMapper.selectByUserCaHistory(userCaHistory);
	}

	@Override
	public List<UserCaHistory> userCaHistoryService(Integer caid) {
		// TODO Auto-generated method stub
		return userCaHistoryMapper.userCaHistoryService(caid);
	}

}
