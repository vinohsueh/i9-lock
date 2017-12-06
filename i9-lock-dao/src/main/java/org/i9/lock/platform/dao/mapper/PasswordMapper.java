package org.i9.lock.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.model.PasswordExample;

public interface PasswordMapper {
    int countByExample(@Param("example") PasswordExample example);

    int deleteByExample(PasswordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Password record);

    int insertSelective(Password record);

    List<Password> selectByExample(PasswordExample example);

    Password selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Password record, @Param("example") PasswordExample example);

    int updateByExample(@Param("record") Password record, @Param("example") PasswordExample example);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);
    
    /**
     * 查询用户已有的锁的密码序号
     * @param lockId
     * @param userId
     * @return
     */
    List<Integer> selectExistOrderNumber(@Param("lockId") Long lockId,@Param("userId") Long userId);
}