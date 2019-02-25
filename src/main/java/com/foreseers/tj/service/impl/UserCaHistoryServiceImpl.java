package com.foreseers.tj.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.action.UserCaHistoryAction;
import com.foreseers.tj.mapper.UserCaHistoryMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserCanumsService;

@Service
@Transactional
public class UserCaHistoryServiceImpl implements UserCaHistoryService {
	
	private static final Logger log = LoggerFactory.getLogger(UserCaHistoryService.class);
	@Autowired
	private UserCaHistoryMapper userCaHistoryMapper;
	
	@Autowired
	private UserCanumsService userCanumsService; 
	
	@Override
	public int insertSelective(UserCaHistory record) {
		// TODO Auto-generated method stub
		return userCaHistoryMapper.insertSelective(record);
	}

	@Override
	@Transactional
	public String userCaHistoryService(String userid, String caid) throws BusinessExpection {
		// TODO Auto-generated method stub
		UserCanums userCanums = userCanumsService.selectByUserKey(Integer.parseInt(userid));
		if( userCanums == null) {
			log.error("用户信息不存在");
			throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT); 
		}
		if(userCanums.getNums() == 0) {
			log.error("用户擦字数为0,不能使用擦子");
			throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"用户擦子数为0"); 
		}

		try {
		UserCaHistory userCaHistory = new UserCaHistory();
		userCaHistory.setUserid(Integer.parseInt(userid));
		userCaHistory.setCaid(Integer.parseInt(caid));
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = format.format(date);	
		userCaHistory.setUsertime(datetime);
		userCaHistoryMapper.insertSelective(userCaHistory);   //保存到数据库
		//将用户的擦字数减一
		UserCanums userCanumsinfo = new UserCanums();
		userCanumsinfo.setId(userCanums.getId());
		userCanumsinfo.setNums(userCanums.getNums()-1);
		userCanumsService.updateByPrimaryKeySelective(userCanumsinfo);	
		
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
