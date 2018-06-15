package org.i9.lock.platform.service;

import java.util.List;

import org.i9.lock.platform.dao.vo.LockKeyDto;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/**
 * 
 * @author lby
 *
 * @create 2017年11月29日
 *
 */
public interface LockKeyService {
    /**
     * 添加锁钥匙
     * @param LockKey
     * @throws BusinessException
     */
    void addLockKey(LockKeyDto lockKeyDto) throws BusinessException;
    
    /**
     * 更新锁钥匙
     * @param LockKey
     * @throws BusinessException
     */
    void updateLockKey(LockKey lockKey) throws BusinessException;
    
    /**
     * 删除锁钥匙
     * @param id
     * @throws BusinessException
     */
    void deleteLockKey(Integer id) throws BusinessException;
    
    /**
     * 根据ID获取锁钥匙
     * @param kid
     * @return
     * @throws BusinessException
     */
    LockKey getLockKeyById(Integer id) throws BusinessException;
    
    /**
     * 分页查询锁钥匙
     * @param example
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<LockKey> selectByLimitPage(LockKeyExample example,
            int currectPage, int pageSize) throws BusinessException;
    
    /**
     * 通过锁id查询钥匙
     * @param lockId
     * @return
     * @throws BusinessException
     */
    List<LockKey> getLockKeyByLockId(Long lockId) throws BusinessException;
    
    /**
     * 通过锁id和用户id更新钥匙
     * @param lockKey
     */
    void updateLockKeyByTwoId(LockKey lockKey) throws BusinessException;
    
    /**
     * 根据用户id和锁id查询
     * @param lockId
     * @param userId
     * @return
     * @throws Exception
     */
    LockKey selectLockKeyByLockIdAndUserId(Long lockId, Long userId)throws BusinessException;
    
    /**
     * 更新租期
     * @param lockKey
     */
    void updateEndTime(LockKey lockKey) throws BusinessException;
    
    /**
     * 根据锁号删除全部钥匙
     * @param lockId
     * @throws BusinessException
     */
    void deleteAll(Long lockId) throws BusinessException;
    
    /**
     * 查询钥匙个数
    * @Title: selectLockKeyCountByLockId 
    * @Description: TODO
    * @param lockId
    * @return
    * @throws BusinessException
     */
    int selectLockKeyCountByLockId(Long lockId) throws BusinessException; 
}
