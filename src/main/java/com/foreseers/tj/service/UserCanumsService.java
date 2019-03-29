package com.foreseers.tj.service;

import com.foreseers.tj.model.UserCanums;

public interface UserCanumsService {

	UserCanums selectByUserKey(Integer userid);
	
	int updateByPrimaryKeySelective(UserCanums record);
	int insertSelective(UserCanums record);

	void updateUserNums();
	
	//更新购买擦擦子数
	int updateBuyNums(UserCanums userCanums);
}
