package com.foreseers.tj.service;

import java.util.List;

import com.foreseers.tj.model.UserFriend;

public interface UserFriendService {
	
	 int insertSelective(UserFriend record);

	int selectcountnum(String userid);

	 List<String> selectlist(String userid);

	 UserFriend selectUserFriend(String user_id ,String friend_id);
}
