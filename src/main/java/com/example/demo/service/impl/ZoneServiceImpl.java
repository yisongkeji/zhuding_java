package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.ZoneMapper;
import com.example.demo.model.ReturnUser;
import com.example.demo.model.Timezone;
import com.example.demo.model.User;
import com.example.demo.model.Usermatch;
import com.example.demo.service.UsermatchService;
import com.example.demo.service.ZoneService;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {

	@Autowired
	private ZoneMapper zoneMapper;

	@Autowired
	private UsermatchService usermatchService;
	
	@Override
	public Timezone selectByName(String name) {
		// TODO Auto-generated method stub
		return zoneMapper.selectByName(name);
	}

	@Override
	public Timezone selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return zoneMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ReturnUser> usermatchQuery(List<User> userlist) {
		List<ReturnUser> returnUserlist = new ArrayList<ReturnUser>();
	    for(int i=0;i<userlist.size();i++) {
	    	ReturnUser returnUser = new ReturnUser();
	    	User userinfo = userlist.get(i);
	    	Usermatch usermatch =	usermatchService.usermatchQuery(userinfo.getId(),3);
	    	//userinfo.getId();
	    	if(usermatch != null) {
	    	returnUser.setUserscore(usermatch.getUserscore());
	    	returnUser.setDistance(usermatch.getDistance());
	    	}
	    	BeanUtils.copyProperties(userinfo, returnUser);
	    	returnUserlist.add(returnUser);
	    }
	  //  Collections.reverse(returnUserlist);
	    
	    Collections.sort(returnUserlist);
	
		
		
		return returnUserlist;
	}


}
