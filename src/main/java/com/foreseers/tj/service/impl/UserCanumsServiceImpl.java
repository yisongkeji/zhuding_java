package com.foreseers.tj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.action.UserCanumsAction;
import com.foreseers.tj.mapper.UserCanumsMapper;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.model.UserCanumsExample;
import com.foreseers.tj.service.UserCanumsService;

@Service
@Transactional
public class UserCanumsServiceImpl implements UserCanumsService {

	private static final Logger log = LoggerFactory.getLogger(UserCanumsServiceImpl.class);
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

	@Override
	@Transactional
	public void updateUserNums() {
		// TODO Auto-generated method stub、
		log.info("进入方法");
		UserCanums userCanums = new UserCanums();
		userCanums.setEveryday(1);
		userCanums.setVipeveryday(1);
		List<Integer> list =  userCanumsMapper.selectUserNums(userCanums);
		log.info("lists:"+list);
		if(list.size()>0) {
//			Map<String,Object> map = new HashMap<String,Object>();	
//			map.put("ids", ids);
			userCanumsMapper.updateUserNums(list);
			log.info("更新成功");
		}

	}

	@Override
	public int updateBuyNums(UserCanums userCanums) {
		// TODO Auto-generated method stub
		return userCanumsMapper.updateBuyNums(userCanums);
	}

}
