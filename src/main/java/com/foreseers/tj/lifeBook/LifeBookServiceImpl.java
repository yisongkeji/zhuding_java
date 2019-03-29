package com.foreseers.tj.lifeBook;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.http.httptest;
import com.foreseers.tj.mapper.LifebookDetailMapper;
import com.foreseers.tj.mapper.LifebookMapper;
import com.foreseers.tj.mapper.UserTransactionMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.Lifebook;
import com.foreseers.tj.model.LifebookDetail;
import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.UserTransaction;
import com.foreseers.tj.service.ZoneService;

import javafx.print.JobSettings;

@Service
public class LifeBookServiceImpl implements LifeBookService {

	private static final Logger log = LoggerFactory.getLogger(LifeBookServiceImpl.class);
	
	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private LifebookMapper lifebookMapper;
	
	@Autowired
	private UserTransactionMapper userTransactionMapper;
	
	@Autowired
	private LifebookDetailMapper lifebookDetailMapper;
	/*
	 * 创建用户方法
	 * @see com.foreseers.tj.lifeBook.LifeBookService#lifeBook(java.util.Map)
	 */
	@Override
	@Transactional
	public Map lifeBook(Map<String,String> map) throws BusinessExpection, ClientProtocolException, IOException {
		// TODO Auto-generated method stub
	    Map<String,Object> returnmap = new HashMap<>();
		log.info("map:"+map);
		String zoneString = map.get("timezone");
		Timezone timezone = zoneService.selectByName(zoneString);
		log.info("timezone:"+timezone);
		Double zone ;
		if(timezone != null) {
			zone = timezone.getTimezone();
		}else {
			throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"时区不合法");
		}
		String hash = "eeb6b6e6aa04090f9e898bb02f195831";
		String url = "https://api2047.foreseers.com/Dating/lifeBook"; //创建命书接口
		Map<String,Object>  mapinfo = new HashMap<>();
		mapinfo.put("date", map.get("date"));
		mapinfo.put("time", map.get("time"));
		mapinfo.put("isLeap", null);
		mapinfo.put("gender", map.get("gender"));
		mapinfo.put("timezone", zone);
		mapinfo.put("hash", hash);
		String result = httptest.sendPostDataByJson(url,JSON.toJSONString(mapinfo), "utf-8");
		JSONObject body = JSON.parseObject(result);
		if(body.getString("errCode").equals("200")) {
			log.info("调用结果成功");
			JSONObject lunar = body.getJSONObject("lunar");
			String lunaryear = lunar.getString("year");
			String lunarmonth = lunar.getString("month");
			String lunarday = lunar.getString("day");
			//性别
			String gender = body.getString("gender");
			//numerology
			JSONObject numerology = body.getJSONObject("numerology");
			String numerologyvalue = numerology.getString("value");
			String match = numerology.getString("match");
			match = match.replace("[", "");
			match = match.replace("]", "");
			//fiveElements 五行
			JSONObject five = body.getJSONObject("fiveElements");
			String fiveElements = five.getString("value");
			//horoscope 星座
			JSONObject horoscope = body.getJSONObject("horoscope");
			String  horoscopevalue = horoscope.getString("value");
			JSONObject desc = horoscope.getJSONObject("desc");
			String descid = desc.getString("id");
			String descname = desc.getString("name");
			String guardPlanets = desc.getString("guardPlanets");
			String guardPlanetsDesc = desc.getString("guardPlanetsDesc");
			String guardGod = desc.getString("guardGod");
			String myth = desc.getString("myth");
			String guardAngel = desc.getString("guardAngel");
			String guardCrystal = desc.getString("guardCrystal");
			String horoscopematch = horoscope.getString("match");
			horoscopematch = horoscopematch.replace("[", "");
			horoscopematch = horoscopematch.replace("]", "");
			//zodiac 生肖
			JSONObject zodiac = body.getJSONObject("zodiac");
			String zodiacvalue = zodiac.getString("value");
			JSONObject zodiacdesc = zodiac.getJSONObject("desc");
			String zodiacdescid = zodiacdesc.getString("id");
			String zodiacdescname = zodiacdesc.getString("name");
			String zodiacdescguardBuddha = zodiacdesc.getString("guardBuddha");
			String zodiacdescdesc = zodiacdesc.getString("desc");
			String zodiacmatch = zodiac.getString("match");
			zodiacmatch = zodiacmatch.replace("[", "");
			zodiacmatch = zodiacmatch.replace("]", "");
			//bazi  八字
			JSONObject bazi = body.getJSONObject("bazi");
			String bazivalue = bazi.getString("value");
			bazivalue = bazivalue.replace("[", "");
			bazivalue = bazivalue.replace("]", "");
			String bazimatch = bazi.getString("match");
			bazimatch = bazimatch.replace("[", "");
			bazimatch = bazimatch.replace("]", "");
			//star
			JSONObject star = body.getJSONObject("star");
			String starvalue = star.getString("value");
			String starmatch = star.getString("match");
			starmatch = starmatch.replace("[", "");
			starmatch = starmatch.replace("]", "");
			//ziwei 
			JSONObject ziwei = body.getJSONObject("ziwei");
			String ziweivalue = ziwei.getString("value");
			String ziweimatch = ziwei.getString("match");
			ziweimatch = ziweimatch.replace("[", "");
			ziweimatch = ziweimatch.replace("]", "");
			//将数据保存到数据库
			Lifebook lifebook = new Lifebook();
			lifebook.setUserid(Integer.parseInt(map.get("userid")));
			lifebook.setName(map.get("name"));
			lifebook.setGender(map.get("gender"));
			lifebook.setDate(map.get("date"));
			lifebook.setTime(map.get("time"));
			lifebook.setIsleap(map.get("isleap"));
			lifebook.setLunaryear(lunaryear);
			lifebook.setLunarmonth(lunarmonth);
			lifebook.setLunarday(lunarday);
			lifebook.setNumerology(numerologyvalue);
			lifebook.setNumerologymatch(match);
			lifebook.setFiveelements(fiveElements);
			lifebook.setHoroscope(horoscopevalue);
			lifebook.setHoroscopeid(descid);
			lifebook.setHoroscopename(descname);
			lifebook.setHoroscopeguardplanets(guardPlanets);
			lifebook.setHoroscopeguardplanetsdesc(guardPlanetsDesc);
			lifebook.setHoroscopeguardgod(guardGod);
			lifebook.setHoroscopemyth(myth);
			lifebook.setHoroscopeguardangel(guardAngel);
			lifebook.setHoroscopeguardcrystal(guardCrystal);
			lifebook.setHoroscopematch(horoscopematch);
			lifebook.setZodiac(zodiacvalue);
			lifebook.setZodiacid(zodiacdescid);
			lifebook.setZodiacname(zodiacdescname);
			lifebook.setZodiacguardbuddha(zodiacdescguardBuddha);
			lifebook.setZodiacdesc(zodiacdescdesc);
			lifebook.setZodiacmatch(zodiacmatch);
			lifebook.setBazi(bazivalue);
			lifebook.setBazimatch(bazimatch);
			lifebook.setStar(starvalue);
			lifebook.setStarmatch(starmatch);
			lifebook.setZiwei(ziweivalue);
			lifebook.setZiweimatch(ziweimatch);
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String time = sdf.format(new Date());
			 lifebook.setCreated(time);
			 lifebookMapper.insertSelective(lifebook);
			 int lifeuserid = lifebook.getId();
			 log.info("将数据保存到数据库成功");
			 returnmap.put("lifeuserid", lifeuserid);
			 returnmap.put("horoscope", horoscopevalue);
			 returnmap.put("horoscopematch", horoscopematch);
			 returnmap.put("zodiac", zodiacvalue);
			 returnmap.put("zodiacmatch", zodiacmatch);
			 returnmap.put("numerology", numerologyvalue);
			 returnmap.put("numerologymatch", match);
			 returnmap.put("star", starvalue);
			 returnmap.put("starmatch", starmatch);
			 returnmap.put("ziwei", ziweivalue);
			 returnmap.put("ziweimatch", ziweimatch);
			 returnmap.put("bazi", bazivalue);
			 returnmap.put("bazimatch", bazimatch);
			 
			 
		}else {
			log.error("调通接口失败");
			throw new BusinessExpection(EmBussinsError.MINGSHU_ERROR);
		}
		
