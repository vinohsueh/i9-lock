package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.mapper.LockMapper;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockExample;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * 创建时间：2017年11月22日 下午4:31:09
 * @author  lby
 * @version  
 * 
 */
@Repository
public class LockDaoImpl implements LockDao{

    @Autowired
    private LockMapper lockMapper;
    
    @Override
    public void addLock(Lock lock) throws Exception {
        lockMapper.insertSelective(lock);
    }

    @Override
    public void updateLock(Lock lock) throws Exception {
        lockMapper.updateByPrimaryKeySelective(lock);
    }

    @Override
    public void deleteLock(Long id) throws Exception {
        lockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Lock getLockById(Long id) throws Exception {
        return lockMapper.selectByPrimaryKey(id);
    }

    @Override
    public Lock getLockByLockname(String lockname) throws Exception {
        LockExample example = new LockExample();
        example.createCriteria().andNameEqualTo(lockname);
        List<Lock> list = lockMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageBounds<Lock> selectByLimitPage(LockSearchDto lockSearchDto,
            int currectPage, int pageSize) throws Exception {
        final int totalSize = lockMapper.countByExample(lockSearchDto);
        PageBounds<Lock> pageBounds = new PageBounds<Lock>(currectPage, totalSize, pageSize);
        List<Lock> list = lockMapper.selectByLimitPage(lockSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

}