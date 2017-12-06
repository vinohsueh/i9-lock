package org.i9.lock.platform.dao;

import java.util.List;

import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月22日 下午4:20:20
 * @author  lby
 * @version  
 * 
 */
public interface LockKeyDao {
    /**
     * 添加锁钥匙
     * @param LockKey
     * @throws Exception
     */
    void addLockKey(LockKey lockKey) throws Exception;
    
    /**
     * 更新锁钥匙
     * @param LockKey
     * @throws Exception
     */
    void updateLockKey(LockKey lockKey) throws Exception;
    
    /**
     * 删除锁钥匙
     * @param id
     * @throws Exception
     */
    void deleteLockKey(Integer id) throws Exception;
    
    /**
     * 根据ID获取锁钥匙
     * @param kid
     * @return
     * @throws Exception
     */
    LockKey getLockKeyById(Integer id) throws Exception;
    
    /**
     * 分页查询锁钥匙
     * @param example
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<LockKey> selectByLimitPage(LockKeyExample example,
            int currectPage, int pageSize) throws Exception;
    
    /**
     * 查询已经有的用户组编号
     * @param lockId
     * @return
     */
    List<Integer> selectExistOrderNumber(Long lockId) throws Exception;
    
    /**
     * 通过锁id和用户id查询锁钥匙
     * @param lockId
     * @param id
     * @return
     */
    LockKey selectLockKeyByLockIdAndUserId(Long lockId, Long userId)throws Exception;
}
