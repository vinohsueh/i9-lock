package org.i9.lock.platform.service.impl;

import org.i9.lock.platform.dao.LockLogDao;
import org.i9.lock.platform.model.LockLog;
import org.i9.lock.platform.model.LockLogExample;
import org.i9.lock.platform.service.LockLogService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 创建时间：2017年11月27日 下午1:50:08
 * @author  lby
 * @version  
 * 
 */
@Service
@Transactional
public class LockLogServiceImpl implements LockLogService{

    @Autowired
    private LockLogDao lockLogDao;
    
    @Override
    public void addLockLog(LockLog lockLog) throws BusinessException {
        try {
            lockLogDao.addLockLog(lockLog);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"添加锁日志失败",e.getMessage());
        }
    }

    @Override
    public void updateLockLog(LockLog lockLog) throws BusinessException {
        try {
            lockLogDao.updateLockLog(lockLog);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"更新锁日志失败",e.getMessage());
        }
    }

    @Override
    public void deleteLockLog(Integer id) throws BusinessException {
        try {
            lockLogDao.deleteLockLog(id);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"删除锁日志失败",e.getMessage());
        }
    }

    @Override
    public LockLog getLockLogById(Integer id) throws BusinessException {
        try {
            return lockLogDao.getLockLogById(id);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"查询锁日志失败",e.getMessage());
        }
    }   

    @Override
    public PageBounds<LockLog> selectByLimitPage(LockLogExample example,
            int currectPage, int pageSize) throws BusinessException {
        try {
            return lockLogDao.selectByLimitPage(example, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"分页查询锁日志失败",e.getMessage());
        }
    }

}
