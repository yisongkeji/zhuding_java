package com.foreseers.tj.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreseers.tj.model.UsermatchWithBLOBs;

public class httpmatching {
	

	
     public static UsermatchWithBLOBs httpurl(int accountId,List<Integer> idlist) throws ClientProtocolException, IOException {
    		int user_id ;
    		int score ;
    		String desc = "";
    		String commentdesc = "";
    		String commentgood = "";
    		String commentbad = "";
    		String characteristicdesc = "";
    		String characteristicgood = "";
    		String characteristicbad = "";
    		int mindscore ;
    		String minddesc = "";
    		int bodyscore ;
    		String bodydesc = "";
    		int characterscore ;
    		String characterdesc = "";
    		int distance = 1; //距离
    	 UsermatchWithBLOBs usermatchWithBLOBs = new UsermatchWithBLOBs();
    	//调用接口
			String url = "https://api2047.foreseers.com/Dating/matching";
			httptest httptest = new httptest();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("accountId", accountId);
			map.put("target", idlist);
			map.put("debug", "false");
			String rebody = httptest.sendPostDataByJson(url,JSON.toJSONString(map),"utf-8");
			
			JSONObject jsn = JSON.parseObject(rebody);
			System.out.println(rebody);
			String errcode = jsn.getString("errCode");
			System.out.println(errcode);
			if(errcode.equals("200")) {
				System.out.println("调用接口成功");
				JSONArray result = jsn.getJSONArray("result");
				for(int i = 0;i<result.size();i++) {					
					//JSONObject resultjson = JSON.parseObject(result.get(i).toString());
					//解析接口
					JSONObject resultjson = JSON.parseObject(result.get(i).toString());
					 user_id = resultjson.getInteger("user_id");
					 score = resultjson.getInteger("score");
					 desc = resultjson.get("desc").toString();
					JSONObject comment = JSON.parseObject(resultjson.get("comment").toString());
					 commentdesc = comment.get("desc").toString();
					 commentgood = comment.get("good").toString();
					 commentbad = comment.get("bad").toString();
					JSONObject characteristic = JSON.parseObject(resultjson.get("characteristic").toString());
					 characteristicdesc = characteristic.get("desc").toString();
					 characteristicgood = characteristic.get("good").toString();
					 characteristicbad = characteristic.get("bad").toString();
					JSONObject mind = JSON.parseObject(resultjson.get("mind").toString());
					 mindscore = mind.getInteger("score");
					 minddesc = mind.get("desc").toString();
					JSONObject body = JSON.parseObject(resultjson.get("body").toString());
					 bodyscore = body.getInteger("score");
					 bodydesc = body.get("desc").toString();
					JSONObject character = JSON.parseObject(resultjson.get("character").toString());
					 characterscore = character.getInteger("score");
					 characterdesc = character.get("desc").toString();
					 //计算两用户之前的距离
//					 LocationUtils local = new LocationUtils();
//					 User touser = userService.selectByPrimaryKey(user_id);
//					 Double tolat = touser.getLat();
//					 Double tolan = touser.getLng();
//					 distance = local.getDistance(Double.parseDouble(lat),Double.parseDouble(lng), tolat, tolan); //用户距离
					 //将信息保存到数据库
					
					 usermatchWithBLOBs.setZhuid(accountId);
					 usermatchWithBLOBs.setCongid(user_id);
					 usermatchWithBLOBs.setUserscore(score);
					 usermatchWithBLOBs.setUserdesc(desc);
					 usermatchWithBLOBs.setCommentdesc(commentdesc);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setMinddesc(minddesc);
					 usermatchWithBLOBs.setMindscore(mindscore);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setBodyscore(bodyscore);
					 usermatchWithBLOBs.setCharacterdesc(characterdesc);
					 usermatchWithBLOBs.setCharacterscore(characterscore);
				}			 
			}
			return usermatchWithBLOBs;
     }
}
