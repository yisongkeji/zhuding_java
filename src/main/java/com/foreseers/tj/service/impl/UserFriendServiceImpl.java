package com.foreseers.tj.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.mapper.UserFriendMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserService;

@Service
@Transactional
public class UserFriendServiceImpl implements UserFriendService {
	
	private static final Logger log = LoggerFactory.getLogger(UserFriendServiceImpl.class);
	
	@Autowired
	private UserFriendMapper userFriendMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCaHistoryService userCaHistoryService;
	
	@Override
	public int insertSelective(UserFriend record) {
		// TODO Auto-generated method stub
		return userFriendMapper.insertSelective(record);
	}

	@Override
	public int selectcountnum(String userid) {
		// TODO Auto-generated method stub
		return userFriendMapper.selectcountnum(userid);
	}

	@Override
	public List<String> selectlist(String userid) {
		// TODO Auto-generated method stub
		return userFriendMapper.selectlist(userid);
	}

	@Override
	public UserFriend selectUserFriend(String user_id, String friend_id) {
		// TODO Auto-generated method stub
		return userFriendMapper.selectUserFriend(user_id, friend_id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserFriend record) {
		// TODO Auto-generated method stub
		return userFriendMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	public String friendTime(Map<String, Object> map) {
		int uid =(int) map.get("uid");
		UserFriend userFriend = new UserFriend();
		userFriend.setId(uid);
		userFriend.setLookhead(Integer.parseInt((String)map.get("lookhead")));
		userFriend.setSendpix(Integer.parseInt((String)map.get("sendpix")));
		userFriend.setLookimages(Integer.parseInt((String)map.get("lookimages")));
		int num = userFriendMapper.updateByPrimaryKeySelective(userFriend);
		//System.out.println(num);
		String result = "false";
		if(num == 1) {
			result = "success";
		}
		return result;
	}

	@Override
	@Transactional
	public List<Map> selectUserFriendList(String userid) throws ParseException {
		List<UserFriend>  listUserFriend = userFriendMapper.selectUserFriendList(userid);
		List<Map> list = new ArrayList<>();
		for(UserFriend userFriend:listUserFriend) {
			if(userFriend.getUserReation() == 0) {
				if(userFriend.getLookhead() != 1 || userFriend.getLookimages() != 1 || userFriend.getSendpix() != 1) {
				String friendtime = userFriend.getFirendtime();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date friendt = format.parse(friendtime);  //成为好友的时间
				Date date = new Date();                   //当前时间
				 long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
				long nh = 1000 * 60 * 60;//一小时的毫秒数
				long diff = date.getTime()-friendt.getTime();
				//long hour = diff / nh;            //到现在已经多个小时
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("userid", userFriend.getUserId());
				map.put("friend", userFriend.getFriendId());
				map.put("hour", diff);
				list.add(map);
				}
			}
		}
		
		return list;
	}

	@Override
	@Transactional
	public String deletefriend(Map<String, Object> map) throws BusinessExpection {
		// TODO Auto-generated method stub
		log.info("map:"+map);
		String userid = (String)map.get("userid");
		String friendid = (String)map.get("friendid");
		int reation = (int)map.get("reation");
		
		UserFriend userFriend  = selectUserFriend(userid,friendid); //查询出这条记录
		if(userFriend != null) {
			UserFriend userFriendinfo = new UserFriend();
			userFriendinfo.setId(userFriend.getId());
			userFriendinfo.setUserReation(reation);
			userFriendinfo.setLookhead(0);
			userFriendinfo.setLookimages(0);
			userFriendinfo.setSendpix(0);
			updateByPrimaryKeySelective(userFriendinfo);  //更新状态
			//好友位数量加一  minuserfriendnum   addserfriendnum
			userService.addserfriendnum(Integer.parseInt(userid));
			userService.addserfriendnum(Integer.parseInt(friendid));
			//好友位数量加一
			
			return "success";
		}else {
			log.error("两人不是好友关系");
			throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"两人不是好友关系");
			
		}
		
	}

	/*
	 * 获取黑名单列表方法
	 * @see com.foreseers.tj.service.UserFriendService#getBlacklist(java.lang.String)
	 */
	@Override
	public List<Map> getBlacklist(String userid) {
		// TODO Auto-generated method stub
		
		List<String> ids = userFriendMapper.selectBlacklist(userid);
		 List<Map> rutrnlist = new ArrayList<Map>();
		if(ids.size() > 0) {
			for(int i=0;i<ids.size();i++) {
				int frid = Integer.parseInt(ids.get(i));
				Map<String,Object> map = new HashMap<>();
				User user= userService.selectByPrimaryKey(frid);
				map.put("userid", frid);
				map.put("username", user.getUsername());
				UserFriend userFriend = selectUserFriend(userid,ids.get(i));  //查询好友关系
				map.put("date", userFriend.getFirendtime());
				int lookhead = 0;
				if(userFriend != null) {
					lookhead = userFriend.getLookhead();
				}
				if(lookhead == 1) {
					map.put("userhead", user.getHead());
				}else {
		    		 //判断是否使用过擦子
					 UserCaHistory userCaHistoryinfo = new UserCaHistory();
					 userCaHistoryinfo.setUserid(Integer.parseInt(userid));
					 userCaHistoryinfo.setCaid(frid);
					 if(userCaHistoryService.selectByUserCaHistory(userCaHistoryinfo) != null) {
						 map.put("userhead",  user.getHead());
					 }else {
						 map.put("userhead",  user.getPicture());
					 }
				}
				
				rutrnlist.add(map);
			}
		}
		return rutrnlist;
	}



}
