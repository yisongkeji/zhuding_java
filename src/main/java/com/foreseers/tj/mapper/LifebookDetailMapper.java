package com.foreseers.tj.mapper;

import com.foreseers.tj.model.LifebookDetail;
import com.foreseers.tj.model.LifebookDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifebookDetailMapper {
    long countByExample(LifebookDetailExample example);

    int deleteByExample(LifebookDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LifebookDetail record);

    int insertSelective(LifebookDetail record);

    List<LifebookDetail> selectByExampleWithBLOBs(LifebookDetailExample example);

    List<LifebookDetail> selectByExample(LifebookDetailExample example);

    LifebookDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LifebookDetail record, @Param("example") LifebookDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") LifebookDetail record, @Param("example") LifebookDetailExample example);

    int updateByExample(@Param("record") LifebookDetail record, @Param("example") LifebookDetailExample example);

    int updateByPrimaryKeySelective(LifebookDetail record);

    int updateByPrimaryKeyWithBLOBs(LifebookDetail record);

    int updateByPrimaryKey(LifebookDetail record);



	
}