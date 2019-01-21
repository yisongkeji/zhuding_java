package com.foreseers.tj.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.httptest;
import com.foreseers.tj.mapper.UserMapper;
import com.foreseers.tj.mapper.ZoneMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.User;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.ZoneService;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserAction extends BaseAction{
	
//	private static final Logger log = LoggerFactory.getLogger(UserAction.class);
	
	@Autowired
	private UserService userService;
		
	@Autowired
	private ZoneService zoneService;
	
	/*
	 * 查询用户方法
	 */
	@RequestMapping("/queryUser")
	@ResponseBody
	public ResultType queryUser(HttpServletRequest request) throws BusinessExpection {
	//	log.info("进入查询用户方法");
		String facebookid = request.getParameter("facebookid");
	//	log.info("facebookid："+facebookid);
		User user =  userService.QueryUser(facebookid);

		if(user == null) {
	//		log.info("用户不存在，为新用户");
		 throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT);
		}
		return ResultType.creat("用户已存在");
	}
	
	/*
	 * 用户注册方法
	 */
	@RequestMapping("/insertUser")
	@ResponseBody
	public ResultType insertUser(HttpServletRequest request) throws BusinessExpection, ClientProtocolException, IOException {
	//	log.info("进入用户注册方法");
		String username = request.getParameter("username");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String gender = request.getParameter("gender");
		String facebookid = request.getParameter("facebookid");
		String  zoneString = request.getParameter("zone");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String spare = request.getParameter("addr");
		String spare1 = request.getParameter("addrs");
		String lat = request.getParameter("lat");   //经度
		String lng = request.getParameter("lng");   //纬度	
	//	System.out.println(zoneString);
		int zone = 0;
	//	String  zoneString = "UTC-12:00";
		String ziwei = "";        //ziwei
		String numerology = "";  //num
		String horoscope = "";  //星座
		String zodiac = "";    //生肖		
		String bazi = "";     //八字
		String cat1 = "";
		String star = "";
//		log.info("用户名:"+username);
//		log.info("日期:"+date);
//		log.info("时间:"+time);
//		log.info("性别:"+gender);
//		log.info("facebookid:"+facebookid);
	//	ZoneAction zoneAction = new ZoneAction();
		Timezone timezone = zoneService.selectByName(zoneString);
		if(timezone != null) {
			 zone = timezone.getId();
		}else {
			throw new BusinessExpection(EmBussinsError.UNKNOWN_ERROR);
			
		}

		//现将用户信息插入表中
		User userinfo = new User();
		userinfo.setFacebook(facebookid);
		userinfo.setUsername(username);
		userinfo.setDate(date);
		userinfo.setTime(time);
		userinfo.setZone(zone);
		userinfo.setCountry(country);
		userinfo.setCity(city);
		userinfo.setArea(area);
		userinfo.setSpare(spare);
		userinfo.setSpare1(spare1);
		userinfo.setLat(Double.parseDouble(lat));
		userinfo.setLng(Double.parseDouble(lng));
		int insertid =  userService.insertSelective(userinfo);  
		int accountId = userinfo.getId();
	//	User user1= userService.QueryUser(facebookid);
//		int accountId = user1.getId();
		
		String url = "https://api2047.foreseers.com/Dating/personalAnalysis";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("time", time);
		map.put("gender", gender);
		map.put("accountId",accountId);
		
		httptest httptest = new httptest();
		                     //sendPostDataByJson
		String body = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
		
		JSONObject jsn = JSON.parseObject(body);
		 String errcode = jsn.getString("errCode");
		if(errcode.equals("200") ) {
		//	log.info("调用接口成功");
			numerology = jsn.getString("numerology");  
		    cat1 = jsn.getString("cat1");  //五行
		    star = jsn.getString("star");  
			horoscope = jsn.getString("horoscope");  //星座
			zodiac = jsn.getString("zodiac");   //生肖
			//ziwei
			JSONArray ziweiArry = jsn.getJSONArray("ziwei");  
			StringBuffer str = new StringBuffer();
			String str1 = "";
			 for(int j= 0;j<ziweiArry.size();j++) {
				  String ziwei1 = ziweiArry.get(j).toString();
				  str1 =  str.append(ziwei1+",").toString();
			 } 
			ziwei =  str1.substring(0,str1.length()-1);    //得到ziwei
			 //八字
			JSONArray baziarry = jsn.getJSONArray("bazi");    
			StringBuffer strba = new StringBuffer();
			String  strbazi = "";
			for(int i = 0;i<baziarry.size();i++) {
				strbazi = strba.append(baziarry.get(i)+",").toString();
			}
			bazi = strbazi.substring(0,strbazi.length()-1);
					
		}else {			
			throw new BusinessExpection(EmBussinsError.UNKNOWN_ERROR);
		}

		User user = new User();
		user.setId(accountId);
		user.setSex(gender);
		user.setBazi(bazi);
		user.setUsername(username);
		user.setDate(date);
		user.setTime(time);
		user.setFacebook(facebookid);
		user.setCat1(cat1);
		//user.setNum(Integer.parseInt(numerology));
		user.setNumerology(Integer.parseInt(numerology));
		user.setXingzuo(horoscope);
		user.setZiwei(ziwei);
		user.setZone(zone);
		user.setZodiac(zodiac);
		user.setUserstar(Integer.parseInt(star));
		
//		log.info("user:"+user);
		userService.updateByPrimaryKeySelective(user);
		
		return ResultType.creat(user);
	}
	
	/*
	 * 头像上传
	 */
	@RequestMapping("/uploadtou")
	@ResponseBody
	public String uploadtou(HttpServletRequest request) {
		
		return null;
	}
	
	
}
