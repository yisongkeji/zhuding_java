package com.foreseers.tj.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserExample;

public interface UserService {

	 int deleteByPrimaryKey(Integer id);
	 int insertSelective(User record);
	 User QueryUser(String facebookid);
	 
	 List<Integer> QueryUserByCity(Map map);
	 
	 int updateByFaceIDSelective(User record);
	 User selectByPrimaryKey(Integer id);
	 
	 List<User> selectUserlist(User user);
	 
	 List<User> selectByExample(UserExample example);
	 
	 List<Integer> QueryUserByNUM(Integer paihang,Integer getnum,Integer userid);
	 
	 List<Integer> QueryUserByqueNUM(Map map);
	 
	 int updateByPrimaryKeySelective(User record);
	void minuserfriendnum(int parseInt);
	void addserfriendnum(int parseInt);
	
	Map<String,Object> showMyself(int userid) throws BusinessExpection;  //展示自己的个人信息
	String compressPictures(String imagepath,String save) throws BusinessExpection;
	
	//更新vip时间
	String userSetvip(int userid,int vipdate) throws ParseException;
	
	//判断头像是否是清晰头像
	int showUserHead(int userid,int userinfoid);
	
	User insertUser(Map<String,Object> map) throws ClientProtocolException, IOException, BusinessExpection;
}
