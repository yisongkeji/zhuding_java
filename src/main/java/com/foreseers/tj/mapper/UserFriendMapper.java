package com.foreseers.tj.mapper;

import com.foreseers.tj.model.UserFriend;
import com.foreseers.tj.model.UserFriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFriendMapper {
    long countByExample(UserFriendExample example);

    int deleteByExample(UserFriendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFriend record);

    int insertSelective(UserFriend record);

    List<UserFriend> selectByExample(UserFriendExample example);

    UserFriend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFriend record, @Param("example") UserFriendExample example);

    int updateByExample(@Param("record") UserFriend record, @Param("example") UserFriendExample example);

    int updateByPrimaryKeySelective(UserFriend record);

    int updateByPrimaryKey(UserFriend record);

	int selectcountnum(String userid);

	List<String> selectlist(String userid);

	UserFriend selectUserFriend(String user_id, String friend_id);
	
	List<UserFriend> selectUserFriendList(String userid);
	
	List<String> selectBlacklist(String userid);
}