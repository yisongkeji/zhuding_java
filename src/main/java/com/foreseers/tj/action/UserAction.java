package com.foreseers.tj.action;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.service.UserCanumsService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserImageService;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.service.ZoneService;
import com.foreseers.tj.util.WebUpload;
import com.foreseers.tj.util.getAge;

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
	
	@Autowired
	private UserFriendService userFriendService;
	
	@Autowired
	private UserCanumsService userCanumsService; 
	
	@Autowired
	private WebUpload webUpload;
	
	@Value("${httpurl}")
	private String httpurl;
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
	
	@RequestMapping("/countage")
	@ResponseBody
	public ResultType  countAge(HttpServletRequest request) throws ParseException {
	    String userid = request.getParameter("userid");
		User user = userService.selectByPrimaryKey(Integer.parseInt(userid));
		String date = user.getDate();
		int userage = user.getReservedint();
		getAge getage = new getAge();
		int age = getage.jiuanAge(date);
		if(age != userage) {
			user.setReservedint(age);
			userService.updateByPrimaryKeySelective(user);
		}
		//return "success";
		//新增vip计算方法
		int vip = user.getVip();
		if(vip == 1) {
		String viptime = user.getViptime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date vipdate = format.parse(viptime);   //vip到期时间
		Date datenow = new Date();
		if(vipdate.before(datenow)) {
			//表示vipdate小于datenow，表明已经到期
			User record = new User();
			record.setVip(0);
			record.setViptime("");
			record.setId(Integer.parseInt(userid));
			userService.updateByPrimaryKeySelective(record);
		}
	  }
		//新增计算好友时间方法
		List<Map> list = userFriendService.selectUserFriendList(userid);
		
		return ResultType.creat(list);
	
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
			log.error("时区参数不合法");
			throw new BusinessExpection(EmBussinsError.UNKNOWN_ERROR);
			
		}
		//计算年龄
