package org.i9.lock.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;

public interface LockMapper {
    int countByExample(@Param("example") LockSearchDto lockSearchDto);

    int deleteByExample(LockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Lock record);

    int insertSelective(Lock record);

    List<Lock> selectByExample(LockExample example);

    Lock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Lock record, @Param("example") LockExample example);

    int updateByExample(@Param("record") Lock record, @Param("example") LockExample example);

    int updateByPrimaryKeySelective(Lock record);

    int updateByPrimaryKey(Lock record);
    
    List<Lock> selectByLimitPage(@Param("example") LockSearchDto lockSearchDto, @Param("offset") int offset, @Param("limit") int pageSize);
    
    /**
     * 移除锁具
     * @param id
     */
    void releaseLock(Long id);
    /**
     * 选择租户已授权的锁具
     * @param userId
     * @return
     */
    List<Lock> selectAuthorizeLocks(@Param("example") LockSearchDto lockSearchDto,@Param("offset") int offset,
            @Param("limit")int pageSize);
    
    int countAuthorizeLocks(@Param("example") LockSearchDto lockSearchDto);

    /**
     * 房东条件查询锁
    * @Title: selectByLockDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
     */
    List<Lock> selectByLockDto(@Param("example") LockSearchDto lockSearchDto);
    
    /**
     * 租户条件查询锁
    * @Title: selectByLockKeyDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
     */
    List<Lock> selectByLockKeyDto(@Param("example") LockSearchDto lockSearchDto);
    
    /**
     * 更新租房类型
     */
	void updateDepartmentType(@Param("lockId")Integer lockId,@Param("departmentType")Integer departmentType);
	
	 /**
     * 修改水电煤气
     */
	void updateLocks(Lock lock);
}