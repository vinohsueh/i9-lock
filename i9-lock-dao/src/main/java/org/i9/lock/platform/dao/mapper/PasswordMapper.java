package org.i9.lock.platform.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.dao.vo.PasswordSearchDto;
import org.i9.lock.platform.dao.vo.SyncLockDto;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.model.PasswordExample;

public interface PasswordMapper {
    int countByExample(@Param("example") PasswordSearchDto passwordSearchDto);

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
    
    List<Password> selectByLimitPage(@Param("example") PasswordSearchDto passwordSearchDto, @Param("offset") int offset, @Param("limit") int pageSize);
    /**
     * 查询用户已有的锁的密码序号2
     * @param lockId
     * @param userId
     * @return
     */
	List<Integer> selectExistOrderNumber2(@Param("lockId")Long lockId);

	void deletePasswordByLockId(@Param("lockId") Long id);

    List<Integer> selectExistOrderNumber3(@Param("lockId") Long lockId,@Param("userId") Long userId);

    void insertPwdByLockIdAndUserId(@Param("pwdSameList") ArrayList<Password> pwdSameList);

    void delPwdByLockIdAndUserId(@Param("lockId") Long lockId,@Param("userId") Long userId,@Param("unPwdSameList") ArrayList<Integer> unPwdSameList);

    void updatePasswordByLockId(@Param("example") SyncLockDto syncLockDto);
}