package com.example.demo.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.ZoneMapper;
import com.example.demo.model.Timezone;
import com.example.demo.service.ZoneService;

@Controller
public class ZoneAction{

	@Autowired
	private ZoneService zoneService;
	
	@RequestMapping("/gettime")
	@ResponseBody
	public String  getTimezone(HttpServletRequest re) {
		String name = re.getParameter("name");
		Timezone zone =  zoneService.selectByName(name);
		
		return zone.toString();
		
	}
}
