package org.i9.lock.platform.service.impl;

import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 创建时间：2017年11月22日 下午4:38:13
 * @author  lby
 * @version  
 * 
 */
@Service
public class LockServiceImpl implements LockService{

    @Autowired
    private LockDao lockDao;

    @Override
    public void addLock(Lock lock) throws BusinessException {
        try {
            lockDao.addLock(lock);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"添加锁失败",e.getMessage());
        }
    }

    @Override
    public void updateLock(Lock lock) throws BusinessException {
        try {
            lockDao.updateLock(lock);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"更新锁失败",e.getMessage());
        }
        
    }

    @Override
    public void deleteLock(Long id) throws BusinessException {
        try {
            lockDao.deleteLock(id);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"删除锁失败",e.getMessage());
        }
    }

    @Override
    public Lock getLockById(Long id) throws BusinessException {
        try {
            return lockDao.getLockById(id);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"根据id查询锁失败",e.getMessage());
        }
    }

    @Override
    public Lock getLockByLockname(String lockname) throws BusinessException {
        try {
            return lockDao.getLockByLockname(lockname);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"根据锁名查询锁失败",e.getMessage());
        }
    }

    @Override
    public PageBounds<Lock> selectByLimitPage(LockSearchDto lockSearchDto,
            int currectPage, int pageSize) throws BusinessException {
        try {
            return lockDao.selectByLimitPage(lockSearchDto, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"分页查询锁失败",e.getMessage());
        }
    }
    

}
