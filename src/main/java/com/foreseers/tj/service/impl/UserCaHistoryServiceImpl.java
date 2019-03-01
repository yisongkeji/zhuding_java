package com.foreseers.tj.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.action.UserCaHistoryAction;
import com.foreseers.tj.mapper.UserCaHistoryMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserCanumsService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.UsermatchService;

@Service
@Transactional
public class UserCaHistoryServiceImpl implements UserCaHistoryService {
	
	private static final Logger log = LoggerFactory.getLogger(UserCaHistoryService.class);
	@Autowired
	private UserCaHistoryMapper userCaHistoryMapper;
	
	@Autowired
	private UserCanumsService userCanumsService; 
	
	@Autowired
	private UserService userService;
	@Autowired
	private UsermatchService usermatchService;
	@Autowired
	private UserFriendService userFriendService;
	
	@Override
	public int insertSelective(UserCaHistory record) {
		// TODO Auto-generated method stub
		return userCaHistoryMapper.insertSelective(record);
	}

	@Override
	@Transactional
	public String userCaHistoryService(String userid, String caid) throws BusinessExpection {
		// TODO Auto-generated method stub
		UserCanums userCanums = userCanumsService.selectByUserKey(Integer.parseInt(userid));
		if( userCanums == null) {
			log.error("用户信息不存在");
			throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT); 
		}
		if(userCanums.getNums() == 0) {
			log.error("用户擦字数为0,不能使用擦子");
			throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"用户擦子数为0"); 
		}

		try {
		UserCaHistory userCaHistory = new UserCaHistory();
		userCaHistory.setUserid(Integer.parseInt(userid));
		userCaHistory.setCaid(Integer.parseInt(caid));
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = format.format(date);	
		userCaHistory.setUsertime(datetime);
		userCaHistoryMapper.insertSelective(userCaHistory);   //保存到数据库
		//将用户的擦字数减一
		UserCanums userCanumsinfo = new UserCanums();
		userCanumsinfo.setId(userCanums.getId());
		userCanumsinfo.setNums(userCanums.getNums()-1);
		userCanumsService.updateByPrimaryKeySelective(userCanumsinfo);	
		
		return "success";				
		}catch(Exception e) {
			return "fail";
		}	
		
	}

	@Override
	public UserCaHistory selectByUserCaHistory(UserCaHistory userCaHistory) {
		// TODO Auto-generated method stub
		return userCaHistoryMapper.selectByUserCaHistory(userCaHistory);
	}

	@Override
	
	public List<UserCaHistory> userCaHistoryService(Integer caid) {
		// TODO Auto-generated method stub
		return userCaHistoryMapper.userCaHistoryService(caid);
	}

	@Override
	/*
	 * 通过时间查询谁擦过我
	 * @see com.foreseers.tj.service.UserCaHistoryService#showBydate(int, java.lang.String)
	 */
	
	public List<Map> showBydate(int userid, String date) {
		// TODO Auto-generated method stub
		log.info("通过时间查询谁擦过我");
		 List<UserCaHistory>  UserCaHistorys = userCaHistoryService(userid);
		 List<Map> list = new ArrayList<Map>();
		 for(UserCaHistory userCaHistory:UserCaHistorys) {	
			 if(date.equals(userCaHistory.getUsertime())) {
			 Map<String,Object> map = new HashMap<String,Object>();
			 int id = userCaHistory.getUserid();
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
				 if(selectByUserCaHistory(userCaHistoryinfo) != null) {
					 log.info("说明此用户对这个用户使用过擦子");
					 head = user.getHead();  //清晰的头像
				 }
			 }
			 log.info("head:"+head);
			 map.put("username", user.getUsername());     //名字
			 map.put("sex", user.getSex());               //性别
			 map.put("age", user.getReservedint());       //年龄
			 map.put("time", userCaHistory.getUsertime()); //擦的时间		
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
