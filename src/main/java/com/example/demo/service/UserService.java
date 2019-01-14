package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.model.UserExample;

public interface UserService {

	 int insertSelective(User record);
	 User QueryUser(String facebookid);
	 
	 List<Integer> QueryUserByCity(User user);
	 
	 int updateByFaceIDSelective(User record);
	 User selectByPrimaryKey(Integer id);
	 
	 List<User> selectUserlist(User user);
	 
	 List<User> selectByExample(UserExample example);
}
