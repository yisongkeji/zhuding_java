package com.example.demo.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.http.LocationUtils;
import com.example.demo.http.httptest;
import com.example.demo.model.BusinessExpection;
import com.example.demo.model.EmBussinsError;
import com.example.demo.model.ResultType;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/match")
@CrossOrigin
public class UserMatAction extends BaseAction{

	@Autowired
	private UserService userService;
	
	@RequestMapping("/matching")
	public ResultType matching(HttpServletRequest request) throws BusinessExpection, ClientProtocolException, IOException {
		String facebook = request.getParameter("facebookid");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String spare = request.getParameter("addr");
		String spare1 = request.getParameter("addrs");
		String lat = request.getParameter("lat");   //经度
		String lng = request.getParameter("lng");   //纬度		
		if(facebook == null || lat == null || lng == null  ) {			
			throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT); 
		}	
		//接口返回字段需要保存都数据库中
		int user_id ;
		int score ;
		String desc = "";
		String commentdesc = "";
		String commentgood = "";
		String commentbad = "";
		String characteristicdesc = "";
		String characteristicgood = "";
		String characteristicbad = "";
		int mindscore ;
		String minddesc = "";
		int bodyscore ;
		String bodydesc = "";
		int characterscore ;
		String characterdesc = "";
		int distance = 1; //距离
		
//		String facebook = "1231";
//		String country = "中国";
//		String city = "天津";
//		String area = "南开";
//		String spare = "宝能";
//		String spare1 = "1111号";
//		String lat = request.getParameter("lat");   //经度
//		String lng = request.getParameter("lng");   //纬度
		
		User user = new User(); 
		user.setArea(area);
		user.setCity(city);
		user.setCountry(country);
		user.setFacebook(facebook);
		user.setSpare(spare);
		user.setSpare1(spare1);
		user.setLat(Double.parseDouble(lat));
		user.setLng(Double.parseDouble(lng));
	    userService.updateByFaceIDSelective(user);  //将用户的位置信息插入到数据库中
	    
	    User userinfo = userService.QueryUser(facebook);
	    int accountId = userinfo.getId();
	    Double userlat = userinfo.getLat();  //主用户的经纬度
	    Double userlng = userinfo.getLng();
		//根据位置信息查用户
		List<Integer> idlist =   userService.QueryUserByCity(user);
		System.out.println(idlist);
		if(idlist.size() >0) {   //如果存在附近的人
			//调用接口
			String url = "https://api2047.foreseers.com/Dating/matching";
			httptest httptest = new httptest();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("accountId", accountId);
			map.put("target", idlist);
			String rebody = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
			System.out.println(rebody);
			JSONObject jsn = JSON.parseObject(rebody);
			String errcode = jsn.getString("errcode");
			if(errcode.equals("200")) {
				System.out.println("调用接口成功");
				JSONArray result = jsn.getJSONArray("result");
				for(int i = 0;i<result.size();i++) {					
					//JSONObject resultjson = JSON.parseObject(result.get(i).toString());
					JSONObject resultjson = JSON.parseObject(result.get(i).toString());
					 user_id = resultjson.getInteger("user_id");
					 score = resultjson.getInteger("score");
					 desc = resultjson.get("desc").toString();
					JSONObject comment = JSON.parseObject(resultjson.get("comment").toString());
					 commentdesc = comment.get("desc").toString();
					 commentgood = comment.get("good").toString();
					 commentbad = comment.get("bad").toString();
					JSONObject characteristic = JSON.parseObject(resultjson.get("characteristic").toString());
					 characteristicdesc = characteristic.get("desc").toString();
					 characteristicgood = characteristic.get("good").toString();
					 characteristicbad = characteristic.get("bad").toString();
					JSONObject mind = JSON.parseObject(resultjson.get("mind").toString());
					 mindscore = mind.getInteger("score");
					 minddesc = mind.get("desc").toString();
					JSONObject body = JSON.parseObject(resultjson.get("body").toString());
					 bodyscore = body.getInteger("score");
					 bodydesc = body.get("desc").toString();
					JSONObject character = JSON.parseObject(resultjson.get("character").toString());
					 characterscore = character.getInteger("score");
					 characterdesc = character.get("desc").toString();
				}				
			}
			//计算这两个用户的距离
			for(int toid = 0;toid<idlist.size();toid++) {
				LocationUtils local = new LocationUtils();
				User touser = userService.selectByPrimaryKey(toid);
				Double tolat = touser.getLat();
				Double tolan = touser.getLng();
				distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //用户距离
			}
		}
		

		
		return null;
	}
	
	
}
