package com.foreseers.tj.mapper;

import com.foreseers.tj.model.UserCaHistory;
import com.foreseers.tj.model.UserCaHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCaHistoryMapper {
    long countByExample(UserCaHistoryExample example);

    int deleteByExample(UserCaHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCaHistory record);

    int insertSelective(UserCaHistory record);

    List<UserCaHistory> selectByExample(UserCaHistoryExample example);

    UserCaHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCaHistory record, @Param("example") UserCaHistoryExample example);

    int updateByExample(@Param("record") UserCaHistory record, @Param("example") UserCaHistoryExample example);

    int updateByPrimaryKeySelective(UserCaHistory record);

    int updateByPrimaryKey(UserCaHistory record);
    
    UserCaHistory selectByUserCaHistory(UserCaHistory userCaHistory);
    
    List<UserCaHistory>  userCaHistoryService(Integer caid);
}