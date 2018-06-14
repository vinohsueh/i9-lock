package org.i9.lock.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.model.Price;
import org.i9.lock.platform.model.PriceExample;

public interface PriceMapper {
    long countByExample(PriceExample example);

    int deleteByExample(PriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Price record);

    int insertSelective(Price record);

    List<Price> selectByExample(PriceExample example);

    Price selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByExample(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);
}