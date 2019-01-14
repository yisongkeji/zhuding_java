package com.example.demo.mapper;

import com.example.demo.model.Usermatch;
import com.example.demo.model.UsermatchExample;
import com.example.demo.model.UsermatchWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsermatchMapper {
    long countByExample(UsermatchExample example);

    int deleteByExample(UsermatchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UsermatchWithBLOBs record);

    int insertSelective(UsermatchWithBLOBs record);

    List<UsermatchWithBLOBs> selectByExampleWithBLOBs(UsermatchExample example);

    List<Usermatch> selectByExample(UsermatchExample example);

    UsermatchWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UsermatchWithBLOBs record, @Param("example") UsermatchExample example);

    int updateByExampleWithBLOBs(@Param("record") UsermatchWithBLOBs record, @Param("example") UsermatchExample example);

    int updateByExample(@Param("record") Usermatch record, @Param("example") UsermatchExample example);

    int updateByPrimaryKeySelective(UsermatchWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UsermatchWithBLOBs record);

    int updateByPrimaryKey(Usermatch record);

    UsermatchWithBLOBs usermatchQuery(Integer zhuid, Integer congid);
}