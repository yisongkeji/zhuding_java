package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ZoneMapper;
import com.example.demo.model.Timezone;
import com.example.demo.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {

	@Autowired
	private ZoneMapper zoneMapper;

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

}
