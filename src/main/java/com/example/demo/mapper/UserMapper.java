package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User QueryUser(String facebookid);

	List<Integer> QueryUserByCity(User user);

	int updateByFaceIDSelective(User record);

	List<User> selectUserlistbyCountry(User user);

	List<Integer> QueryUserByNUM(Integer paihang, Integer getnum);

	List<Integer> QueryUserByqueNUM(Map map);
}