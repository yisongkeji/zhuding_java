package com.foreseers.tj.mapper;

import com.foreseers.tj.model.UserTransaction;
import com.foreseers.tj.model.UserTransactionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTransactionMapper {
    long countByExample(UserTransactionExample example);

    int deleteByExample(UserTransactionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTransaction record);

    int insertSelective(UserTransaction record);

    List<UserTransaction> selectByExample(UserTransactionExample example);

    UserTransaction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTransaction record, @Param("example") UserTransactionExample example);

    int updateByExample(@Param("record") UserTransaction record, @Param("example") UserTransactionExample example);

    int updateByPrimaryKeySelective(UserTransaction record);

    int updateByPrimaryKey(UserTransaction record);
    
    //查询购买记录
    UserTransaction selectByUserTransaction(UserTransaction userTransaction);
}