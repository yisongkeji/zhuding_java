package com.foreseers.tj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.mapper.UserCanumsMapper;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.service.UserCanumsService;

@Service
@Transactional
public class UserCanumsServiceImpl implements UserCanumsService {

	@Autowired
	private UserCanumsMapper userCanumsMapper;
	
	@Override
	public UserCanums selectByUserKey(Integer userid) {
		// TODO Auto-generated method stub
		return userCanumsMapper.selectByUserKey(userid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserCanums record) {
		// TODO Auto-generated method stub
		return userCanumsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertSelective(UserCanums record) {
		// TODO Auto-generated method stub
		return userCanumsMapper.insertSelective(record);
	}

}
