package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.ReturnUser;
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
	 
	 List<Integer> QueryUserByNUM(Integer paihang,Integer getnum);
	 
	 List<Integer> QueryUserByqueNUM(Map map);
}
