package com.foreseers.tj.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.httptest;
import com.foreseers.tj.huanxin.HttpHuanxin;
import com.foreseers.tj.mapper.UserMapper;
import com.foreseers.tj.mapper.ZoneMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.ReturnImage;
import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.service.UserImageService;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.ZoneService;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserAction extends BaseAction{
	
	private static final Logger log = LoggerFactory.getLogger(UserAction.class);
	
	@Autowired
	private UserService userService;
		
	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private UserImageService userImageService;
	/*
	 * 查询用户方法
	 */
	@RequestMapping("/queryUser")
	@ResponseBody
	public ResultType queryUser(HttpServletRequest request) throws BusinessExpection {
		log.info("进入查询用户方法");
		String facebookid = request.getParameter("facebookid");
		//request.getSession();
		log.info("facebookid："+facebookid);
		User user =  userService.QueryUser(facebookid);

		if(user == null) {
			log.info("用户不存在，为新用户");
		 throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT);
		}
		return ResultType.creat(user);
	}
	
	/*
	 * 用户注册方法
	 */
	@RequestMapping("/insertUser")
	@ResponseBody
	public ResultType insertUser(HttpServletRequest request) throws BusinessExpection, ClientProtocolException, IOException {
		log.info("进入用户注册方法");
		String username = request.getParameter("username");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String gender = request.getParameter("gender");
		String facebookid = request.getParameter("facebookid");
		String  zoneString = request.getParameter("zone");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String spare = request.getParameter("addr");
		String spare1 = request.getParameter("addrs");
		String lat = request.getParameter("lat");   //经度
		String lng = request.getParameter("lng");   //纬度	
	//	System.out.println(zoneString);
		int zone = 0;
	//	String  zoneString = "UTC-12:00";
		String ziwei = "";        //ziwei
		String numerology = "";  //num
		String horoscope = "";  //星座
		String zodiac = "";    //生肖		
		String bazi = "";     //八字
		String cat1 = "";
		String star = "";
		log.info("用户名:"+username);
		log.info("日期:"+date);
		log.info("时间:"+time);
		log.info("性别:"+gender);
		log.info("facebookid:"+facebookid);
		log.info("时区："+zoneString);
	//	ZoneAction zoneAction = new ZoneAction();
		Timezone timezone = zoneService.selectByName(zoneString);
		if(timezone != null) {
			 zone = timezone.getId();
		}else {
			throw new BusinessExpection(EmBussinsError.UNKNOWN_ERROR);
			
		}
		//计算年龄
		 Date datetime = new Date();
		 String dateyear[] =  date.split("-");
		 
		 int age = datetime.getYear()+1900-Integer.parseInt(dateyear[0]);	    
		
		//现将用户信息插入表中
		User userinfo = new User();
		userinfo.setFacebook(facebookid);
		userinfo.setUsername(username);
		userinfo.setDate(date);
		userinfo.setTime(time);
		userinfo.setZone(zone);
		userinfo.setCountry(country);
		userinfo.setCity(city);
		userinfo.setArea(area);
		userinfo.setSpare(spare);
		userinfo.setSpare1(spare1);
		userinfo.setLat(Double.parseDouble(lat));
		userinfo.setLng(Double.parseDouble(lng));
		userinfo.setReservedint(age);
		userinfo.setReservedvar(20+"");
		int insertid =  userService.insertSelective(userinfo);  
		int accountId = userinfo.getId();
	//	User user1= userService.QueryUser(facebookid);
//		int accountId = user1.getId();
		
		String url = "https://api2047.foreseers.com/Dating/personalAnalysis";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("time", time);
		map.put("gender", gender);
		map.put("accountId",accountId);
		
		httptest httptest = new httptest();
		                     //sendPostDataByJson
		String body = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
		
		JSONObject jsn = JSON.parseObject(body);
		 String errcode = jsn.getString("errCode");
		if(errcode.equals("200") ) {
			log.info("调用接口成功");
			numerology = jsn.getString("numerology");  
		    cat1 = jsn.getString("cat1");  //五行
		    star = jsn.getString("star");  
			horoscope = jsn.getString("horoscope");  //星座
			zodiac = jsn.getString("zodiac");   //生肖
			//ziwei
			JSONArray ziweiArry = jsn.getJSONArray("ziwei");  
			StringBuffer str = new StringBuffer();
			String str1 = "";
			 for(int j= 0;j<ziweiArry.size();j++) {
				  String ziwei1 = ziweiArry.get(j).toString();
				  str1 =  str.append(ziwei1+",").toString();
			 } 
			ziwei =  str1.substring(0,str1.length()-1);    //得到ziwei
			 //八字
			JSONArray baziarry = jsn.getJSONArray("bazi");    
			StringBuffer strba = new StringBuffer();
			String  strbazi = "";
			for(int i = 0;i<baziarry.size();i++) {
				strbazi = strba.append(baziarry.get(i)+",").toString();
			}
			bazi = strbazi.substring(0,strbazi.length()-1);
					
		}else {			
			//userService.
			throw new BusinessExpection(EmBussinsError.MINGSHU_ERROR);
		}
		/*
		 *环信注册 
		 */
		HttpHuanxin httpHuanxin = new HttpHuanxin();
	       String hstr=  "http://a1.easemob.com/1106190114019314/foreseers/users";
	       Map<String,Object> maph = new HashMap<String, Object>();
	        maph.put("username", userinfo.getId());
	        maph.put("password", "123");	
	        CloseableHttpResponse reponse =  httpHuanxin.sendPostDataByJson(hstr, JSON.toJSONString(maph), "utf-8",null);
	        int status = reponse.getStatusLine().getStatusCode();
	        if(status != 200) {
	        	
	        	throw new BusinessExpection(EmBussinsError.HUANXIN_ERROR);
	        }
	        
			/*
			 *环信注册 
			 */		
		User user = new User();
		user.setId(accountId);
		user.setSex(gender);
		user.setBazi(bazi);
		user.setUsername(username);
		user.setDate(date);
		user.setTime(time);
		user.setFacebook(facebookid);
		user.setCat1(cat1);
		//user.setNum(Integer.parseInt(numerology));
		user.setNumerology(Integer.parseInt(numerology));
		user.setXingzuo(horoscope);
		user.setZiwei(ziwei);
		user.setZone(zone);
		user.setZodiac(zodiac);
		user.setUserstar(Integer.parseInt(star));
		
		log.info("user:"+user);
		userService.updateByPrimaryKeySelective(user);
		
		return ResultType.creat(user);
	}
	
	/*
	 * 头像上传
	 */
	@RequestMapping("/uploadhead")
	@ResponseBody
	public ResultType uploadtou(HttpServletRequest request,MultipartFile file) throws BusinessExpection, IllegalStateException, IOException {
		String imagepath = "E:/dt/head"; 
	
		if(file == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
	    String facebook = request.getParameter("facebookid");
		if( facebook == null || facebook == "") {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);			
		}
		User userinfo = userService.QueryUser(facebook);
		if(userinfo != null) {
		String userhead = userinfo.getHead();
			if(userhead != null || userhead != "") {
				String headold = userhead.substring(25);
				new File(imagepath+"/"+headold).delete(); 
			}
		}
		String name = file.getOriginalFilename();
		
	//	String imagepath = "/var/zhuding/head";   服务器上的存放图片的地址（记得修改application.yml配置文件）
		File savefile = new File(imagepath);
		if(!savefile.exists()) {
			savefile.mkdirs();
		}
		
		String save = imagepath+"/"+name;
		String saveurl = "http://192.168.1.73:8080/"+name;
	//	String saveurl = "http://chat.foreseers.com/"+headname;    服务器上的保存图片的路径
		//System.out.println(save);
		file.transferTo(new File(save));
		User user = new User();
		user.setFacebook(facebook);
		user.setHead(saveurl);
		userService.updateByFaceIDSelective(user);
		return ResultType.creat(user);
	}
	
	/*
	 * 个人信息
	 */
	@RequestMapping("/userpersonal")
	@ResponseBody
	public ResultType userpersonal(HttpServletRequest request) throws BusinessExpection {
		String id =  request.getParameter("userid");
		List<String> listimage = new ArrayList<String>();   //图片地址的list
		Map<String,String> map = new HashMap<String,String>();
		ReturnImage returnImage = new ReturnImage();
		int countimage = 0;
 		if(id != null) {
			int userid = Integer.parseInt(id);
			User user =	userService.selectByPrimaryKey(userid);
			List<UserImage> list = userImageService.queryByUseridlist(userid);
			if(list != null) {
			 countimage = list.size();
				for(UserImage userImage :list ) {
					//	userImage.getImage();
					String image = userImage.getImage();
					String imagename = userImage.getImagename();
					listimage.add(userImage.getImage());
					map.put(imagename, image);
				//	listimage.add(map);
				}
			
			}
			returnImage.setCountnum(countimage);
			returnImage.setListimage(listimage);
			
			BeanUtils.copyProperties(user, returnImage);
		}else {
			//参数不合法
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}

		return ResultType.creat(returnImage);
	}
	
	/*
	 * 更新会员基本信息
	 */
	@RequestMapping("/updateuser")
	@ResponseBody
	public ResultType updateuser(HttpServletRequest request) throws BusinessExpection, NumberFormatException, ClientProtocolException, IOException {
		
		String userid = request.getParameter("userid"); //
		String name = request.getParameter("name"); //昵称
		String sex = request.getParameter("sex");   //性别
		String date = request.getParameter("date");
		String time = request.getParameter("time");
	//	String age = request.getParameter("age");
	//	String xingshu = request.getParameter("xingsu");
		User userfirst = userService.selectByPrimaryKey(Integer.parseInt(userid));
		User user = new User();
		if(userid == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}else {
			//user.setFacebook(facebook);
			user.setId(Integer.parseInt(userid));
		}
		if(name != null) {
			user.setUsername(name);
			userService.updateByPrimaryKeySelective(user);
		}

		if(sex != null) {
		//	user.setSex(sex);
			String datesex = userfirst.getDate();
			String timesex = userfirst.getTime();
			//String gender = userfirst.getSex();
			dating(datesex,timesex,sex,Integer.parseInt(userid));			
		}
		
		if(date != null && time != null) {  //日期
			
			String gender = userfirst.getSex();
			 Date datetime = new Date();
			 String dateyear[] =  date.split("-");
			 int age = datetime.getYear()+1900-Integer.parseInt(dateyear[0]);	
			 user.setReservedint(age);
			 userService.updateByPrimaryKeySelective(user);
			dating(date,time,gender,Integer.parseInt(userid));
   
		}
		
		//System.out.println(user);
	//	userService.updateByFaceIDSelective(user);
		User userinfo =  userService.selectByPrimaryKey(Integer.parseInt(userid));
		
		return ResultType.creat(userinfo);
	}
	
	public void  dating(String date,String time,String gender,int accountId) throws ClientProtocolException, IOException, BusinessExpection {
		String url = "https://api2047.foreseers.com/Dating/personalAnalysis";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("time", time);
		map.put("gender", gender);
		map.put("accountId",accountId);
		String numerology = "";
		String cat1 = "";
		String star = "";
		String horoscope = "";
		String zodiac = "";
		String ziwei = "";
		String bazi = "";
		
		httptest httptest = new httptest();                     //sendPostDataByJson
		String body = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
		
		JSONObject jsn = JSON.parseObject(body);
		 String errcode = jsn.getString("errCode");
		if(errcode.equals("200") ) {
		//	log.info("调用接口成功");
			numerology = jsn.getString("numerology");  
		    cat1 = jsn.getString("cat1");  //五行
		    star = jsn.getString("star");  
			horoscope = jsn.getString("horoscope");  //星座
			zodiac = jsn.getString("zodiac");   //生肖
			//ziwei
			JSONArray ziweiArry = jsn.getJSONArray("ziwei");  
			StringBuffer str = new StringBuffer();
			String str1 = "";
			 for(int j= 0;j<ziweiArry.size();j++) {
				  String ziwei1 = ziweiArry.get(j).toString();
				  str1 =  str.append(ziwei1+",").toString();
			 } 
			ziwei =  str1.substring(0,str1.length()-1);    //得到ziwei
			 //八字
			JSONArray baziarry = jsn.getJSONArray("bazi");    
			StringBuffer strba = new StringBuffer();
			String  strbazi = "";
			for(int i = 0;i<baziarry.size();i++) {
				strbazi = strba.append(baziarry.get(i)+",").toString();
			}
			bazi = strbazi.substring(0,strbazi.length()-1);
					
		}else {			
			//userService.
			throw new BusinessExpection(EmBussinsError.MINGSHU_ERROR);
		}
		 	
		User user = new User();
		user.setId(accountId);
		user.setSex(gender);
		user.setBazi(bazi);
	//	user.setUsername(username);
		user.setDate(date);
		user.setTime(time);
	//	user.setFacebook(facebookid);
		user.setCat1(cat1);
		//user.setNum(Integer.parseInt(numerology));
		user.setNumerology(Integer.parseInt(numerology));
		user.setXingzuo(horoscope);
		user.setZiwei(ziwei);
	//	user.setZone(zone);
		user.setZodiac(zodiac);
		user.setUserstar(Integer.parseInt(star));
		
//		log.info("user:"+user);
		userService.updateByPrimaryKeySelective(user);
	}
	
}
