package com.foreseers.tj.service.impl;

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

}