		log.info("返回的参数："+returnmap);
		return returnmap;
		
	}

	/*
	 * 命书目录
	 * @see com.foreseers.tj.lifeBook.LifeBookService#lifeBookCate()
	 */
	@Override
	@Transactional
	public List<Map> lifeBookCate(int lifeuserid) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<>();
		List<Map>  relist = new ArrayList<>();
		String url = "https://api2047.foreseers.com/Dating/lifeBookCate";
		map.put("hash", "eeb6b6e6aa04090f9e898bb02f195831");
		String result =  httptest.sendPostDataByJson(url,JSON.toJSONString(map), "utf-8");
		JSONObject body = JSON.parseObject(result);
		if(body.getString("errCode").equals("200")) {
			log.info("调用接口成功");
			JSONObject list = body.getJSONObject("list");
			JSONObject quanbu = list.getJSONObject("全部");
			JSONArray subcate = quanbu.getJSONArray("subcate");
			
			 for(int i = 0;i<subcate.size();i++) {
				 Map<String,Object>  remap = new HashMap<>();
				 
				 String name = (String)subcate.get(i);
				 remap.put("name", name);
				 JSONObject ob = list.getJSONObject(name);
				 JSONArray obarry = ob.getJSONArray("subcate");
				 remap.put("size", obarry.size());  //共有多少项
				 JSONObject info = list.getJSONObject(name);
				 String storeId = info.getString("storeId");
				 remap.put("storeId", storeId);
				 if(storeId.equals("free")) {
					 remap.put("sign", 1);
				 }else {
				 //查询此用户是否购买过此商品
				 UserTransaction UserTransaction = new UserTransaction();
				 UserTransaction.setUserId(lifeuserid);
				 UserTransaction.setItem("com.foreseers.chat."+storeId);
				 
				 UserTransaction userTransaction = userTransactionMapper.selectByUserTransaction(UserTransaction);
				 if(userTransaction == null) {
					 log.info("没有购买过");
					 remap.put("sign", 0);
				 }else {
					 log.info("购买过");
					 remap.put("sign", 1);
				  }	
				 }  
				 relist.add(remap);
				
			 }
			
		}
		
		
		return relist;
	}

	/*
	 * 算命
	 */
	@Override
	@Transactional
	public void lifeBookDetail(String name,int id) throws ClientProtocolException, IOException, BusinessExpection {
		// TODO Auto-generated method stub
		log.info("name:"+name);
		String url = "https://api2047.foreseers.com/Dating/lifeBookDetail";
//		Lifebook lifebook =  lifebookMapper.selectByPrimaryKey(id);
//		String date = lifebook.getDate();
//		String time = lifebook.getTime();
//		String gender = lifebook.getGender();
		Map<String,Object> map = new HashMap<>();
		map.put("date", "1988-12-31");
		map.put("time", "22:00:00");
		map.put("gender","M");
		map.put("isLeap", null);
		map.put("cate", name);
		map.put("hash", "eeb6b6e6aa04090f9e898bb02f195831");
		
		String result =	httptest.sendPostDataByJson(url, JSON.toJSONString(map), "utf-8");
		JSONObject body = JSON.parseObject(result);
		if(body.getString("errCode").equals("200")) {
			log.info("调用接口成功");
			JSONArray subCate = body.getJSONArray("subCate");
			for(int i = 0;i<subCate.size();i++) {
				JSONObject ject = (JSONObject)subCate.get(i);
				String title = ject.getString("title");
				String comment = ject.getString("comment");
				comment = comment.replace("[", "");
				comment = comment.replace("]", "");
				comment = comment.replace("\"", "");
				String icon = ject.getString("icon");
				log.info("title:"+title);
				log.info("comment:"+comment);
				log.info("icon:"+icon);
				//保存到数据库
				LifebookDetail lifebookDetail = new LifebookDetail();
				lifebookDetail.setTitle(title);
				lifebookDetail.setComment(comment);
				lifebookDetail.setIcon(icon);
				lifebookDetail.setName(name);
				lifebookDetail.setLifeuserid(id);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String datetime = format.format(date);
				lifebookDetail.setCreated(datetime);
				log.info("保存到数据库的参数：lifebookDetail"+lifebookDetail);
				lifebookDetailMapper.insertSelective(lifebookDetail);
				log.info("保存到数据库成功");
			}
					
		}else {
			log.error("调用接口失败");
			throw new BusinessExpection(EmBussinsError.GENERAL_ERROR,"命书接口调用失败");
		}
		
	}

	@Override
	@Transactional
	public List<Map> lifeUser(int parseInt) {
		// TODO Auto-generated method stub
		List<Lifebook> list = lifebookMapper.lifeUser(parseInt);
		List<Map> returnlist = new ArrayList<>();
		for(Lifebook lifebook:list) {
			Map<String,Object> map = new HashMap<>();
			map.put("lifeuserid", lifebook.getId());
			map.put("name", lifebook.getName());
			map.put("date", lifebook.getDate());
			map.put("time", lifebook.getTime());
			returnlist.add(map);
		}
		
		return returnlist;
	}
	
	
}
