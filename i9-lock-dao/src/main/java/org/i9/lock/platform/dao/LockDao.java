package org.i9.lock.platform.dao;

import java.util.Date;
import java.util.List;

import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.dao.vo.LockUpdateDto;
import org.i9.lock.platform.dao.vo.UserLongPasswordDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月22日 下午4:20:20
 * @author  lby
 * @version  
 * 
 */
public interface LockDao {
    /**
     * 添加锁
     * @param Lock
     * @throws Exception
     */
    void addLock(Lock lock) throws Exception;
    
    /**
     * 更新锁
     * @param Lock
     * @throws Exception
     */
    void updateLock(Lock lock) throws Exception;
    
    /**
     * 删除锁
     * @param kid
     * @throws Exception
     */
    void deleteLock(Long id) throws Exception;
    
    /**
     * 根据ID获取锁
     * @param kid
     * @return
     * @throws Exception
     */
    Lock getLockById(Long id) throws Exception;
    
    /**
     * 根据锁名搜索
     * @param Lockname
     * @return
     * @throws Exception
     */
    Lock getLockByLockname(String lockname) throws Exception;
    
    /**
     * 分页查询锁
     * @param LockSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Lock> selectByLimitPage(LockSearchDto lockSearchDto,
            int currectPage, int pageSize) throws Exception;
    
    /**
     * 移除锁具
     * @param id
     */
    void releaseLock(Long id) throws Exception;
    
    /**
     * 选择租户已授权的锁具
     * @param userId
     * @return
     */
    PageBounds<Lock> selectAuthorizeLocks(LockSearchDto lockSearchDto,
            int currectPage, int pageSize);
    
    /**
     * 条件查询锁
     * @param example
     * @return
     * @throws Exception
     */
    List<Lock> selectByExample(LockExample example) throws Exception;
    
    /**
     * 查询全部房东数量
     * @return
     * @throws Exception
     */
    Integer selectCount() throws Exception;
    
    
    /**
     * 房东条件查询锁
    * @Title: selectByLockDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
    * @throws BusinessException
     */
    List<Lock> selectByLockDto(LockSearchDto lockSearchDto) throws Exception;
    
    /**
     * 租户查询锁
    * @Title: selectByLockKeyDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
    * @throws Exception
     */
    List<Lock> selectByLockKeyDto(LockSearchDto lockSearchDto) throws Exception;
    
    /**
     * 更新租房类型
     */
	void updateDepartmentType(Integer lockId, Integer departmentType);
	
	 /**
     * 修改水电煤气
     */
	void updateLocks(Lock lock);
	/**
     * 双击开锁
     */
	void updateClickLock(Integer lockId, Integer clickLock);
	 
	String getLockWarnTime(Long lockId)throws Exception;
	/**
     *  查询最近修改的keyAdmin的时间
     */
	Date getKeyAdminUptime(Long lockId)throws Exception;
	 /**
     * 更换门锁
     */
	void updateLockes(LockUpdateDto lockDto)throws Exception;

	String getPwdByUidAndLockId(UserLongPasswordDto userLongPassword)throws Exception;

	void insertPwdByUidAndLockId(UserLongPasswordDto userLongPassword)throws Exception;

	void deletePwdByUidAndLockId(UserLongPasswordDto userLongPassword)throws Exception;
}
