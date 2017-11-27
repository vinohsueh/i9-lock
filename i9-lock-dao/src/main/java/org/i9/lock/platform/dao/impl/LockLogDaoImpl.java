package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.LockLogDao;
import org.i9.lock.platform.dao.mapper.LockLogMapper;
import org.i9.lock.platform.model.LockLog;
import org.i9.lock.platform.model.LockLogExample;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * 创建时间：2017年11月27日 下午1:19:21
 * @author  lby
 * @version  
 * 
 */
@Repository
public class LockLogDaoImpl implements LockLogDao{

    @Autowired
    private LockLogMapper lockLogMapper;
    
    @Override
    public void addLockLog(LockLog lockLog) throws Exception {
        lockLogMapper.insertSelective(lockLog);
    }

    @Override
    public void updateLockLog(LockLog lockLog) throws Exception {
        lockLogMapper.updateByPrimaryKeySelective(lockLog);
    }

    @Override
    public void deleteLockLog(Integer id) throws Exception {
        lockLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LockLog getLockLogById(Integer id) throws Exception {
        return lockLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBounds<LockLog> selectByLimitPage(LockLogExample example,
            int currectPage, int pageSize) throws Exception {
        final int totalSize = lockLogMapper.countByExample(example);
        PageBounds<LockLog> pageBounds = new PageBounds<LockLog>(currectPage, totalSize, pageSize);
        List<LockLog> list = lockLogMapper.selectByLimitPage(example, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

}
