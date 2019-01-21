package com.foreseers.tj.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.mapper.ZoneMapper;
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.Usermatch;
import com.foreseers.tj.service.UsermatchService;
import com.foreseers.tj.service.ZoneService;

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
