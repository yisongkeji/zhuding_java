package com.example.demo.service;

import com.example.demo.model.Timezone;

public interface ZoneService {

	Timezone selectByName(String name);
	
	Timezone selectByPrimaryKey(Integer id);
}
