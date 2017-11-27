package org.i9.lock.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.model.LockLog;
import org.i9.lock.platform.model.LockLogExample;

public interface LockLogMapper {
    int countByExample(@Param("example") LockLogExample example);

    int deleteByExample(LockLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LockLog record);

    int insertSelective(LockLog record);

    List<LockLog> selectByExample(LockLogExample example);

    LockLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LockLog record, @Param("example") LockLogExample example);

    int updateByExample(@Param("record") LockLog record, @Param("example") LockLogExample example);

    int updateByPrimaryKeySelective(LockLog record);

    int updateByPrimaryKey(LockLog record);
    
    List<LockLog> selectByLimitPage(@Param("example") LockLogExample example, @Param("offset") int offset, @Param("limit") int pageSize);
}