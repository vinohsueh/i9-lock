package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.LockKeyDao;
import org.i9.lock.platform.dao.mapper.LockKeyMapper;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * 创建时间：2017年11月29日 上午10:20:31
 * @author  lby
 * @version  
 * 
 */
@Repository
public class LockKeyDaoImpl implements LockKeyDao{
    
    @Autowired
    private LockKeyMapper lockKeyMapper;
    
    @Override
    public void addLockKey(LockKey lockKey) throws Exception {
        lockKeyMapper.insertSelective(lockKey);
    }

    @Override
    public void updateLockKey(LockKey lockKey) throws Exception {
        lockKeyMapper.updateByPrimaryKeySelective(lockKey);
    }

    @Override
    public void deleteLockKey(Integer id) throws Exception {
        lockKeyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LockKey getLockKeyById(Integer id) throws Exception {
        return lockKeyMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBounds<LockKey> selectByLimitPage(LockKeyExample example,
            int currectPage, int pageSize) throws Exception {
        final int totalSize = lockKeyMapper.countByExample(example);
        PageBounds<LockKey> pageBounds = new PageBounds<LockKey>(currectPage, totalSize, pageSize);
        List<LockKey> list = lockKeyMapper.selectByLimitPage(example, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

    @Override
    public List<Integer> selectExistOrderNumber(Long lockId) throws Exception {
        return lockKeyMapper.selectExistOrderNumber(lockId);
    }

    @Override
    public LockKey selectLockKeyByLockIdAndUserId(Long lockId, Long userId)
            throws Exception {
        return lockKeyMapper.selectLockKeyByLockIdAndUserId(lockId,userId);
    }

    @Override
    public List<LockKey> getLockKeyByLockId(Long lockId) throws Exception {
        return lockKeyMapper.getLockKeyByLockId(lockId);
    }

    @Override
    public void updateLockKeyByTwoId(LockKey lockKey) throws Exception {
        lockKeyMapper.updateLockKeyByTwoId(lockKey);
    }

}
