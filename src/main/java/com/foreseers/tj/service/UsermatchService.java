package com.foreseers.tj.service;

import com.foreseers.tj.model.Usermatch;
import com.foreseers.tj.model.UsermatchWithBLOBs;

public interface UsermatchService {

	 int insertSelective(UsermatchWithBLOBs record);
	
	UsermatchWithBLOBs selectByPrimaryKey(Integer id);
	
	UsermatchWithBLOBs usermatchQuery(Integer zhuid,Integer congid);
	
	int updateByzhuidKeySelective(UsermatchWithBLOBs record);
	
	//int updateByzhuidKeySelective(UsermatchWithBLOBs record);
}
