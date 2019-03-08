package com.foreseers.tj.service;

import java.util.List;
import java.util.Map;

public interface UserLookHistoryService {

	String updateUserLook(int userid, int lookid);

	List<List> showUserLook(int userid);

	List<Map> showBydate(int userid, String date);

	

	

}
