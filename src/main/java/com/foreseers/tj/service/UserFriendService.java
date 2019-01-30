package com.foreseers.tj.service;

import com.foreseers.tj.model.UserFriend;

public interface UserFriendService {
	
	 int insertSelective(UserFriend record);

	int selectcountnum(String userid);

	

}
