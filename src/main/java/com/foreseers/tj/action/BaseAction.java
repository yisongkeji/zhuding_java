package com.foreseers.tj.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;



@Controller
public class BaseAction {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handelExpection(HttpServletRequest request,Exception ex) {
		Map<String,Object> mapExpection = new HashMap();
		       if(ex instanceof BusinessExpection) {
				BusinessExpection businessExpection =  (BusinessExpection)ex; 
		//ResultType resultType = new ResultType();
		//resultType.setStatus("fail");
				mapExpection.put("errCode", businessExpection.getErrcode());
				mapExpection.put("errMsg", businessExpection.getErrMsg());
		     // resultType.setData(ex);				
		       }else {
		    	   mapExpection.put("errCode",EmBussinsError.UNKNOWN_ERROR.getErrcode());
					mapExpection.put("errMsg",EmBussinsError.UNKNOWN_ERROR.getErrMsg());
		       }
		       return ResultType.creat(mapExpection, "fail");
	//	return resultType;
		
	}

	
}
