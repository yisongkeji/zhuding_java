package com.foreseers.tj.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.mapper.UserFriendMapper;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.service.UserFriendService;

@Service
@Transactional
public class UserFriendServiceImpl implements UserFriendService {

	@Autowired
	private UserFriendMapper userFriendMapper;
	
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
				String friendtime = userFriend.getFirendtime();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date friendt = format.parse(friendtime);  //成为好友的时间
				Date date = new Date();                   //当前时间
				 long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
				long nh = 1000 * 60 * 60;//一小时的毫秒数
				long diff = date.getTime()-friendt.getTime();
				long hour = diff / nh;            //到现在已经多个小时
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("userid", userFriend.getUserId());
				map.put("friend", userFriend.getFriendId());
				map.put("hour", hour);
				list.add(map);
			}
		}
		
		return list;
	}



}
