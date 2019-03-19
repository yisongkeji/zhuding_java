package com.foreseers.tj.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foreseers.tj.mapper.UserMapper;
import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ReturnUser;
import com.foreseers.tj.model.User;
import com.foreseers.tj.model.UserExample;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.service.UserImageService;
import com.foreseers.tj.service.UserService;

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
	public List<Integer> QueryUserByNUM(Integer paihang, Integer getnum) {
		// TODO Auto-generated method stub
		return userMapper.QueryUserByNUM(paihang, getnum);
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
	public void compressPictures(String save) {
		// TODO Auto-generated method stub
		log.info("压缩图片方法");
		log.info("图片路径："+save);
        try {
            Thumbnails.of(save).
                    scalingMode(
                    ScalingMode.BICUBIC).
                    // 图片缩放80%, 不能和size()一起使用
                    scale(0.8).
                    // 图片质量压缩80%
                    outputQuality(0.8).
                    toFile(save);
            log.info("压缩成功");
        } catch (IOException e) {
        	log.error(e.getMessage());
        }
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}


}
