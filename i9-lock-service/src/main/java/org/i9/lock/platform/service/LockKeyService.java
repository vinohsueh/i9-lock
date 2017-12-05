package org.i9.lock.platform.service;

import org.i9.lock.platform.dao.vo.LockKeyDto;
import org.i9.lock.platform.dao.vo.TemporaryKeyDto;
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
     * 添加临时锁
     * @param temporaryKeyDto
     */
    void addTemporaryKey(TemporaryKeyDto temporaryKeyDto);
    
}
