package com.foreseers.tj.service;

import java.util.List;

import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.Usermatch;

public interface ZoneService {

	Timezone selectByName(String name);
	
	Timezone selectByPrimaryKey(Integer id);
	
	List<ReturnUser> 	usermatchQuery(List<User> userlist);
}
