package com.foreseers.tj.service;

import java.util.List;
import java.util.Map;

public interface UserDefriendService {

	String pullDefriend(int userid, int blackid);

	List<Map> getBlackList(int parseInt);

	String removeUser(int userid, int blackid);

}
