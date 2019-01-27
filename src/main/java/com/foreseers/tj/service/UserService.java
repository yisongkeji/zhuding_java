package com.foreseers.tj.service;

import java.util.List;
import java.util.Map;

import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserExample;

public interface UserService {

	 int insertSelective(User record);
	 User QueryUser(String facebookid);
	 
	 List<Integer> QueryUserByCity(Map map);
	 
	 int updateByFaceIDSelective(User record);
	 User selectByPrimaryKey(Integer id);
	 
	 List<User> selectUserlist(User user);
	 
	 List<User> selectByExample(UserExample example);
	 
	 List<Integer> QueryUserByNUM(Integer paihang,Integer getnum);
	 
	 List<Integer> QueryUserByqueNUM(Map map);
	 
	 int updateByPrimaryKeySelective(User record);
}
