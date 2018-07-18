package org.i9.lock.platform.service;

import java.util.List;

import org.i9.lock.platform.dao.vo.LockReleaseDto;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月22日 下午4:37:52
 * @author  lby
 * @version  
 * 
 */
public interface LockService {
    /**
     * 添加锁
     * @param Lock
     * @throws BusinessException
     */
    void addLock(Lock lock) throws BusinessException;
    
    /**
     * 更新锁
     * @param Lock
     * @throws BusinessException
     */
    void updateLock(Lock lock) throws BusinessException;
    
    /**
     * 删除锁
     * @param kid
     * @throws BusinessException
     */
    void deleteLock(Long id) throws BusinessException;
    
    /**
     * 根据ID获取锁
     * @param kid
     * @return
     * @throws BusinessException
     */
    Lock getLockById(Long id) throws BusinessException;
    
    /**
     * 根据锁名搜索
     * @param Lockname
     * @return
     * @throws BusinessException
     */
    Lock getLockByLockname(String lockname) throws BusinessException;
    
    /**
     * 分页查询锁
     * @param LockSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Lock> selectByLimitPage(LockSearchDto lockSearchDto,
            int currectPage, int pageSize) throws BusinessException;
    
    /**
     * 锁具移交验证
     * @param lockReleaseDto
     */
    void releaseLockValidate(LockReleaseDto lockReleaseDto) throws BusinessException;
    
    /**
     * 锁具移交
     * @param lockId
     */
    void releaseLock(Long lockId) throws BusinessException;
    
    /**
     * 选择租户已授权的锁具
     * @return
     */
    PageBounds<Lock> selectAuthorizeLocks(LockSearchDto lockSearchDto,
            int currectPage, int pageSize)throws BusinessException;
    
    /**
     * 条件查询锁
     * @param example
     * @return
     * @throws BusinessException
     */
    List<Lock> selectByExample(LockExample example) throws BusinessException;
    
    /**
     * 查询全部房东数量
     * @return
     * @throws BusinessException
     */
    Integer selectCount() throws BusinessException;
    
    /**
     * 房东条件查询锁
    * @Title: selectByLockDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
    * @throws BusinessException
     */
    List<Lock> selectByLockDto(LockSearchDto lockSearchDto) throws BusinessException;
    
    /**
     * 若是租户查询锁
    * @Title: selectByLockKeyDto 
    * @Description: TODO
    * @param lockSearchDto
    * @return
    * @throws BusinessException
     */
    List<Lock> selectByLockKeyDto(LockSearchDto lockSearchDto) throws BusinessException;
    
    /**
     * 更新租房类型
     */
	void updateDepartmentType(Integer lockId, Integer departmentType);

	/**
     * 修改房屋水电煤气费用单价
     */
	void updateLocks(Lock lock);
	 /**
     * 双击开锁
     */
	void updateClickLock(Integer lockId, Integer clickLock) throws BusinessException;
}
