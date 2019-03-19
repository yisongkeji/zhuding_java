package com.foreseers.tj.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreseers.tj.mapper.UserLookHistoryMapper;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UserLookHistory;
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserLookHistoryService;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.UsermatchService;

@Service
public class UserLookHistoryServiceImpl implements UserLookHistoryService {

	private static final Logger log = LoggerFactory.getLogger(UserLookHistoryServiceImpl.class);
	
	@Autowired
	private UserLookHistoryMapper userLookHistoryMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UsermatchService usermatchService;

	@Autowired
	private UserFriendService userFriendService;
	
	@Autowired
	private UserCaHistoryService userCaHistoryService;
	
	@Override
	public String updateUserLook(int userid, int lookid) {
		// TODO Auto-generated method stub
		try {
			UserLookHistory userLookHistory = new UserLookHistory();
			userLookHistory.setUserid(userid);
			userLookHistory.setLookid(lookid);
			UserLookHistory  userLookHistoryinfo = userLookHistoryMapper.selectByUserLookHistory(userLookHistory);
			log.info("userLookHistoryinfo:"+userLookHistoryinfo);
			if(userLookHistoryinfo == null) {
				log.info("用户没有查看过此用户");
				LocalDate localDate = LocalDate.now();
				DateTimeFormatter  dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//	DateFormatter  dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String looktime = localDate.format(dateformat);
				userLookHistory.setLooktime(looktime);
				userLookHistoryMapper.insertSelective(userLookHistory);
				log.info("将信息插入到数据库");
			}
			return "success";
			
		}catch(Exception r) {
			log.error("更新失败");
			return "fail";
		}
		
	}

	@Override
	public List<List> showUserLook(int userid) {
	List<UserLookHistory> UserLookHistorys = userLookHistoryMapper.selectByUserid(userid);
		log.info("UserLookHistorys:"+UserLookHistorys);
		
		 List<List> returnlist = new ArrayList<>();
		 List<Map> list = new ArrayList<>();
		for(UserLookHistory userLookHistory:UserLookHistorys) {
			 Map<String,Object> map = new HashMap<String,Object>();
			 int id = userLookHistory.getUserid();
			 User user = userService.selectByPrimaryKey(id);
			 UsermatchWithBLOBs usermatchWithBLOBs =  usermatchService.usermatchQuery(userid, id);  //得到这两个人的关系
			 UserFriend userFriend=   userFriendService.selectUserFriend(userid+"", id+"");       //查询两个人是否存在关系
			 String head = user.getPicture();
			 if(userFriend != null) { //两人存在关系
				 if(userFriend.getLookhead() == 1) {
					 head = user.getHead();  //清晰的头像
				 }
			 }
			 	if(head.equals(user.getPicture())) {
				 UserCaHistory userCaHistoryinfo = new UserCaHistory();
				 userCaHistoryinfo.setUserid(userid);
				 userCaHistoryinfo.setCaid(id);
				 if(userCaHistoryService.selectByUserCaHistory(userCaHistoryinfo) != null) {
					 log.info("说明此用户对这个用户使用过擦子");
					 head = user.getHead();  //清晰的头像
				 }
			 }
			 	 log.info("usermatchWithBLOBs"+usermatchWithBLOBs);	
			 	 map.put("userid", user.getId());     //名字
			 	 map.put("username", user.getUsername());     //名字
				 map.put("sex", user.getSex());               //性别
				 map.put("age", user.getReservedint());       //年龄
				 map.put("time", userLookHistory.getLooktime()); //擦的时间		
				 map.put("userscore", usermatchWithBLOBs.getUserscore()); //匹配度
				 map.put("ziwei", user.getZiwei());               //紫薇
				 map.put("head", head);                         //头像地址
				 map.put("DESC", usermatchWithBLOBs.getUserdesc());  
//				 log.info(user.getUsername());
//				 log.info(user.getSex());
				 log.info("map"+map);
				 if(list.size()>0) {
					 int status = 0;
				 for(int i= 0;i<list.size();i++) {
					 Map listmap = list.get(i);
					 DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
					  String listtime = (String) listmap.get("time");
					  String maptime = (String) map.get("time");
					 if(listtime.equals(maptime)) {
						 list.add(map);
						// returnlist.add(list);
						 status = 1;
						 break;
					 }
				 }
				 if(status == 0) {
					 List<Map> listnew = new ArrayList<>();
					 listnew.add(map);
					 returnlist.add(listnew);
				 }
				}else {
					list.add(map);	
				}		
		}
		
		 returnlist.add(list);
		
		return returnlist;
	}

	@Override
	public List<Map> showBydate(int userid, String date) {
		// TODO Auto-generated method stub
		log.info("通过时间查询谁看过我");
		List<UserLookHistory> UserLookHistorys = userLookHistoryMapper.selectByUserid(userid);
		List<Map> list = new ArrayList<Map>();
		 for(UserLookHistory userLookHistory:UserLookHistorys) {	
			 if(date.equals(userLookHistory.getLooktime())) {
			 Map<String,Object> map = new HashMap<String,Object>();
			 int id = userLookHistory.getUserid();
			 log.info("id:"+id);
			 User user = userService.selectByPrimaryKey(id);
			 log.info("user:"+user);
			 UsermatchWithBLOBs usermatchWithBLOBs =  usermatchService.usermatchQuery(userid, id);  //得到这两个人的关系
			 UserFriend userFriend=   userFriendService.selectUserFriend(userid+"", id+"");       //查询两个人是否存在关系
			 String head = user.getPicture();
			 if(userFriend != null) {  //两人存在关系
				 if(userFriend.getLookhead() == 0) {
					 head = user.getHead();
				 }
			 }
			 if(head.equals(user.getPicture())) {
				 UserCaHistory userCaHistoryinfo = new UserCaHistory();
				 userCaHistoryinfo.setUserid(userid);
				 userCaHistoryinfo.setCaid(id);
				 if(userCaHistoryService.selectByUserCaHistory(userCaHistoryinfo) != null) {
					 log.info("说明此用户对这个用户使用过擦子");
					 head = user.getHead();  //清晰的头像
				 }
			 }
			 log.info("head:"+head);
			 map.put("username", user.getUsername());     //名字
			 map.put("sex", user.getSex());               //性别
			 map.put("age", user.getReservedint());       //年龄
			 map.put("time", userLookHistory.getLooktime()); //擦的时间		
			 map.put("userscore", usermatchWithBLOBs.getUserscore()); //匹配度
			 map.put("ziwei", user.getZiwei());               //紫薇
			 map.put("head", head);                         //头像地址
			 map.put("DESC", usermatchWithBLOBs.getUserdesc());  
			 log.info("map:"+map);
			 list.add(map);
		 }
	  }	
		
		
		return list;
	}

}
