package com.example.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.example.demo.http.httptest;
import com.example.demo.model.ResultType;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/match")
@CrossOrigin
public class UserMatchong extends BaseAction{

	@Autowired
	private UserService userService;
	
	@RequestMapping("/matching")
	public ResultType matching(HttpServletRequest request) {
//		String facebook = request.getParameter("facebookid");
//		String country = request.getParameter("country");
//		String city = request.getParameter("city");
//		String area = request.getParameter("area");
		
		String facebook = "1231";
		String country = "中国";
		String city = "天津";
		String area = "南开";
		
		User user = new User();
		user.setArea(area);
		user.setCity(city);
		user.setCountry(country);
		user.setFacebook(facebook);
	    userService.updateByFaceIDSelective(user);  //将用户的位置信息插入到数据库中
	    
	    User userinfo = userService.QueryUser(facebook);
	    int accountId = userinfo.getId();
	    
		//根据位置信息查用户
		 List<Integer> idlist =   userService.QueryUserByCity(user);
		System.out.println(idlist);
		if(idlist.size() >0) {   //如果存在附近的人
			//调用接口
			String url = "https://api2047.foreseers.com/Dating/matching";
			httptest httptest = new httptest();
			//String body = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
			
			//计算这个人是位置
		}
		

		
		return null;
	}
	
	
}
