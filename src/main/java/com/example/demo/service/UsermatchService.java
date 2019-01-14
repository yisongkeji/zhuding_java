package com.example.demo.service;

import com.example.demo.model.Usermatch;
import com.example.demo.model.UsermatchWithBLOBs;

public interface UsermatchService {

	 int insertSelective(UsermatchWithBLOBs record);
	
	UsermatchWithBLOBs selectByPrimaryKey(Integer id);
	
	UsermatchWithBLOBs usermatchQuery(Integer zhuid,Integer congid);
}
