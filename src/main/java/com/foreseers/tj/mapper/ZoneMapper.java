package com.foreseers.tj.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.foreseers.tj.model.Timezone;
import com.foreseers.tj.model.TimezoneExample;

public interface ZoneMapper {
    long countByExample(TimezoneExample example);

    int deleteByExample(TimezoneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Timezone record);

    int insertSelective(Timezone record);

    List<Timezone> selectByExample(TimezoneExample example);

    Timezone selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Timezone record, @Param("example") TimezoneExample example);

    int updateByExample(@Param("record") Timezone record, @Param("example") TimezoneExample example);

    int updateByPrimaryKeySelective(Timezone record);

    int updateByPrimaryKey(Timezone record);
    
    Timezone selectByName(String name);
}