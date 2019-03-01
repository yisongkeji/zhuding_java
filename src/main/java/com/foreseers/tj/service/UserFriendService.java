package com.foreseers.tj.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.UserFriend;

public interface UserFriendService {
	
	 int insertSelective(UserFriend record);

	int selectcountnum(String userid);

	 List<String> selectlist(String userid);

	 UserFriend selectUserFriend(String user_id ,String friend_id);
	 
	 int updateByPrimaryKeySelective(UserFriend record);

	String friendTime(Map<String, Object> map);
	
	List<Map> selectUserFriendList(String userid) throws ParseException;

	String deletefriend(Map<String, Object> map) throws BusinessExpection;
	
}
