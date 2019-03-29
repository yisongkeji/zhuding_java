package com.foreseers.tj.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.foreseers.tj.mapper.UserDefriendMapper;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserDefriend;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserDefriendService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserService;
@Service
public class UserDefriendServiceImpl implements UserDefriendService{

	private static final Logger log = LoggerFactory.getLogger(UserDefriendServiceImpl.class);
	
	@Autowired
	private UserDefriendMapper userDefriendMapper;
	
	@Autowired
	private UserFriendService userFriendService;
	
	@Autowired
	private UserService UserService;
	@Autowired
	private UserCaHistoryService userCaHistoryService;
	/*
	 * 用户拉黑
	 * @see com.foreseers.tj.service.UserDefriendService#pullDefriend(int, int)
	 */
	@Override
	@Transactional
	public String pullDefriend(int userid, int blackid) {
		// TODO Auto-generated method stub
		try {
			
		UserDefriend userDefriend = new UserDefriend();
		userDefriend.setUserid(userid);
		userDefriend.setBlackid(blackid);
		UserDefriend  userDefriendinfo =  userDefriendMapper.selectUserDefriend(userDefriend);
		if(userDefriendinfo == null) {
			LocalDate date = LocalDate.now();
			DateTimeFormatter fatmat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String time = date.format(fatmat);
			userDefriend.setDefriendtime(time);
			userDefriendMapper.insertSelective(userDefriend);
			log.info("插入到数据库成功");
		
		//判断是否是好友,如果是解除好友关系  selectUserFriend
		UserFriend userFriend =  userFriendService.selectUserFriend(userid+"", blackid+"");
		if(userFriend != null) {
			if(userFriend.getUserReation() == 0) {
				log.info("两个人是好友，解除好友关系");
				UserFriend UserFriendinfo = new UserFriend();
				UserFriendinfo.setId(userFriend.getId());
				UserFriendinfo.setUserReation(2);
				UserFriendinfo.setLookhead(0);
				UserFriendinfo.setLookimages(0);
				UserFriendinfo.setSendpix(0);
				userFriendService.updateByPrimaryKeySelective(UserFriendinfo);
				log.info("操作成功");
				//两个用户的好友位加一
				UserService.addserfriendnum(userid);
				UserService.addserfriendnum(blackid);
				log.info("好友位加一");
			}
			}
		}	
		//判断是否是好友,如果是解除好友关系
		return "success";
		}catch(Exception e) {
			log.error("插入到数据库出现异常");
			return "fail";
		}
		
	}
	/*
	 * 获取和名单列表(non-Javadoc)
	 * @see com.foreseers.tj.service.UserDefriendService#getBlackList(int)
	 */
	@Override
	public List<Map> getBlackList(int parseInt) {
		
		List<UserDefriend>  lists = userDefriendMapper.getBlackList(parseInt);
		 List<Map> rutrnlist = new ArrayList<Map>();
		if(lists.size()>0) {
			log.info("存在拉黑列表");
			for(UserDefriend userDefriend:lists) {
				Map<String,Object> map = new HashMap<String,Object>(); 
				User user = UserService.selectByPrimaryKey(userDefriend.getBlackid());    //获得好友
				UserFriend userFriend = userFriendService.selectUserFriend(parseInt+"",userDefriend.getBlackid()+"");  //查询好友关系
				int lookhead = 0;
				if(userFriend != null) {
					lookhead = userFriend.getLookhead();
				}
				if(lookhead == 1) {
					log.info("返回清晰头像");
					map.put("userhead", user.getHead());
				}else {
		    		 //判断是否使用过擦子
					 UserCaHistory userCaHistoryinfo = new UserCaHistory();
					 userCaHistoryinfo.setUserid(parseInt);
					 userCaHistoryinfo.setCaid(userDefriend.getBlackid());
					 if(userCaHistoryService.selectByUserCaHistory(userCaHistoryinfo) != null) {
						 map.put("userhead",  user.getHead());
						 log.info("返回清晰头像");
					 }else {
						 map.put("userhead",  user.getPicture());
						 log.info("返回模糊头像");
					 }
				}
				map.put("userid", userDefriend.getBlackid());
				map.put("username", user.getUsername());
				map.put("date", userDefriend.getDefriendtime());
				log.info("返回值map:"+map);
				rutrnlist.add(map);
			}
		}
		
		return rutrnlist;
	}
	@Override
	@Transactional
	public String removeUser(int userid, int blackid) {
		// TODO Auto-generated method stub
		try {
		UserDefriend userDefriend = new UserDefriend();
		userDefriend.setUserid(userid);
		userDefriend.setBlackid(blackid);
		userDefriendMapper.removeUser(userDefriend);
		log.info("从黑名单表里移除");
		
			return "success";
		
		}catch(Exception e) {
			return "fail";
		}
		
	}

}
