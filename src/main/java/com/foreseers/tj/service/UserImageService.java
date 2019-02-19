package com.foreseers.tj.service;

import java.util.List;

import com.foreseers.tj.model.UserImage;

public interface UserImageService {

	 int insertSelective(UserImage record);
	 
	 List<UserImage> queryByUseridlist(int userid);

	void deleteimage(UserImage userImage);
	
	  int updateByPrimaryKeySelective(UserImage record);

	
}
