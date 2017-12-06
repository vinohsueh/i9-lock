package org.i9.lock.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;

public interface LockKeyMapper {
    int countByExample(@Param("example") LockKeyExample example);

    int deleteByExample(LockKeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LockKey record);

    int insertSelective(LockKey record);

    List<LockKey> selectByExample(LockKeyExample example);

    LockKey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LockKey record, @Param("example") LockKeyExample example);

    int updateByExample(@Param("record") LockKey record, @Param("example") LockKeyExample example);

    int updateByPrimaryKeySelective(LockKey record);

    int updateByPrimaryKey(LockKey record);
    
    List<LockKey> selectByLimitPage(@Param("example") LockKeyExample example, @Param("offset") int offset, @Param("limit") int pageSize);

    List<Integer> selectExistOrderNumber(Long lockId);
}