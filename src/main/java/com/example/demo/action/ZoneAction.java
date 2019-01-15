package com.example.demo.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.http.LocationUtils;
import com.example.demo.http.httpmatching;
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
//		String area = "红桥";
//		String spare = "宝能";
//		String spare1 = "1111号";
		User user = new User(); 
		user.setId(3);
		user.setCountry(country);
		user.setCity(city);
//		user.setArea(area);
//		user.setSpare(spare);
    	List<ReturnUser> returnUserlist = new ArrayList<ReturnUser>();
	    List<User> userlist = userService.selectUserlist(user);	
	    List<Integer> idlist =   userService.QueryUserByCity(user);
	    for(int i=0;i<userlist.size();i++) {
	    	ReturnUser returnUser = new ReturnUser();
	    	User userinfo = userlist.get(i);
	    	Usermatch usermatch =	usermatchService.usermatchQuery(userinfo.getId(),3);
	    	//userinfo.getId();
	    	if(usermatch != null) {
	    	returnUser.setUserscore(usermatch.getUserscore());
	    	returnUser.setDistance(usermatch.getDistance());
	    	}
	    	BeanUtils.copyProperties(userinfo, returnUser);
	    	returnUserlist.add(returnUser);
	    }
	  //  Collections.reverse(returnUserlist);
	    
	    Collections.sort(returnUserlist);
		
		return ResultType.creat(returnUserlist);
	}
	
	@RequestMapping("/testlistInteger")
	@ResponseBody
	public ResultType testlistInteger(HttpServletRequest re) {
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
		List<Integer> listuser = new ArrayList<Integer>();
		listuser.add(6);
		listuser.add(7);
    	List<ReturnUser> returnUserlist = new ArrayList<ReturnUser>();
	  //  List<User> userlist = userService.selectUserlist(user);	
	    List<Integer> idlist =   userService.QueryUserByCity(user);
	    for(int i=0;i<idlist.size();i++) {
	    	ReturnUser returnUser = new ReturnUser();
	    	int id = idlist.get(i);
	    	User userinfo = userService.selectByPrimaryKey(id); //得到这个用户
	    	Usermatch usermatch =	usermatchService.usermatchQuery(id,3);
	    	
	    	if(usermatch != null) {
	    	returnUser.setUserscore(usermatch.getUserscore());
	    	returnUser.setDistance(usermatch.getDistance());	    	
	    	}
	    	if(listuser.contains(id)) {
	    		returnUser.setNumuser(1);
	    	}else {
	    		returnUser.setNumuser(0);
	    	}

	    	BeanUtils.copyProperties(userinfo, returnUser);
	    	returnUserlist.add(returnUser);
	    }

	    System.out.println(returnUserlist);
	    
	    Collections.sort(returnUserlist);
		
		return ResultType.creat(returnUserlist);
	}
	
	
	@RequestMapping("/testList")
	@ResponseBody
	public String testList() throws ClientProtocolException, IOException {
		
		String country = "中国";
		String city = "天津";
		String area = "红桥";
		String spare = "宝能";
		//String spare1 = "1111号";
		 Double userlat = 20.05;  //主用户的经纬度
		 Double userlng = 109.091;
		int accountId = 3;
		User user = new User(); 
		user.setId(3);
		user.setArea(area);
		user.setCity(city);
		user.setCountry(country);
		//user.setFacebook(facebook);
		user.setSpare(spare);
		//user.setSpare1(spare1);
		//Usermatch usermatch1 = usermatchService.usermatchQuery(3, 7);
		List<Integer> idlist =   userService.QueryUserByCity(user);
		//idlist.contains(3);
		System.out.println(idlist.contains(3));
		System.out.println(idlist);
		if(idlist.size()<50) {
			//插入两个根据num排行的随机数
			int paihang = 10;
			int getnum = 2;
			List<Integer> idlistinfo = userService.QueryUserByNUM(paihang, getnum);
			for(int j = 0;j<idlistinfo.size();j++) {
				idlist.add(idlistinfo.get(j));			
			}
			System.out.println(idlist);
		}
		
//		for (int k = 0;k<idlist.size();k++) {    //调用接口前判断重复
//			Usermatch usermatch = usermatchService.usermatchQuery(3,idlist.get(k));
//			if(usermatch != null) {
//				idlist.remove(k--);
//			}
//		}
//		for (int k = 0;k<idlist.size();k++) {     //更新用户距离
//			UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
//			 LocationUtils local = new LocationUtils();
//			 User touser = userService.selectByPrimaryKey(idlist.get(k));
//			 Double tolat = touser.getLat();
//			 Double tolan = touser.getLng();
//			int distance = local.getDistance(userlat,userlng, tolat, tolan); //用户距离
//			 usermatchWithBLOBs.setZhuid(3);
//			 usermatchWithBLOBs.setCongid(idlist.get(k));
//			 usermatchWithBLOBs.setDistance(distance);
//			 usermatchService.updateByzhuidKeySelective(usermatchWithBLOBs);
//			System.out.println(distance);
//		}
		//调用接口
	//	httpmatching mat = new httpmatching();
	//	UsermatchWithBLOBs  usermatchWithBLOBs = mat.httpurl(accountId, idlist);
		
		return null;	
	}
	
	@RequestMapping("/testMap")
	@ResponseBody
	public String testMAP() {
		Map map = new HashMap<String, Object>();
		map.put("country", "中国");
		map.put("city", "天津");
		map.put("quenum", 10);
		List<Integer>  list = userService.QueryUserByqueNUM(map);
		
		System.out.println(list);
		return list.toString();
	}
	
}
