package com.foreseers.tj.service.impl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.httptest;
import com.foreseers.tj.huanxin.HttpHuanxin;
import com.foreseers.tj.lifeBook.LifeBookService;
import com.foreseers.tj.mapper.UserCanumsMapper;
import com.foreseers.tj.mapper.UserMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.model.UserExample;
import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.service.UserCaHistoryService;
import com.foreseers.tj.service.UserFriendService;
import com.foreseers.tj.service.UserImageService;
import com.foreseers.tj.service.UserService;
import com.foreseers.tj.util.ImageUtil;
import com.foreseers.tj.util.MyGaussianFilter;
import com.foreseers.tj.util.getAge;
//import com.jhlabs.image.GaussianFilter;
import com.jhlabs.image.GaussianFilter;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.resizers.configurations.ScalingMode;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserImageService userImageService;
	@Autowired
	private UserFriendService userFriendService;
	@Autowired
	private UserCaHistoryService userCaHistoryService;
	@Autowired
	private UserCanumsMapper userCanumsMapper;
	@Autowired
	private LifeBookService lifeBookService;
	
	@Value("${huanxinkey}")
	private String huanxinkey;
	
	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		//return 0;
		return userMapper.insertSelective(record);
	}

	@Override
	public User QueryUser(String facebookid) {
		// TODO Auto-generated method stub
		return userMapper.QueryUser(facebookid);
	}

	@Override
	public List<Integer> QueryUserByCity(Map Map) {
		// TODO Auto-generated method stub
		return userMapper.QueryUserByCity(Map);
	}

	@Override
	public int updateByFaceIDSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByFaceIDSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectUserlist(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectUserlistbyCountry(user);
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(example);
	}

	@Override
	public List<Integer> QueryUserByNUM(Integer paihang, Integer getnum,Integer userid) {
		// TODO Auto-generated method stub
		return userMapper.QueryUserByNUM(paihang, getnum,userid);
	}

	@Override
	public List<Integer> QueryUserByqueNUM(Map map) {
		// TODO Auto-generated method stub
		return userMapper.QueryUserByqueNUM(map);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void minuserfriendnum(int parseInt) {
		// TODO Auto-generated method stub
		userMapper.minuserfriendnum(parseInt);
	}

	@Override
	public void addserfriendnum(int parseInt) {
		// TODO Auto-generated method stub
		userMapper.addserfriendnum(parseInt);
	}

	/*
	 * 展示自己的个人信息
	 * @see com.foreseers.tj.service.UserService#showMyself(int)
	 */
	@Override
	public Map<String,Object> showMyself(int userid) throws BusinessExpection {
		// TODO Auto-generated method stub
		User user =  userMapper.selectByPrimaryKey(userid);
		if(user == null) {
			log.error("用户不存在");
			throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT);
		}
		log.info("查询出来的user:"+user);
		List<UserImage> list = userImageService.queryByUseridlist(userid);
		List<String> imagelist = new ArrayList<>();
		if(list.size() > 0) {
			for(UserImage userImage:list) {
				imagelist.add(userImage.getImage());
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", user.getUsername());
		map.put("sex", user.getSex());
		map.put("age", user.getReservedint());
		map.put("num", user.getNum());
		map.put("head", user.getHead());
		map.put("vip", user.getVip());
		map.put("ziwei", user.getZiwei());
		map.put("sign", user.getObligate());
		map.put("images", imagelist);
		log.info("得到的Map:"+map);
		
		return map;
	}

	/*
	 * 压缩图片(non-Javadoc)
	 * @see com.foreseers.tj.service.UserService#compressPictures()
	 */
	@Override
	@Transactional
	public String compressPictures(String imagepath,String save) throws BusinessExpection {
		// TODO Auto-generated method stub
		log.info("压缩图片方法");
		log.info("图片路径："+save);
		log.info("imagepath:"+imagepath);
		
        try {     	
        	//压缩图片
            Thumbnails.of(save).
                    scalingMode(
                    ScalingMode.BICUBIC).
                    // 图片缩放80%, 不能和size()一起使用
                    scale(0.8).
                    // 图片质量压缩80%
                    outputQuality(0.8).
                    toFile(save);
            log.info("压缩成功");
            
            GaussianFilter gaussianFilter = new GaussianFilter();
            BufferedImage img = ImageIO.read(new File(save));
            BufferedImage toImage = new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_INT_RGB);
            gaussianFilter.setRadius(80);
            gaussianFilter.filter(img, toImage);
        	DateFormat bf = new SimpleDateFormat("yyyyMMddHHmmss");//多态
			Date date = new Date();
			String result =  getRandom();
			String name = bf.format(date)+result+"."+"jpg";
			log.info("imagepath:"+imagepath+"/"+name);
            ImageIO.write(toImage, "jpeg", new File(imagepath+"/"+name));
           
            return name;

        } catch (IOException e) {
        	log.error(e.getMessage());
        	throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"压缩图片失败");
        }
        
	}

	
	public String getRandom() {
		Random random = new Random();
		String result="";
		for (int i=0;i<6;i++)
		{
			result+=random.nextInt(10);
		}
		return result;
	}
	
	    
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	/*
	 * //更新vip时间
	 * @see com.foreseers.tj.service.UserService#userSetvip(int, int)
	 */
	@Override
	public String userSetvip(int userid, int vipdate) throws ParseException {
		try {
			log.info("更新用户会员时间");	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			User user = selectByPrimaryKey(userid);
			String numstr = user.getReservedvar();
			int num = Integer.parseInt(numstr) +20;
			 Date date ;
			if(user.getVip() == 1 ) {			
				log.info("之前是会员");			
				String 	dateString = user.getViptime();
				 date = format.parse(dateString);
				log.info("现在vip到期时间："+date);
				
			}else {
				 date = new Date();
			
			}
			
			Calendar ca = Calendar.getInstance();
			ca.setTime(date);
			ca.add(Calendar.DATE, vipdate);
			date = ca.getTime();
			String userviptime = format.format(date);			 
			 
			log.info("vip到期日期:"+userviptime);
			User userinfo = new User();
			userinfo.setId(userid);
			userinfo.setVip(1);
			userinfo.setViptime(userviptime);
			userinfo.setReservedvar(num+"");
			log.info("更新用户会信息：user:"+userinfo);
			userMapper.updateByPrimaryKeySelective(userinfo);
			log.info("更新数据库成功");
			return "success";
			
		}catch(Exception e) {	
			log.error(e.getMessage());
			return "fail";
		}
	}

	@Override
	public int showUserHead(int userid, int userinfoid) {
		// TODO Auto-generated method stub
		int lookhead = 0;
		UserFriend userFriend = userFriendService.selectUserFriend(userid+"", userinfoid+"");
    	if(userFriend != null) { //存在好友关系
    		if(userFriend.getUserReation() == 0) { //是好友关系
    			if(userFriend.getLookhead() == 1) {  //可以查看清晰头像
    				log.info("两人是好友关系，切可以返回清晰头像");
    				lookhead = 1;
    			}
    		}	
    	}
    	if(lookhead == 0) { //判断是否使用过擦子
    		log.info("两人不是好友关系，或者成为好友时间不够，判断是否使用过擦子");
			UserCaHistory userCaHistory = new UserCaHistory();
			userCaHistory.setUserid(userid); // 主id
			userCaHistory.setCaid(userinfoid);
			UserCaHistory userCaHistoryinfo = userCaHistoryService.selectByUserCaHistory(userCaHistory); 
			if(userCaHistoryinfo != null) {
				log.info("使用过擦子，返回清晰头像");
				lookhead = 1;
			}
			log.info("没有使用过擦子，不能查看清晰头像");
    	}
		
		return lookhead;
	}

	/*
	 * 用户注册
	 * @see com.foreseers.tj.service.UserService#insertUser(java.util.Map)
	 */
	@Override
	@Transactional
	public User insertUser(Map<String,Object> parmap) throws ClientProtocolException, IOException, BusinessExpection {
		
		String username = (String)parmap.get("username");
		String date = (String)parmap.get("date");
		String time = (String)parmap.get("time");
		String gender = (String)parmap.get("gender");
		String facebookid = (String)parmap.get("facebookid");
		int  zone = (int)parmap.get("zone");
		String country = (String)parmap.get("country");
		String city = (String)parmap.get("city");
		String area = (String)parmap.get("area");
		String spare = (String)parmap.get("spare");
		String spare1 = (String)parmap.get("spare1");
		String lat = (String)parmap.get("lat");   //经度
		String lng = (String)parmap.get("lng");   //纬度	
		String zoneString = (String)parmap.get("zoneString");
		
		String ziwei = "";        //ziwei
		String numerology = "";  //num
		String horoscope = "";  //星座
		String zodiac = "";    //生肖		
		String bazi = "";     //八字
		String cat1 = "";
		String star = "";
		
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
		 insertSelective(userinfo); 
		log.info("保存到数据库成功");
	//	int accountId = userinfo.getId();
		User user1= QueryUser(facebookid);
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
			deleteByPrimaryKey(accountId);  //将用户记录删除
			throw new BusinessExpection(EmBussinsError.MINGSHU_ERROR);
		}
		
		// *环信注册 
		 
		HttpHuanxin httpHuanxin = new HttpHuanxin();
		log.info("用户注册环信");
	       String hstr= huanxinkey+"users";
	       Map<String,Object> maph = new HashMap<String, Object>();
	        maph.put("username", userinfo.getId());
	        maph.put("password", "123");
	        maph.put("nickname", username);
	        CloseableHttpResponse reponse =  httpHuanxin.sendPostDataByJson(hstr, JSON.toJSONString(maph), "utf-8",null);
	        int status = reponse.getStatusLine().getStatusCode();
	        if(status != 200) {
	        	log.error("环信接口注册失败");
	        	log.error("状态码："+status);
	        	deleteByPrimaryKey(accountId);  //将用户记录删除
	        	throw new BusinessExpection(EmBussinsError.HUANXIN_ERROR);
	        }
	        
			
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
		updateByPrimaryKeySelective(user);
		//插入用户擦子数表
		UserCanums UserCanums = new UserCanums();
		UserCanums.setUserid(accountId);
		UserCanums.setNums(0);
		UserCanums.setEveryday(0);
		UserCanums.setVipeveryday(0);
		userCanumsMapper.insertSelective(UserCanums);
		//用户注册命书
		Map<String,String> lifemap = new HashMap<>();
		lifemap.put("name", username);
		lifemap.put("date", date);
		lifemap.put("time", time);
		lifemap.put("gender", gender);
		lifemap.put("timezone", zoneString);
		lifemap.put("userid", accountId+"");
		lifemap.put("self", "self");
		
		lifeBookService.lifeBook(lifemap);
		
		return user;
	}


}
