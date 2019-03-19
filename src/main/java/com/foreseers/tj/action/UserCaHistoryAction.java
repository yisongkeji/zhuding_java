package com.foreseers.tj.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserCanumsService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.UsermatchService;

@Controller
@RequestMapping("/userhistory")
public class UserCaHistoryAction extends BaseAction{
	
	private static final Logger log = LoggerFactory.getLogger(UserCaHistoryAction.class);
	
	@Autowired
	private UserCaHistoryService userCaHistoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private UsermatchService usermatchService;
	@Autowired
	private UserFriendService userFriendService;
	
	@RequestMapping("/updatehistory")
	@ResponseBody
	public ResultType updateuserhistory(HttpServletRequest request) throws BusinessExpection {
		log.info("进入擦用户头像方法");
		String userid = request.getParameter("userid");
		String caid = request.getParameter("caid");
		log.info("请求参数：userid："+userid);
		log.info("请求参数：caid："+caid);
		if(userid == null || caid == null) {
			log.error("参数不合法");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		//UserCanums userCanumsService.selectByUserKey(Integer.parseInt(userid));
		
		String  result = userCaHistoryService.userCaHistoryService(userid,caid);
		if(result.equals("success")) {
			//更新被擦数
			User userinfo =  userService.selectByPrimaryKey(Integer.parseInt(caid));
			int num = userinfo.getNum()+1;
			User user = new User();
			user.setId(Integer.parseInt(caid));
			user.setNum(num);
			userService.updateByPrimaryKeySelective(user);
			//更新用户的擦子数 减一，userid，（新增）
			
			//更新用户的擦子数 减一，userid，（新增）
			return ResultType.creat(result);
		}else {
			return ResultType.creat(result,"fail");
		}
	}
	
	@RequestMapping("/showUserHistory")
	@ResponseBody
	public ResultType showUserHistory(HttpServletRequest request) throws ParseException {
		log.info("进入谁擦过我好友列表");
		int userid = Integer.parseInt(request.getParameter("userid"));
		log.info("请求参数：caid"+userid);
		 List<UserCaHistory>  UserCaHistorys = userCaHistoryService.userCaHistoryService(userid);
		 log.info(""+UserCaHistorys);

		 List<List> returnlist = new ArrayList<>();
		 List<Map> list = new ArrayList<>();
		 for(UserCaHistory userCaHistory:UserCaHistorys) {
			
			 Map<String,Object> map = new HashMap<String,Object>();
			 int id = userCaHistory.getUserid();   //得到好友的ID
			 log.info("好友id:"+id);
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
			 map.put("time", userCaHistory.getUsertime()); //擦的时间		
			 map.put("userscore", usermatchWithBLOBs.getUserscore()); //匹配度
			 map.put("ziwei", user.getZiwei());               //紫薇
			 map.put("head", head);                         //头像地址
			 map.put("DESC", usermatchWithBLOBs.getUserdesc());  
			// log.info(user.getUsername());
			// log.info(user.getSex());
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
		 log.info("返回的参数："+returnlist);
		return ResultType.creat(returnlist);
	}
	
	@RequestMapping("/showBydate")
	@ResponseBody
	public ResultType showBydate(HttpServletRequest request) throws BusinessExpection {
		String id =request.getParameter("userid");
		String date = request.getParameter("datetime");
		if(id == null || date == null) {
			log.error("参数不合法");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		int userid = Integer.parseInt(id);
		List<Map> list = userCaHistoryService.showBydate(userid,date);
		
		return ResultType.creat(list);
	}
}
