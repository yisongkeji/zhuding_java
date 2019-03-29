package com.foreseers.tj.mapper;

import com.foreseers.tj.model.UserCanums;
import com.foreseers.tj.model.UserCanumsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserCanumsMapper {
    long countByExample(UserCanumsExample example);

    int deleteByExample(UserCanumsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCanums record);

    int insertSelective(UserCanums record);

    List<UserCanums> selectByExample(UserCanumsExample example);

    UserCanums selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCanums record, @Param("example") UserCanumsExample example);

    int updateByExample(@Param("record") UserCanums record, @Param("example") UserCanumsExample example);

    int updateByPrimaryKeySelective(UserCanums record);

    int updateByPrimaryKey(UserCanums record);
    
    UserCanums selectByUserKey(Integer userid);
    
    List<Integer> selectUserNums(UserCanums userCanums);
    
	void updateUserNums(List list);
	
	//更新购买擦擦子数
	int updateBuyNums(UserCanums userCanums);
}