package com.foreseers.tj.mapper;

import com.foreseers.tj.model.DtProduct;
import com.foreseers.tj.model.DtProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtProductMapper {
    long countByExample(DtProductExample example);

    int deleteByExample(DtProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DtProduct record);

    int insertSelective(DtProduct record);

    List<DtProduct> selectByExample(DtProductExample example);

    DtProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DtProduct record, @Param("example") DtProductExample example);

    int updateByExample(@Param("record") DtProduct record, @Param("example") DtProductExample example);

    int updateByPrimaryKeySelective(DtProduct record);

    int updateByPrimaryKey(DtProduct record);
}