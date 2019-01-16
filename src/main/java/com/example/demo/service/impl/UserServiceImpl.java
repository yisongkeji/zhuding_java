package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.ReturnUser;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import com.example.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		//return 0;
		return userMapper.insertSelective(record);
	}

	@Override
	public User QueryUser(String facebookid) {
		// TODO Auto-generated method stub
		return userMapper.QueryUser(facebookid);
	}

	@Override
	public List<Integer> QueryUserByCity(User user) {
		// TODO Auto-generated method stub
		return userMapper.QueryUserByCity(user);
	}

	@Override
	public int updateByFaceIDSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByFaceIDSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectUserlist(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectUserlistbyCountry(user);
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(example);
	}

	@Override
	public List<Integer> QueryUserByNUM(Integer paihang, Integer getnum) {
		// TODO Auto-generated method stub
		return userMapper.QueryUserByNUM(paihang, getnum);
	}

	@Override
	public List<Integer> QueryUserByqueNUM(Map map) {
		// TODO Auto-generated method stub
		return userMapper.QueryUserByqueNUM(map);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}


}
