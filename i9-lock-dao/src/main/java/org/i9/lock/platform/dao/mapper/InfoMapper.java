package org.i9.lock.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.dao.vo.InfoSearchDto;
import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.model.InfoExample;

public interface InfoMapper {
    int countByExample(@Param("example") InfoSearchDto example);

    int deleteByExample(InfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
    
    List<Info> selectByLimitPage(@Param("example") InfoSearchDto infoExample, @Param("offset") int offset, @Param("limit") int pageSize);
}