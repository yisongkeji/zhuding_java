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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.http.LocationUtils;
import com.example.demo.http.httptest;
import com.example.demo.model.BusinessExpection;
import com.example.demo.model.EmBussinsError;
import com.example.demo.model.ResultType;
import com.example.demo.model.ReturnUser;
import com.example.demo.model.User;
import com.example.demo.model.Usermatch;
import com.example.demo.model.UsermatchWithBLOBs;
import com.example.demo.service.UserService;
import com.example.demo.service.UsermatchService;

@Controller
@RequestMapping("/match")
@CrossOrigin
public class UserMatAction extends BaseAction{

	@Autowired
	private UserService userService;
	@Autowired
	private UsermatchService usermatchService;
	
	@RequestMapping("/matching")
	@ResponseBody
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
		user.setFacebook(facebook);
		user.setArea(area);
		user.setCity(city);
		user.setCountry(country);
		user.setSpare(spare);
		user.setSpare1(spare1);
		user.setLat(Double.parseDouble(lat));
		user.setLng(Double.parseDouble(lng));
	  //  userService.updateByFaceIDSelective(user);  //将用户的位置信息插入到数据库中
	    
	    User userinfo = userService.QueryUser(facebook);
	    int accountId = userinfo.getId();    
//	    Double userlat = userinfo.getLat();  //主用户的经纬度
//	    Double userlng = userinfo.getLng();
		//根据位置信息查用户
		List<Integer> idlist = userService.QueryUserByCity(userinfo);
		
		List<Integer> listuser = new ArrayList<Integer>();  //推送列表
		List<Integer> idlistinfo = new ArrayList<Integer>();
		//判断周围人的个数，如果太少就添加，添加特殊用户
		if(idlist.size()<50) {
			//插入两个根据num排行的随机数
			int paihang = 2;
			int getnum = 1;
			 listuser = userService.QueryUserByNUM(paihang, getnum);  //推送上去的人
			for(int j = 0;j<listuser.size();j++) {
				if((!idlist.contains(listuser.get(j))) && (listuser.get(j)!= accountId)) {
					idlist.add(listuser.get(j));
				}							
			}
			if(idlist.size()<10) {
			int quenum = 10-idlist.size();			
			Map map = new HashMap<String, Object>();
			map.put("country", country);
			map.put("city", city);
			map.put("quenum", quenum);
			List<Integer> quelist = userService.QueryUserByqueNUM(map);  //不足50个补齐
			for(int a=0;a<quelist.size();a++ ){
				if(!idlist.contains(quelist.get(a))) {
				idlist.add(quelist.get(a));	
				}
				}
			}	
		}else {
			if(idlist.size()<100) {
				int paihang = 40;
				int getnum = 5;
				listuser = userService.QueryUserByNUM(paihang, getnum);  //推送上去的人
				for(int j = 0;j<listuser.size();j++) {
					idlist.add(listuser.get(j));			
				}				
			}else {
				int paihang = 100;
				int getnum = 10;
				listuser = userService.QueryUserByNUM(paihang, getnum);  //推送上去的人
				for(int j = 0;j<listuser.size();j++) {
					idlist.add(listuser.get(j));			
				}
				
			}
			
		}
		// idlistinfo = idlist;
		 for(int q=0;q<idlist.size();q++) {
			 idlistinfo.add(idlist.get(q));
		 }
		//判断周围人的个数，如果太少就添加，添加特殊用户		
		
		
		for (int k = 0;k<idlist.size();k++) {    //调用接口前判断重复
			Usermatch usermatch = usermatchService.usermatchQuery(accountId,idlist.get(k));
			if(usermatch != null) {
				idlist.remove(k--);
			}
		}
	//	System.out.println(idlist);
		if(idlist.size() >0) {   //如果存在附近的人
			//调用接口
			String url = "https://api2047.foreseers.com/Dating/matching";
			httptest httptest = new httptest();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("accountId", accountId);
			map.put("target", idlist);
			String rebody = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
		//	System.out.println(rebody);
			JSONObject jsn = JSON.parseObject(rebody);
			String errcode = jsn.getString("errCode");
			if(errcode.equals("200")) {
				//System.out.println("调用接口成功");
				JSONArray result = jsn.getJSONArray("result");
				for(int i = 0;i<result.size();i++) {					
					//JSONObject resultjson = JSON.parseObject(result.get(i).toString());
					//解析接口
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
					 //计算两用户之前的距离
//					 LocationUtils local = new LocationUtils();
//					 User touser = userService.selectByPrimaryKey(user_id);
//					 Double tolat = touser.getLat();
//					 Double tolan = touser.getLng();
//					 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //用户距离
					 //将信息保存到数据库
					 UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
					 usermatchWithBLOBs.setZhuid(accountId);
					 usermatchWithBLOBs.setCongid(user_id);
					 usermatchWithBLOBs.setUserscore(score);
					 usermatchWithBLOBs.setUserdesc(desc);
					 usermatchWithBLOBs.setCommentdesc(commentdesc);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setMinddesc(minddesc);
					 usermatchWithBLOBs.setMindscore(mindscore);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setBodyscore(bodyscore);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setCharacterscore(characterscore);
					// usermatchWithBLOBs.setDistance(distance);
					 usermatchService.insertSelective(usermatchWithBLOBs);   
				}				
			}
						
		}
		//计算两个用户之间的距离,更新到表中
		for(int z=0;z<idlistinfo.size();z++) {
			UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
			 LocationUtils local = new LocationUtils();
			 User touser = userService.selectByPrimaryKey(idlistinfo.get(z));
			 Double tolat = touser.getLat();
			 Double tolan = touser.getLng();
			 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //用户距离
			 usermatchWithBLOBs.setZhuid(accountId);
			 usermatchWithBLOBs.setCongid(idlistinfo.get(z));
			 usermatchWithBLOBs.setDistance(distance);
			 usermatchService.updateByzhuidKeySelective(usermatchWithBLOBs);
		}
		
		//得到给前端返回的list用户，需要修改，根据idlist，查询用户列表
		//List<User> userlist = userService.selectUserlist(user);	
		List<ReturnUser> returnUserlist = new ArrayList<ReturnUser>();
	    for(int i=0;i<idlistinfo.size();i++) {
	    	ReturnUser returnUser = new ReturnUser();
	    	int id = idlistinfo.get(i);
	    	User usertest = userService.selectByPrimaryKey(id);
	    	Usermatch usermatch =	usermatchService.usermatchQuery(id,accountId);
	    	if(usermatch != null) {
	    	returnUser.setUserscore(usermatch.getUserscore());
	    	returnUser.setDistance(usermatch.getDistance());
	    	}
	    	if(listuser.contains(id)) {
	    		returnUser.setNumuser(1);
	    	}else {
	    		returnUser.setNumuser(0);
	    	}
	    	BeanUtils.copyProperties(usertest, returnUser);
	    	returnUserlist.add(returnUser);
	    }
	    Collections.sort(returnUserlist);
	    
		return ResultType.creat(returnUserlist);
	}
	
	
}
