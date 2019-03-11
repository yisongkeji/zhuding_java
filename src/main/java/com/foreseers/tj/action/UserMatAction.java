package com.foreseers.tj.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.foreseers.tj.mapper.UserDefriendMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.ReturnUsermatch;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserDefriend;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.model.Usermatch;
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserDefriendService;
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
	@Autowired
	private UserDefriendMapper userDefriendMapper;
	
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
		Map<Integer,Integer> mapd = new HashMap<Integer,Integer>();
		LocationUtils local = new LocationUtils();
		if(idlist.size() > 0) {
		 for(int z=0;z<idlist.size();z++) {
			log.info("通过筛选条件筛选用户");
			UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();			 
			 User touser = userService.selectByPrimaryKey(idlist.get(z));
			 Double tolat = touser.getLat();
			 Double tolan = touser.getLng();
			 log.info("经度："+tolat);
			 log.info("经度："+tolan);
			 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //用户距离
			 log.info("距离："+distance);
			 usermatchWithBLOBs.setZhuid(accountId);
			 usermatchWithBLOBs.setCongid(idlist.get(z));
			 usermatchWithBLOBs.setDistance(distance);
			 usermatchService.updateByzhuidKeySelective(usermatchWithBLOBs);
			 mapd.put(idlist.get(z), distance);
			 if(distance >userdistance) {
				 idlist.remove(z--);
			 }
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
					idlist.add(listuser.get(j));   //添加推送的id
					log.info("推送的用户id为："+listuser.get(j));
					 User touser = userService.selectByPrimaryKey(listuser.get(j)); //获得推送的人
					 Double tolat = touser.getLat();
					 Double tolan = touser.getLng();
					 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //计算距离 
					 log.info("计算推送用户的距离："+distance);
					 UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
					 usermatchWithBLOBs.setZhuid(accountId);
					 usermatchWithBLOBs.setCongid(listuser.get(j));
					 usermatchWithBLOBs.setDistance(distance);
					 log.info("重新计算推送的人距离");
					 usermatchService.updateByzhuidKeySelective(usermatchWithBLOBs);
					 mapd.put(listuser.get(j), distance);
				}							
			}

		}else {
			if(idlist.size()<100) {
				int paihang = 40;
				int getnum = 5;
				listuser = userService.QueryUserByNUM(paihang, getnum);  //推送上去的人
				for(int j = 0;j<listuser.size();j++) {
					idlist.add(listuser.get(j));
					log.info("推送的用户id为："+listuser.get(j));
					 User touser = userService.selectByPrimaryKey(listuser.get(j)); //获得推送的人
					 Double tolat = touser.getLat();
					 Double tolan = touser.getLng();
					 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //计算距离 
					 log.info("计算推送用户的距离："+distance);
					 UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
					 usermatchWithBLOBs.setZhuid(accountId);
					 usermatchWithBLOBs.setCongid(listuser.get(j));
					 usermatchWithBLOBs.setDistance(distance);
					 log.info("重新计算推送的人距离");
					 usermatchService.updateByzhuidKeySelective(usermatchWithBLOBs);
					 mapd.put(listuser.get(j), distance);
				}				
			}else {
				int paihang = 100;
				int getnum = 10;
				listuser = userService.QueryUserByNUM(paihang, getnum);  //推送上去的人
				for(int j = 0;j<listuser.size();j++) {
					idlist.add(listuser.get(j));	
					log.info("推送的用户id为："+listuser.get(j));
					 User touser = userService.selectByPrimaryKey(listuser.get(j)); //获得推送的人
					 Double tolat = touser.getLat();
					 Double tolan = touser.getLng();
					 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //计算距离 
					 log.info("计算推送用户的距离："+distance);
					 UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
					 usermatchWithBLOBs.setZhuid(accountId);
					 usermatchWithBLOBs.setCongid(listuser.get(j));
					 usermatchWithBLOBs.setDistance(distance);
					 log.info("重新计算推送的人距离");
					 usermatchService.updateByzhuidKeySelective(usermatchWithBLOBs);
					 mapd.put(listuser.get(j), distance);
				}
				
			}
			
		}
		
		 //将黑名单用户移除
		 List<UserDefriend> blacks = userDefriendMapper.getBlackList(accountId);
		 log.info("查询黑名单列表：blacks："+blacks);
		 if(blacks.size()>0) {
			 log.info("存在黑名单");
			 for(int b = 0;b<blacks.size();b++) {
				 for(int i=0;i<idlist.size();i++) {
					 if(blacks.get(b).getBlackid() == idlist.get(i)) {
						 log.info("从黑名单移除：id:"+idlist.get(i));
						 idlist.remove(i--);
					 }
				 }
			 }
		 }
		//将黑名单用户移除
		// idlistinfo = idlist;
		 for(int q=0;q<idlist.size();q++) {
			 idlistinfo.add(idlist.get(q));
		 }

		for (int k = 0;k<idlist.size();k++) {    //调用接口前判断重复
			Usermatch usermatch = usermatchService.usermatchQuery(accountId,idlist.get(k));
			if(usermatch != null) {
				idlist.remove(k--);
			}
		}
		log.info("命书用户ids:"+idlist);
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
				log.info("接口返回结果"+result);
				
				for(int i = 0;i<result.size();i++) {					
					//JSONObject resultjson = JSON.parseObject(result.get(i).toString());
					//解析接口
					JSONObject resultjson = JSON.parseObject(result.get(i).toString());
					 user_id = resultjson.getInteger("user_id");
					 score = resultjson.getInteger("score");
					 desc = resultjson.get("desc").toString();
			//		JSONObject comment = JSON.parseObject(resultjson.get("comment").toString());
					 commentdesc = resultjson.get("comment").toString();
//					 commentgood = comment.get("good").toString();
//					 commentbad = comment.get("bad").toString();
				//	JSONObject characteristic = JSON.parseObject(resultjson.get("characteristic").toString());
					 characteristicdesc = resultjson.get("characteristic").toString();
					 String characteristicdesc1 =  characteristicdesc.replace("[", "");
					 String characteristicdesc2 =  characteristicdesc1.replace("]", "");
					 String characteristicdesc3 =  characteristicdesc1.replace("\"","");
				//	 characteristicgood = characteristic.get("good").toString();
				//	 characteristicbad = characteristic.get("bad").toString();
				//	JSONObject mind = JSON.parseObject(resultjson.get("mind").toString());
					 mindscore = resultjson.getInteger("mind");
				//	 minddesc = mind.get("desc").toString();
				//	JSONObject body = JSON.parseObject(resultjson.get("body").toString());
					 bodyscore = resultjson.getInteger("body");
				//	 bodydesc = body.get("desc").toString();
				//	JSONObject character = JSON.parseObject(resultjson.get("character").toString());  //character
					 characterscore = resultjson.getInteger("character");
				//	 characterdesc = character.get("desc").toString();
					 String courting = resultjson.get("courting").toString();
					 //计算两用户之前的距离				
					 int userinfodistance = 0;
					 for(Map.Entry<Integer,Integer> entry:mapd.entrySet()) {
						 if(entry.getKey() == user_id) {
							 userinfodistance = entry.getValue();
						 }
					 }					 
					 UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
					 usermatchWithBLOBs.setZhuid(accountId);
					 usermatchWithBLOBs.setCongid(user_id);
					 usermatchWithBLOBs.setUserscore(score);
					 usermatchWithBLOBs.setUserdesc(desc);
					 usermatchWithBLOBs.setCommentdesc(commentdesc);
					 usermatchWithBLOBs.setCharacteristicdesc(characteristicdesc2);
					 usermatchWithBLOBs.setMinddesc(minddesc);
					 usermatchWithBLOBs.setMindscore(mindscore);
					 usermatchWithBLOBs.setBodydesc(bodydesc);
					 usermatchWithBLOBs.setBodyscore(bodyscore);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setCharacterscore(characterscore);
					 usermatchWithBLOBs.setDistance(userinfodistance);
					 usermatchWithBLOBs.setSpare(courting);
					 usermatchService.insertSelective(usermatchWithBLOBs);   
					 log.info("插入到数据库");
				}				
			}
						
		}

		//得到给前端返回的list用户，需要修改，根据idlist，查询用户列表
		log.info("判断是否返回清晰头像");
		List<ReturnUser> returnUserlist = new ArrayList<ReturnUser>();
	    for(int i=0;i<idlistinfo.size();i++) {
	    	ReturnUser returnUser = new ReturnUser();
	    	int id = idlistinfo.get(i);	          // 其他用户的ID 	
            //增加判断是否可以查看清晰头像（新增）
	    	int lookhead = 0;
	    	UserFriend userFriend = userFriendService.selectUserFriend(accountId+"", id+"");
	    	if(userFriend != null) { //存在好友关系
	    		if(userFriend.getUserReation() == 0) { //是好友关系
	    			if(userFriend.getLookhead() == 1) {  //可以查看清晰头像
	    				log.info("两人是好友关系，切可以返回清晰头像");
	    				lookhead = 1;
	    			}
	    		}	
	    	}
	    	if(lookhead == 0) { //判断是否使用过擦子
	    		log.info("两人不是好友关系，或者成为好友时间不够，判断是否使用过擦子");
				UserCaHistory userCaHistory = new UserCaHistory();
				userCaHistory.setUserid(accountId); // 主id
				userCaHistory.setCaid(id);
				UserCaHistory userCaHistoryinfo = userCaHistoryService.selectByUserCaHistory(userCaHistory); 
				if(userCaHistoryinfo != null) {
					log.info("使用过擦子，返回清晰头像");
					lookhead = 1;
				}
				log.info("没有使用过擦子，不能查看清晰头像");
	    	}
	    	returnUser.setLookhead(lookhead);
	    	 //增加判断是否可以查看清晰头像
	    	User usertest = userService.selectByPrimaryKey(id);
//        	String  dateyear = usertest.getDate(); //用户的出生日期     	
//        	getAge getage = new getAge();			
//			int age = getage.jiuanAge(dateyear);	 //计算得到年		
//	    	returnUser.setAge(age);
	    	Usermatch usermatch =	usermatchService.usermatchQuery(id,accountId);
	    	if(usermatch != null) {
	    	returnUser.setUserscore(usermatch.getUserscore());
	    	returnUser.setDistance(usermatch.getDistance());	
	    	returnUser.setDESC(usermatch.getUserdesc());
	    	}
	    	if(listuser.contains(id)) {
	    		returnUser.setNumuser(1);
	    	}else {
	    		returnUser.setNumuser(0);
	    	}
	    //	BeanUtils.copyProperties(usertest, returnUser);
	    	returnUser.setId(usertest.getId());
	    	returnUser.setFacebook(usertest.getFacebook());
	    	returnUser.setUsername(usertest.getUsername());
	    	returnUser.setReservedint(usertest.getReservedint());
	    	returnUser.setSex(usertest.getSex());
	    	returnUser.setZiwei(usertest.getZiwei());
	    	if(lookhead == 0) {
	    		returnUser.setHead(usertest.getPicture());
	    	}
	    	if(lookhead ==1) {
	    		returnUser.setHead(usertest.getHead());
	    	}
	    	returnUserlist.add(returnUser);
	    }
	    Collections.sort(returnUserlist);
	    log.info("返回的参数："+returnUserlist);
		return ResultType.creat(returnUserlist);
	}
	
	//用户详细信息
	@RequestMapping("/showUser")
	@ResponseBody
	public ResultType showUser(HttpServletRequest request) throws BusinessExpection, ParseException {
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
		int sevenday = 0;  //不可以查看
		int thirthday = 0;  //不可以查看
		if(userFriend != null) {
			String time =  userFriend.getFirendtime();   //得到成为好友的时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date friendt = format.parse(time);  //成为好友的时间
			Date date = new Date();  
			long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
			long diff = date.getTime()-friendt.getTime();
			long day = diff / nd ;  
			log.info("day:"+day);
			if(day>7) {
				sevenday = 1;  //可以查看
			}
			if(day>30) {
				thirthday = 1;
			}
		}

		
		int friend = 0;   //是好友关系
		int lookimages = 0;  //不可以查看相册
		int lookhead = 0 ;    //不能查看清晰头像
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
					 lookhead = 1;
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
				 lookhead = 1;
			}
			
		}	
	    String useryear =  user.getDate();
	    int num = user.getNum();   //擦过的次数
	    String sex = user.getSex();  //性别
	    String obligate = user.getObligate();  //签名
		//getAge getage = new getAge();
	    int age = user.getReservedint();   //年龄  
	    String name = user.getUsername();   //名称
	    String ziwei = user.getZiwei();     //紫微
	
	    List<UserImage> list = userImageService.queryByUseridlist(userid);
	    List<String>  imagelists = new ArrayList<>();
	    if(list.size() >0) {
	    	for(UserImage userImage:list) {
	    		if(lookimages == 0) {
	    			imagelists.add(userImage.getSpare());
	    		}
	    		if(lookimages == 1) {
	    			imagelists.add(userImage.getImage());
	    		}
	    	}
	    }
	    returnUsermatch.setAge(age);	
	    returnUsermatch.setNum(num);
	    returnUsermatch.setSex(sex);
	    returnUsermatch.setObligate(obligate);
	    returnUsermatch.setFriend(friend);
	    returnUsermatch.setName(name);
	    returnUsermatch.setZiwei(ziwei);
	    returnUsermatch.setSevenday(sevenday);
	    returnUsermatch.setThirthday(thirthday);
	    returnUsermatch.setLookhead(lookhead);
	    returnUsermatch.setVip(user.getVip());
	  //  returnUsermatch.setHead(head);
	    returnUsermatch.setImages(imagelists);
	    BeanUtils.copyProperties(usermatchWithBLOBs, returnUsermatch);
	    log.info("返回值："+returnUsermatch);
		return ResultType.creat(returnUsermatch);
	}
	
	
}
