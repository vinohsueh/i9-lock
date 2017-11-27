package org.i9.lock.platform.service;

import org.i9.lock.platform.model.LockLog;
import org.i9.lock.platform.model.LockLogExample;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月27日 下午1:41:35
 * @author  lby
 * @version  
 * 
 */
public interface LockLogService {
    /**
     * 添加锁日志
     * @param LockLog
     * @throws BusinessException
     */
    void addLockLog(LockLog lockLog) throws BusinessException;
    
    /**
     * 更新锁日志
     * @param LockLog
     * @throws BusinessException
     */
    void updateLockLog(LockLog lockLog) throws BusinessException;
    
    /**
     * 删除锁日志
     * @param kid
     * @throws BusinessException
     */
    void deleteLockLog(Integer id) throws BusinessException;
    
    /**
     * 根据ID获取锁日志
     * @param kid
     * @return
     * @throws BusinessException
     */
    LockLog getLockLogById(Integer id) throws BusinessException;
    
    /**
     * 分页查询锁日志
     * @param LockLogSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<LockLog> selectByLimitPage(LockLogExample example,
            int currectPage, int pageSize) throws BusinessException;
}
