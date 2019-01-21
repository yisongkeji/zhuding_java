package com.foreseers.tj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.mapper.UsermatchMapper;
import com.foreseers.tj.model.Usermatch;
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UsermatchService;

@Service("usermatchService")
@Transactional
public class UsermatchServiceImpl implements UsermatchService {

	@Autowired
	private UsermatchMapper usermatchMapper;
	
	@Override
	public UsermatchWithBLOBs usermatchQuery(Integer zhuid, Integer congid) {
		// TODO Auto-generated method stub
		return usermatchMapper.usermatchQuery(zhuid,congid);
	}

	@Override
	public UsermatchWithBLOBs selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return usermatchMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(UsermatchWithBLOBs record) {
		// TODO Auto-generated method stub
		return usermatchMapper.insertSelective(record);
	}

	@Override
	public int updateByzhuidKeySelective(UsermatchWithBLOBs record) {
		// TODO Auto-generated method stub
		return usermatchMapper.updateByzhuidKeySelective(record);
	}

}
