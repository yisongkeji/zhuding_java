package com.foreseers.tj.lifeBook;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.Lifebook;

public interface LifeBookService {

	Map lifeBook(Map<String,String> map) throws BusinessExpection, IOException;

	List<Map> lifeBookCate(int lifeuserid,int userid) throws ClientProtocolException, IOException;

	List lifeBookDetail(String name,int id) throws ClientProtocolException, IOException, BusinessExpection;

	List<Map> lifeUser(int parseInt) throws BusinessExpection, IOException;

	List lifeBookDetailname(Map<String, String> map);

	//删除命书用户
	Boolean deletelifeUser(int userid, int lifeuserid);
	//查询命书用户列表
	Map lifebookUser(int parseInt) throws BusinessExpection, IOException;

	//查询用户自身命书
	Lifebook lifebookSelf(int userid);
}
