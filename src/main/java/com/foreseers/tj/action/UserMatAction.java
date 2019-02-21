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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.LocationUtils;
import com.foreseers.tj.http.httptest;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.ReturnUsermatch;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.model.Usermatch;
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserImageService;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.UsermatchService;
import com.foreseers.tj.util.getAge;

@Controller
@RequestMapping("/match")
@CrossOrigin
public class UserMatAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(UserMatAction.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UsermatchService usermatchService;
	@Autowired
	private UserFriendService userFriendService;
	@Autowired
	private UserImageService userImageService;
	@Autowired
	private UserCaHistoryService userCaHistoryService;
	
	@RequestMapping("/matching")
	@ResponseBody
	public ResultType matching(HttpServletRequest request) throws BusinessExpection, ClientProtocolException, IOException {
		log.info("进入推荐附近的人的方法");
		String facebook = request.getParameter("facebookid");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String spare = request.getParameter("addr");
		String spare1 = request.getParameter("addrs");
		String lat = request.getParameter("lat");   //经度
		String lng = request.getParameter("lng");   //纬度
		String sex = request.getParameter("sex");         //筛选条件性别
		int userageli = Integer.parseInt(request.getParameter("ageLittle"));         //筛选条件年龄
		int useragebig = Integer.parseInt(request.getParameter("agebig"));         //筛选条件年龄
		int userdistance = Integer.parseInt(request.getParameter("distance"));         //筛选条件距离
		log.info("请求参数：country:"+country);
		log.info("请求参数：city:"+city);
		log.info("请求参数：area:"+area);
		log.info("请求参数：facebook:"+facebook);
		log.info("请求参数：经度:"+lat);
		log.info("请求参数：纬度:"+lng);
		log.info("请求参数：sex:"+sex);
		log.info("请求参数：筛选条件年龄:"+userageli);
		log.info("请求参数：筛选条件年龄:"+useragebig);
		log.info("请求参数：筛选条件距离:"+userdistance);
		
		if(facebook == null || lat == null || lng == null  ) {	
			log.error("参数不正确");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS); 
		}	
		if(sex == "null" || sex == "") {
			sex = null;
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
		
		
		User user = new User();
		user.setFacebook(facebook);
		user.setArea(area);
		user.setCity(city);
		user.setCountry(country);
		user.setSpare(spare);
		user.setSpare1(spare1);
		user.setLat(Double.parseDouble(lat));
		user.setLng(Double.parseDouble(lng));
	    userService.updateByFaceIDSelective(user);  //将用户的位置信息插入到数据库中
	    log.info("将个人信息更新到数据库");
	    User userinfo = userService.QueryUser(facebook);
	    int accountId = userinfo.getId();             //当前用户ID
		//根据位置信息查用户
	    Map mapuser = new HashMap<String,Object>();
	    mapuser.put("id", accountId);
	    mapuser.put("sex",sex);
	    mapuser.put("country", country);
	    mapuser.put("city", city);
	    mapuser.put("area", area);
	    mapuser.put("spare", spare);
	    mapuser.put("ageli",userageli);
	    mapuser.put("agebig",useragebig);
		List<Integer> idlist = userService.QueryUserByCity(mapuser);
		log.info("idlist:"+idlist);
//增加筛选条件
		//计算两个用户之间的距离,更新到表中
		for(int z=0;z<idlist.size();z++) {
			log.info("通过筛选条件筛选用户");
			UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
			 LocationUtils local = new LocationUtils();
			 User touser = userService.selectByPrimaryKey(idlist.get(z));
			 Double tolat = touser.getLat();
			 Double tolan = touser.getLng();
			 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //用户距离
			 usermatchWithBLOBs.setZhuid(accountId);
			 usermatchWithBLOBs.setCongid(idlist.get(z));
			 usermatchWithBLOBs.setDistance(distance);
			 usermatchService.updateByzhuidKeySelective(usermatchWithBLOBs);
			 if(distance >userdistance) {
				 idlist.remove(z--);
			 }
		}

//增加筛选条件
		List<Integer> listuser = new ArrayList<Integer>();  //推送的用户列表		                                              

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
		if(idlist.size() >0) {   //如果存在附近的人
			//调用接口
			log.info("调用命书接口");
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
				log.info("调用命书接口成功");
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

					 UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
					 usermatchWithBLOBs.setZhuid(accountId);
					 usermatchWithBLOBs.setCongid(user_id);
					 usermatchWithBLOBs.setUserscore(score);
					 usermatchWithBLOBs.setUserdesc(desc);
					 usermatchWithBLOBs.setCommentdesc(commentdesc);
					 usermatchWithBLOBs.setCharacteristicdesc(characteristicdesc);
					 usermatchWithBLOBs.setMinddesc(minddesc);
					 usermatchWithBLOBs.setMindscore(mindscore);
					 usermatchWithBLOBs.setBodydesc(bodydesc);
					 usermatchWithBLOBs.setBodyscore(bodyscore);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setCharacterscore(characterscore);
					// usermatchWithBLOBs.setDistance(distance);
					 usermatchService.insertSelective(usermatchWithBLOBs);   
				}				
			}
						
		}

		//得到给前端返回的list用户，需要修改，根据idlist，查询用户列表	
		List<ReturnUser> returnUserlist = new ArrayList<ReturnUser>();
	    for(int i=0;i<idlistinfo.size();i++) {
	    	ReturnUser returnUser = new ReturnUser();
	    	int id = idlistinfo.get(i);	          // 其他用户的ID 	

	    	User usertest = userService.selectByPrimaryKey(id);
        	String  dateyear = usertest.getDate(); //用户的出生日期     	
        	getAge getage = new getAge();			
			int age = getage.jiuanAge(dateyear);	 //计算得到年		
	    	returnUser.setAge(age);
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
	    log.info("返回的参数："+returnUserlist);
		return ResultType.creat(returnUserlist);
	}
	
	//用户详细信息
	@RequestMapping("/showUser")
	@ResponseBody
	public ResultType showUser(HttpServletRequest request) throws BusinessExpection {
		log.info("进入好友详情页方法");
		String uid = request.getParameter("uid");  						//当前用户id
		int userid = Integer.parseInt(request.getParameter("userid"));  //其他人id
		int userinfoid = Integer.parseInt(uid);	
		log.info("请求参数：userinfoid"+userinfoid);
		log.info("请求参数：userid"+userid);
	//	int lookhead = 0;
		ReturnUsermatch returnUsermatch = new ReturnUsermatch();
		UsermatchWithBLOBs usermatchWithBLOBs = usermatchService.usermatchQuery(userinfoid, userid);
		User user = userService.selectByPrimaryKey(userid);
		if(usermatchWithBLOBs == null) {
			log.error("两人之间没有关系");
			throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT);
		}
		UserFriend userFriend = userFriendService.selectUserFriend(userinfoid+"", userid+"");
		int friend = 0;   //是好友关系
		int lookimages = 0;  //不可以查看相册
		returnUsermatch.setHead(user.getPicture());
		if(userFriend == null) {
			friend = 1;         //不是好友
		}else { 
			if(userFriend.getUserReation() != 0) { // 不是好友关系
				friend = 1;  
			}else {  //两人是好友关系
				//判断一下是否可以查看清晰头像
				if(userFriend.getLookhead() == 1) {
					// lookhead = 1;   //可以查看用户清晰头像
					log.info("两人是好友，返回清晰头像");
					 returnUsermatch.setHead(user.getHead());
				}
				if(userFriend.getLookimages() == 1) {
					lookimages = userFriend.getLookimages();
					returnUsermatch.setLookimages(lookimages);
				}
			}			
		}
	    //判断是否使用过擦子，判断是否头像是否的清晰的
		if(returnUsermatch.getHead().equals(user.getPicture())) {  //当前是模糊头像，判断是否使用过擦子
			log.info("头像是模糊的头像，判断主用户是否擦过这个用户");
			UserCaHistory userCaHistory = new UserCaHistory();
			userCaHistory.setUserid(userinfoid); // 主id
			userCaHistory.setCaid(userid);
			UserCaHistory userCaHistoryinfo = userCaHistoryService.selectByUserCaHistory(userCaHistory); 
			if(userCaHistoryinfo != null) {  
				//有查询结果，说明被擦过
				log.info("当前用户擦过这个用户，返回清晰头像");
				returnUsermatch.setHead(user.getHead());
			}
			
		}
		
	    String useryear =  user.getDate();
	    int num = user.getNum();   //擦过的次数
	    String sex = user.getSex();  //性别
	    String obligate = user.getObligate();  //签名
		//getAge getage = new getAge();
	    int age = user.getReservedint();   //年龄  
	    String name = user.getUsername();   //名称
	
	    List<UserImage> list = userImageService.queryByUseridlist(userid);
	    returnUsermatch.setAge(age);	
	    returnUsermatch.setNum(num);
	    returnUsermatch.setSex(sex);
	    returnUsermatch.setObligate(obligate);
	    returnUsermatch.setFriend(friend);
	    returnUsermatch.setName(name);
	  //  returnUsermatch.setHead(head);
	    returnUsermatch.setImages(list);
	    BeanUtils.copyProperties(usermatchWithBLOBs, returnUsermatch);
	    log.info("返回值："+returnUsermatch);
		return ResultType.creat(returnUsermatch);
	}
	
	
}
