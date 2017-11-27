package org.i9.lock.platform.dao;

import org.i9.lock.platform.model.LockLog;
import org.i9.lock.platform.model.LockLogExample;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月22日 下午4:20:20
 * @author  lby
 * @version  
 * 
 */
public interface LockLogDao {
    /**
     * 添加锁日志
     * @param LockLog
     * @throws Exception
     */
    void addLockLog(LockLog lockLog) throws Exception;
    
    /**
     * 更新锁日志
     * @param LockLog
     * @throws Exception
     */
    void updateLockLog(LockLog lockLog) throws Exception;
    
    /**
     * 删除锁日志
     * @param kid
     * @throws Exception
     */
    void deleteLockLog(Integer id) throws Exception;
    
    /**
     * 根据ID获取锁日志
     * @param kid
     * @return
     * @throws Exception
     */
    LockLog getLockLogById(Integer id) throws Exception;
    
    /**
     * 分页查询锁日志
     * @param LockLogSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<LockLog> selectByLimitPage(LockLogExample example,
            int currectPage, int pageSize) throws Exception;
    
}
