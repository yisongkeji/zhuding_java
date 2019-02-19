package com.foreseers.tj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.mapper.UserImageMapper;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.service.UserImageService;

@Service
@Transactional
public class UserImageServiceImpl implements UserImageService {

	@Autowired
	private UserImageMapper userImageMapper;
	
	@Override
	public int insertSelective(UserImage record) {
		// TODO Auto-generated method stub
		return userImageMapper.insertSelective(record);
	}

	@Override
	public List<UserImage> queryByUseridlist(int userid) {
		// TODO Auto-generated method stub
		return userImageMapper.queryByUseridlist(userid);
	}

	@Override
	public void deleteimage(UserImage userImage) {
		// TODO Auto-generated method stub
		userImageMapper.deleteimage(userImage);
		
		
	}

	@Override
	public int updateByPrimaryKeySelective(UserImage record) {
		// TODO Auto-generated method stub
		return userImageMapper.updateByPrimaryKeySelective(record);
	}



}
