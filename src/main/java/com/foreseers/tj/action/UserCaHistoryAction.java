package com.foreseers.tj.action;

import java.text.SimpleDateFormat;
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
import com.foreseers.tj.model.UsermatchWithBLOBs;
import com.foreseers.tj.service.UserCaHistoryService;
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

		String  result = userCaHistoryService.userCaHistoryService(userid,caid);
		if(result.equals("success")) {
			//更新被擦数
			User userinfo =  userService.selectByPrimaryKey(Integer.parseInt(caid));
			int num = userinfo.getNum()+1;
			User user = new User();
			user.setId(Integer.parseInt(caid));
			user.setNum(num);
			userService.updateByPrimaryKeySelective(user);
			return ResultType.creat(result);
		}else {
			return ResultType.creat(result,"fail");
		}
	}
	
	@RequestMapping("/showUserHistory")
	@ResponseBody
	public String showUserHistory(HttpServletRequest request) {
		log.info("进入谁擦过我好友列表");
		int userid = Integer.parseInt(request.getParameter("userid"));
		log.info("请求参数：caid"+userid);
		 List<UserCaHistory>  UserCaHistorys = userCaHistoryService.userCaHistoryService(userid);
		 Map<String,Object> map = new HashMap<String,Object>();
		 
		 for(UserCaHistory userCaHistory:UserCaHistorys) {
			 int id = userCaHistory.getUserid();
			 User user = userService.selectByPrimaryKey(id);
			 UsermatchWithBLOBs usermatchWithBLOBs =  usermatchService.usermatchQuery(userid, id);  //得到这两个人的关系
			 map.put("username", user.getUsername());
			 map.put("sex", user.getSex());
			 map.put("age", user.getReservedint());
			 map.put("time", userCaHistory.getUsertime());			 
			 log.info(user.getUsername());
			 log.info(user.getSex());
		 }		
		return UserCaHistorys.toString();
	}
}
