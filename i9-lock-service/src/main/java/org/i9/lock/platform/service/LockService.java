package org.i9.lock.platform.service;

import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
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
}
