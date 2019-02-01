package com.foreseers.tj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreseers.tj.mapper.UserFriendMapper;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.service.UserFriendService;

@Service
public class UserFriendServiceImpl implements UserFriendService {

	@Autowired
	private UserFriendMapper userFriendMapper;
	
	@Override
	public int insertSelective(UserFriend record) {
		// TODO Auto-generated method stub
		return userFriendMapper.insertSelective(record);
	}

	@Override
	public int selectcountnum(String userid) {
		// TODO Auto-generated method stub
		return userFriendMapper.selectcountnum(userid);
	}

	@Override
	public List<String> selectlist(String userid) {
		// TODO Auto-generated method stub
		return userFriendMapper.selectlist(userid);
	}

	@Override
	public UserFriend selectUserFriend(String user_id, String friend_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.selectUserFriend(user_id, friend_id);
	}

}
