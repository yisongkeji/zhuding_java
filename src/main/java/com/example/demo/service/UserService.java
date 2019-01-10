package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	 int insertSelective(User record);
	 User QueryUser(String facebookid);
	 
	 List<Integer> QueryUserByCity(User user);
	 
	 int updateByFaceIDSelective(User record);
}
