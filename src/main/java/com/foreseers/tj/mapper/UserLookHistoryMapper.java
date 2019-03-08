package com.foreseers.tj.mapper;

import com.foreseers.tj.model.UserLookHistory;
import com.foreseers.tj.model.UserLookHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLookHistoryMapper {
    long countByExample(UserLookHistoryExample example);

    int deleteByExample(UserLookHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLookHistory record);

    int insertSelective(UserLookHistory record);

    List<UserLookHistory> selectByExample(UserLookHistoryExample example);

    UserLookHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLookHistory record, @Param("example") UserLookHistoryExample example);

    int updateByExample(@Param("record") UserLookHistory record, @Param("example") UserLookHistoryExample example);

    int updateByPrimaryKeySelective(UserLookHistory record);

    int updateByPrimaryKey(UserLookHistory record);
    
    UserLookHistory selectByUserLookHistory(UserLookHistory userLookHistory);

	List<UserLookHistory> selectByUserid(int lookid);
}