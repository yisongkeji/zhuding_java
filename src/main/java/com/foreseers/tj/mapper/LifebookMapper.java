package com.foreseers.tj.mapper;

import com.foreseers.tj.model.Lifebook;
import com.foreseers.tj.model.LifebookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifebookMapper {
    long countByExample(LifebookExample example);

    int deleteByExample(LifebookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lifebook record);

    int insertSelective(Lifebook record);

    List<Lifebook> selectByExampleWithBLOBs(LifebookExample example);

    List<Lifebook> selectByExample(LifebookExample example);

    Lifebook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lifebook record, @Param("example") LifebookExample example);

    int updateByExampleWithBLOBs(@Param("record") Lifebook record, @Param("example") LifebookExample example);

    int updateByExample(@Param("record") Lifebook record, @Param("example") LifebookExample example);

    int updateByPrimaryKeySelective(Lifebook record);

    int updateByPrimaryKeyWithBLOBs(Lifebook record);

    int updateByPrimaryKey(Lifebook record);
    
    //通过用户ID查询用户的命书用户
    List<Lifebook> lifeUser(int parseInt);
    
  //查询用户自身命书
  	Lifebook lifebookSelf(int userid);
}