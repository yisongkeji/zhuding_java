package com.foreseers.tj.mapper;

import com.foreseers.tj.model.UserDefriend;
import com.foreseers.tj.model.UserDefriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDefriendMapper {
    long countByExample(UserDefriendExample example);

    int deleteByExample(UserDefriendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDefriend record);

    int insertSelective(UserDefriend record);

    List<UserDefriend> selectByExample(UserDefriendExample example);

    UserDefriend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDefriend record, @Param("example") UserDefriendExample example);

    int updateByExample(@Param("record") UserDefriend record, @Param("example") UserDefriendExample example);

    int updateByPrimaryKeySelective(UserDefriend record);

    int updateByPrimaryKey(UserDefriend record);
    
    List<UserDefriend>  getBlackList(int userid);

	void removeUser(UserDefriend userDefriend);

	
}