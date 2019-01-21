package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ReturnUser;
import com.example.demo.model.Timezone;
import com.example.demo.model.User;
import com.example.demo.model.Usermatch;

public interface ZoneService {

	Timezone selectByName(String name);
	
	Timezone selectByPrimaryKey(Integer id);
	
	List<ReturnUser> 	usermatchQuery(List<User> userlist);
}
