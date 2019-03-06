package com.foreseers.tj.action;

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
import com.foreseers.tj.service.UserLookHistoryService;

import sun.reflect.generics.tree.ReturnType;

@Controller
@RequestMapping("/userLook")
public class UserLookHistoryAction extends BaseAction{

	private static final Logger log = LoggerFactory.getLogger(UserLookHistoryAction.class);
	@Autowired
	private UserLookHistoryService userLookHistoryService;
	
	@RequestMapping("/updateUserLook")
	@ResponseBody
	public ResultType updateUserLook(HttpServletRequest request) throws BusinessExpection {
		String userid =  request.getParameter("userid");
		String lookid = request.getParameter("lookid");
		log.info("请求参数：userid"+userid);
		log.info("请求参数：lookid"+lookid);			
		if(userid == null || lookid == null) {
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		String result =  userLookHistoryService.updateUserLook(Integer.parseInt(userid),Integer.parseInt(lookid));

		return ResultType.creat(result);
	}
	
	
}
