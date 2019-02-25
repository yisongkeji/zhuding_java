package com.foreseers.tj.service;

import java.util.List;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.UserCaHistory;

public interface UserCaHistoryService {

	int insertSelective(UserCaHistory record);

	String userCaHistoryService(String userid, String caid) throws BusinessExpection; 
	
	 UserCaHistory selectByUserCaHistory(UserCaHistory userCaHistory);
	 
	 List<UserCaHistory>  userCaHistoryService(Integer caid);
	
}
