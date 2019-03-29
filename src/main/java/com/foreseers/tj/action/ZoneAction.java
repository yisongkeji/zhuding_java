package com.foreseers.tj.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.LocationUtils;
import com.foreseers.tj.http.httpmatching;
import com.foreseers.tj.mapper.ZoneMapper;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserExample;
import com.foreseers.tj.model.Usermatch;
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.UsermatchService;
import com.foreseers.tj.service.ZoneService;

@Controller
public class ZoneAction{

	private static final Logger log = LoggerFactory.getLogger(ZoneAction.class);
	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private UsermatchService usermatchService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ZoneMapper zoneMapper;
	
	@RequestMapping("/gettime")
	@ResponseBody
	public String  getTimezone(HttpServletRequest re) {
		String name = re.getParameter("name");
	//	Timezone zone =  zoneService.selectByName(name);
	//	String date = re.getParameter("date");
	//	 Date datetime = new Date();
	//	 int age = datetime.getYear()+1900-Integer.parseInt(date);

		
		return name;
		
	}

	@RequestMapping("/testMap")
	@ResponseBody
	public String testMAP(@RequestBody User  request) {
		log.info("name:"+request.getUsername());
		

		return request.toString();
	}

	@RequestMapping("/testMap1")
	@ResponseBody
	public void testMAP1(@RequestBody  String  usertest) {
		log.info("name:"+usertest.toString());
		
		JSONObject json = JSONObject.parseObject(usertest);
		String name = json.getString("username");
		String sex = json.getString("sex");
		log.info("name:"+name);
		log.info("sex:"+sex);
		
	//	return username;
	}
	
	
}
