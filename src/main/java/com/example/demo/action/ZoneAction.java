package com.example.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.ZoneMapper;
import com.example.demo.model.ResultType;
import com.example.demo.model.ReturnUser;
import com.example.demo.model.Timezone;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import com.example.demo.model.Usermatch;
import com.example.demo.model.UsermatchWithBLOBs;
import com.example.demo.service.UserService;
import com.example.demo.service.UsermatchService;
import com.example.demo.service.ZoneService;

@Controller
public class ZoneAction{

	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private UsermatchService usermatchService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/gettime")
	@ResponseBody
	public String  getTimezone(HttpServletRequest re) {
		String name = re.getParameter("name");
		Timezone zone =  zoneService.selectByName(name);
		
		return zone.toString();
		
	}
	
	@RequestMapping("/testUsermatch")
	@ResponseBody
	public String testusermatch(HttpServletRequest re) {
		Integer zhuid = Integer.parseInt(re.getParameter("zhuid")); 
		Integer congid = Integer.parseInt(re.getParameter("congid"));
		UsermatchWithBLOBs usermatch = usermatchService.usermatchQuery(zhuid, congid);
	//	UsermatchWithBLOBs usermatch = usermatchService.selectByPrimaryKey(zhuid);
	    System.out.println(usermatch.getUserscore());
		return usermatch.toString();
	}
	
	@RequestMapping("/testUserList")
	@ResponseBody
	public ResultType testUserList(HttpServletRequest re) {
		String country = "中国";
		String city = "天津";
		String area = "红桥";
		String spare = "宝能";
		String spare1 = "1111号";
		User user = new User(); 
		user.setId(3);
		user.setCountry(country);
		user.setCity(city);
		user.setArea(area);
		user.setSpare(spare);
	    List<User> userlist = userService.selectUserlist(user);	
	    for(int i = 0;i<userlist.size();i++) {
	    	User userinfo = userlist.get(i);
	    	
	    	
	    }
	    
//		UserExample userExample = new UserExample();
//		userExample.setLimit(3);;
//		//userExample.get
//		 List<User> userlist =  userService.selectByExample(userExample);
		
		return ResultType.creat(userlist);
	}
	
	
	
	
}