//		 Date datetime = new Date();
//		 String dateyear[] =  date.split("-");		 
//		 int age = datetime.getYear()+1900-Integer.parseInt(dateyear[0]);	    
		getAge getage = new getAge();
		int age = getage.jiuanAge(date);
		
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
		log.info("user:"+userinfo);
		 userService.insertSelective(userinfo); 
		log.info("保存到数据库成功");
	//	int accountId = userinfo.getId();
		User user1= userService.QueryUser(facebookid);
		int accountId = user1.getId();
		log.info("用户的id:"+accountId);
		log.info("accountId"+accountId);
		String url = "https://api2047.foreseers.com/Dating/personalAnalysis";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("time", time);
		map.put("gender", gender);
		map.put("accountId",accountId);
		map.put("timezone", zone);
		
		httptest httptest = new httptest();
		                     //sendPostDataByJson
		log.info("调用命书接口");
		String body = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
		log.info(body);
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
			log.error("调用接口失败");
			log.error("errcode:"+errcode);
			userService.deleteByPrimaryKey(accountId);  //将用户记录删除
			throw new BusinessExpection(EmBussinsError.MINGSHU_ERROR);
		}
		/*
		 *环信注册 
		 */
		HttpHuanxin httpHuanxin = new HttpHuanxin();
		log.info("用户注册环信");
	       String hstr=  "http://a1.easemob.com/1106190114019314/foreseers/users";
	       Map<String,Object> maph = new HashMap<String, Object>();
	        maph.put("username", userinfo.getId());
	        maph.put("password", "123");
	        maph.put("nickname", username);
	        CloseableHttpResponse reponse =  httpHuanxin.sendPostDataByJson(hstr, JSON.toJSONString(maph), "utf-8",null);
	        int status = reponse.getStatusLine().getStatusCode();
	        if(status != 200) {
	        	log.error("环信接口注册失败");
	        	log.error("状态码："+status);
	        	userService.deleteByPrimaryKey(accountId);  //将用户记录删除
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
		
		log.info("返回值:"+user);
		userService.updateByPrimaryKeySelective(user);
		//插入用户擦子数表
		UserCanums UserCanums = new UserCanums();
		UserCanums.setUserid(accountId);
		UserCanums.setNums(0);
		UserCanums.setEveryday(0);
		UserCanums.setVipeveryday(0);
		userCanumsService.insertSelective(UserCanums);
		//插入用户擦子数表
		
		return ResultType.creat(user);
	}
	
	/*
	 * 头像上传
	 */
	@RequestMapping("/uploadhead")
	@ResponseBody
	public ResultType uploadtou(HttpServletRequest request,MultipartFile file) throws BusinessExpection, IllegalStateException, IOException {
		log.info("用户头像上传方法");		
		if(file == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
	    String userid = request.getParameter("userid");
	    log.info("请求信息：userid:"+userid);
	    String headload =  webUpload.getUploadpath();     //配置的头像上传地址	  
	    log.info("配置文件中头像地址："+headload);
	    String imagepath = headload+userid; 
	    log.info("最终头像上传地址："+imagepath);
		if( userid == null || userid == "") {
			log.error("参数不正确");
			log.error("userid:"+userid);
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);			
		}
		User userinfo = userService.selectByPrimaryKey(Integer.parseInt(userid));
		if(userinfo != null) {
		String userhead = userinfo.getHead();
		log.info("userhead："+userhead);
			if(userhead != null && userhead != "" ) {
				log.info("删除头像");
				String[] heads= userhead.split("/");				
				String headold = heads[heads.length-1];
				log.info(headold);
				new File(imagepath+"/"+headold).delete(); 
			}
		}
		String name = file.getOriginalFilename();
		log.info("name"+name);
	//	String imagepath = "/var/zhuding/head";   服务器上的存放图片的地址（记得修改application.yml配置文件）
		File savefile = new File(imagepath);
		if(!savefile.exists()) {
			savefile.mkdirs();
		}
		
		String save = savefile.getAbsolutePath()+"/"+name;
		//String saveurl = "http://192.168.1.73:8080/"+userid+"/"+name;
		String saveurl = httpurl+userid+"/"+name;
		log.info("保存图片的地址："+save);
		log.info("保存到数据库的地址："+saveurl);
		file.transferTo(new File(save));  //将图片保存到本地
		//增加压缩图片
		userService.compressPictures(save);
		//增加压缩图片
		User user = new User();
		user.setId(Integer.parseInt(userid));
		user.setHead(saveurl);
		userService.updateByPrimaryKeySelective(user);
		log.info("返回值："+user);
		return ResultType.creat(user);
	}
	
	/*
	 * 上传模糊头像
	 */
	@RequestMapping("/uploadblurhead")
	@ResponseBody
	public ResultType uploadblurhead(HttpServletRequest request,MultipartFile file) throws BusinessExpection, IllegalStateException, IOException {
		log.info("用户模糊头像上传方法");
		
		if(file == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
	    String userid = request.getParameter("userid");
	    log.info("请求信息：userid:"+userid);
	    String headload =  webUpload.getUploadpath();     //配置的头像上传地址	    
	    log.info("配置文件中头像地址："+headload);
	    String imagepath = headload+userid; 
	    log.info("最终头像上传地址："+imagepath);
		if( userid == null || userid == "") {
			log.error("参数不正确");
			log.error("userid:"+userid);
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);			
		}
		User userinfo = userService.selectByPrimaryKey(Integer.parseInt(userid));
		if(userinfo != null) {
		String userpicture = userinfo.getPicture();
			if( userpicture != null && userpicture != "") {
				String[] pictures= userpicture.split("/");
				String headold = pictures[pictures.length-1];
				log.info(headold);
				new File(imagepath+"/"+headold).delete(); 
				log.info("删除以前的模糊头像");
			}
		}
		String name = file.getOriginalFilename();	
		log.info("图片的名称："+name);
	//	String imagepath = "/var/zhuding/head";   服务器上的存放图片的地址（记得修改application.yml配置文件）
		File savefile = new File(imagepath);
		if(!savefile.exists()) {
			savefile.mkdirs();
		}		
		String save = savefile.getAbsolutePath()+"/"+name;
		//String saveurl = "http://192.168.1.73:8080/"+userid+"/"+name;
		String saveurl = httpurl+userid+"/"+name;
		log.info("保存图片的地址："+save);
		log.info("保存到数据库的地址："+saveurl);
	//	String saveurl = "http://chat.foreseers.com/"+headname;    服务器上的保存图片的路径
		file.transferTo(new File(save));
		User user = new User();
		user.setId(Integer.parseInt(userid));
		user.setPicture(saveurl);
		userService.updateByPrimaryKeySelective(user);
		log.info("返回值："+user);
		return ResultType.creat(user);
	}
	
	/*
	 * 个人信息
	 */
	@RequestMapping("/userpersonal")
	@ResponseBody
	public ResultType userpersonal(HttpServletRequest request) throws BusinessExpection, ParseException {
		log.info("进入个人中心");
		String id =  request.getParameter("userid");
		log.info("请求参数：userid"+id);
		List<String> listimage = new ArrayList<String>();   //图片地址的list
		Map<String,String> map = new HashMap<String,String>();
		ReturnImage returnImage = new ReturnImage();
		int countimage = 0;
 		if(id != null) {
			int userid = Integer.parseInt(id);
			User user =	userService.selectByPrimaryKey(userid);
			String date = user.getDate();
			int userage = user.getReservedint();
			int vip = user.getVip();   //vip标识
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
			long vipday = 0;
			if(vip == 1) {  //是vip
			  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String viptime = user.getViptime();
			  Date userdate = format.parse(viptime);
			  Date datenow = new Date();
			  long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
				long nh = 1000 * 60 * 60;//一小时的毫秒数
			    long nm = 1000 * 60;//一分钟的毫秒数
				long diff = userdate.getTime()-datenow.getTime();
				vipday = diff / nd ;
				long hour = diff % nd / nh;//计算差多少小时
				long min = diff % nd % nh / nm;//计算差多少分钟
				
				if(vipday ==0 ) {
					if(hour == 0) {
						if(min > 0) {
							vipday = 1;
						}else {
							vipday = 0;  //现在该用户会员已到期，更新表中数据
							User userinfo = new User();
							userinfo.setVip(0);
							userinfo.setViptime("");
							userinfo.setId(Integer.parseInt(id));
							userService.updateByPrimaryKeySelective(userinfo);
						}
					}if(hour >0) {
						vipday = 1;
					}
					if(hour <0) {
						vipday = 0;
						User userinfo = new User();
						userinfo.setVip(0);
						userinfo.setViptime("");
						userinfo.setId(Integer.parseInt(id));
						userService.updateByPrimaryKeySelective(userinfo);
					}
				}else {
					if(vipday >0) {
						vipday++;
					}else {
						vipday = 0; //
						User userinfo = new User();
						userinfo.setVip(0);
						userinfo.setViptime("");
						userinfo.setId(Integer.parseInt(id));
						userService.updateByPrimaryKeySelective(userinfo);
					}
				}
				
			}			
			//returnImage.setAge(age);
			returnImage.setVipday((int)vipday);
			returnImage.setCountnum(countimage);
			returnImage.setListimage(listimage);
			
			BeanUtils.copyProperties(user, returnImage);
		}else {
			//参数不合法
			log.error("参数不合法");
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
 		log.info("返回的参数："+returnImage);
		return ResultType.creat(returnImage);
	}
	
	/*
	 * 更新会员基本信息
	 */
	@RequestMapping("/updateuser")
	@ResponseBody
	public ResultType updateuser(HttpServletRequest request) throws BusinessExpection, NumberFormatException, ClientProtocolException, IOException {
		log.info("进入更新会员基本信息方法");
		String userid = request.getParameter("userid"); //
		String name = request.getParameter("name"); //昵称
		String sex = request.getParameter("sex");   //性别
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int age = 0;
		log.info("请求的参数：userid"+userid);
		log.info("请求的参数：name"+name);
		log.info("请求的参数：sex"+sex);
		log.info("请求的参数：date"+date);
		log.info("请求的参数：time"+time);

		User userfirst = userService.selectByPrimaryKey(Integer.parseInt(userid));
//		String suzu[] = userfirst.getDate().split("-");
//		Date datetimefirst = new Date();
//		age = datetimefirst.getYear()+1900-Integer.parseInt(suzu[0]);
		int timezone = userfirst.getZone();
		User user = new User();
		if(userid == null) {
			log.error("参数不正确");
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}else {
			//user.setFacebook(facebook);
			user.setId(Integer.parseInt(userid));
		}
		if(name != null) {
			log.info("修改名称");
			user.setUsername(name);
			userService.updateByPrimaryKeySelective(user);
		}

		if(sex != null) {
		//	user.setSex(sex);
			log.info("修改性别，调用命书接口");
			String datesex = userfirst.getDate();
			String timesex = userfirst.getTime();
			//String gender = userfirst.getSex();
			dating(datesex,timesex,sex,Integer.parseInt(userid),timezone);		
			log.info("调用接口成功");
		}
		
		if(date != null && time != null) {  //日期
			log.info("修改出生日期，调用命书接口");
			String gender = userfirst.getSex();
			getAge getage = new getAge();			
			 age = getage.jiuanAge(date);	 //计算得到年龄
			 user.setReservedint(age);
			 userService.updateByPrimaryKeySelective(user);
			dating(date,time,gender,Integer.parseInt(userid),timezone);
			log.info("调用接口成功");
   
		}
		ReturnUser returnUser = new ReturnUser();
		//returnUser.setAge(age);
		User userinfo =  userService.selectByPrimaryKey(Integer.parseInt(userid));
		 BeanUtils.copyProperties(userinfo, returnUser);
		log.info("接口返回值："+returnUser);
		return ResultType.creat(returnUser);
		
	} 
	
	public void  dating(String date,String time,String gender,int accountId,int timezone) throws ClientProtocolException, IOException, BusinessExpection {
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
		
		userService.updateByPrimaryKeySelective(user);
		//return user;
	}
	
	/*
	 * 计算vip到期时间
	 
	@RequestMapping("/setvip")
	@ResponseBody
	public String setvip(HttpServletRequest request) {
		//String userid = request.getParameter("userid");
	//	String vipdate = request.getParameter("vipdate");
		int num = 3;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 String datenow = format.format(date);
		 System.out.println("现在的天数是"+datenow);
		 Calendar ca = Calendar.getInstance();
		 ca.add(Calendar.DATE, num);
		 date = ca.getTime();
		 String enddate = format.format(date);
		 System.out.println("增加天数以后的日期：" + enddate);
		 
		 return enddate;
	}
	*/
	
	/*
	 * 设置个性签名
	 */
	@RequestMapping("/setObligate")
	@ResponseBody
	public ResultType setObligate(HttpServletRequest request) throws BusinessExpection {
		log.info("进入设置个性签名接口");
		String userid =  request.getParameter("userid");  //用户id
		String obligate = request.getParameter("obligate"); // 签名
		log.info("请求参数："+userid);
		log.info("请求参数："+obligate);
		if(userid == null || obligate == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	 
		}
		User  user = new User();
		user.setId(Integer.parseInt(userid));
		user.setObligate(obligate);
		userService.updateByPrimaryKeySelective(user);
		return ResultType.creat("success");
	}
	
	/*
	 * 个人信息查询接口
	 */
	@RequestMapping("/show")
	@ResponseBody
	public ResultType show(HttpServletRequest request) throws BusinessExpection {
		log.info("进入个人信息查询界面");
		String userid =  request.getParameter("userid");
		log.info("请求的参数：userid："+userid);
		if(userid == null) {
			log.error("参数不合法");
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		Map<String,Object> map =userService.showMyself(Integer.parseInt(userid));
		
		return ResultType.creat(map);
	}
	
	@RequestMapping("/queryName")
	@ResponseBody
	public ResultType queryName(HttpServletRequest request) throws BusinessExpection {
		log.info("进入查询用户名称方法");
		String userid = request.getParameter("userid");  //其他人id
		String uid = request.getParameter("uid");   //自身ID
		log.info("请求参数："+userid);
		if(userid == null) {
			log.error("参数不合法");
			throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);
		}
		User user = userService.selectByPrimaryKey(Integer.parseInt(userid));
		Map<String,Object> map = new HashMap<>();
		map.put("userid", user.getId());
		map.put("username", user.getUsername());
		//map.put("head", user.getPicture());
		map.put("vip", user.getVip());
		int lookhead = userService.showUserHead(Integer.parseInt(uid), Integer.parseInt(userid));  
		if(lookhead == 0) {
			map.put("head", user.getPicture());
		}else {
			map.put("head", user.getHead());
		}
		
		return ResultType.creat(map);
	}
	
	/*
	 * 批量查询用户信息
	 
	
	@PostMapping("/queryUserList1")
	@ResponseBody
	public ResultType queryUserList1(@RequestBody String data) {
		log.info("进入queryUserList");
		log.info(""+data);
		List<Map> returnlist = new ArrayList<>();
		JSONObject json=JSONObject.parseObject(data);
		log.info(""+json);
		String userid = json.getString("userid");
		log.info("userid"+userid);
		JSONArray userlist = json.getJSONArray("userlist");
		for(int i= 0;i<userlist.size();i++) {
			Map<String,Object> map = new HashMap<>();
			User user = userService.selectByPrimaryKey((Integer)userlist.get(i));
			map.put("userid", user.getId());
			map.put("username", user.getUsername());
		//	map.put("head", user.getHead());
			map.put("vip", user.getVip());
			
			int lookhead = userService.showUserHead(Integer.parseInt(userid), (Integer)userlist.get(i));
			if(lookhead == 0) {
				map.put("head", user.getPicture());
			}else {
				map.put("head", user.getHead());
			}
			returnlist.add(map);
		}		
		
		return ResultType.creat(returnlist);
	}
	*/
	
	
	@PostMapping("/queryUserList")
	@ResponseBody
	public ResultType queryUserList(HttpServletRequest request) {
		List<Map> returnlist = new ArrayList<>();
		String userid = request.getParameter("userid");
		String userlist = request.getParameter("userlist");
		log.info(""+userid);
		log.info(""+userlist);
		String[] ids = userlist.split(",");
		for(int i= 0;i<ids.length; i++) {
			Map<String,Object> map = new HashMap<>();
			User user = userService.selectByPrimaryKey(Integer.parseInt(ids[i]));
			map.put("userid", user.getId());
			map.put("username", user.getUsername());
		//	map.put("head", user.getHead());
			map.put("vip", user.getVip());
			
			int lookhead = userService.showUserHead(Integer.parseInt(userid), Integer.parseInt(ids[i]));
			if(lookhead == 0) {
				map.put("head", user.getPicture());
			}else {
				map.put("head", user.getHead());
			}
			returnlist.add(map);
		}
		
		log.info("返回的参数："+returnlist);
		return ResultType.creat(returnlist);
	}
	
	

	
}
