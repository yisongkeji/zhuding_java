package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.UsermatchMapper;
import com.example.demo.model.Usermatch;
import com.example.demo.model.UsermatchWithBLOBs;
import com.example.demo.service.UsermatchService;

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
