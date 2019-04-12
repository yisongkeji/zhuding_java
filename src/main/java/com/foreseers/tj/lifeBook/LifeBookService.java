package com.foreseers.tj.lifeBook;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.foreseers.tj.model.BusinessExpection;

public interface LifeBookService {

	Map lifeBook(Map<String,String> map) throws BusinessExpection, IOException;

	List<Map> lifeBookCate(int lifeuserid) throws ClientProtocolException, IOException;

	List lifeBookDetail(String name,int id) throws ClientProtocolException, IOException, BusinessExpection;

	List<Map> lifeUser(int parseInt);

	List lifeBookDetailname(Map<String, String> map);

	//删除命书用户
	Boolean deletelifeUser(int userid, int lifeuserid);

	Map lifebookUser(int parseInt);


}
