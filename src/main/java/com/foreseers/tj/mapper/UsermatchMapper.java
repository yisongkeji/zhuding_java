package com.foreseers.tj.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.foreseers.tj.model.Usermatch;
import com.foreseers.tj.model.UsermatchExample;
import com.foreseers.tj.model.UsermatchWithBLOBs;

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

	int updateByzhuidKeySelective(UsermatchWithBLOBs record);
}