package org.i9.lock.platform.dao;

import java.util.List;

import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;
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

    
}
