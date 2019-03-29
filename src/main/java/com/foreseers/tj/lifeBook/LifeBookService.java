package com.foreseers.tj.lifeBook;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.foreseers.tj.model.BusinessExpection;

public interface LifeBookService {

	Map lifeBook(Map<String,String> map) throws BusinessExpection, ClientProtocolException, IOException;

	List<Map> lifeBookCate(int lifeuserid) throws ClientProtocolException, IOException;

	void lifeBookDetail(String name,int id) throws ClientProtocolException, IOException, BusinessExpection;

	List<Map> lifeUser(int parseInt);

}
