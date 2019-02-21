package com.foreseers.tj.service;

import java.util.List;

import com.foreseers.tj.model.UserCaHistory;

public interface UserCaHistoryService {

	int insertSelective(UserCaHistory record);

	String userCaHistoryService(String userid, String caid); 
	
	 UserCaHistory selectByUserCaHistory(UserCaHistory userCaHistory);
	 
	 List<UserCaHistory>  userCaHistoryService(Integer caid);
}
