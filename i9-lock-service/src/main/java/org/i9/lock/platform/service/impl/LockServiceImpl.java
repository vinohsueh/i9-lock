package org.i9.lock.platform.service.impl;

import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.UserDao;
import org.i9.lock.platform.dao.vo.LockReleaseDto;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.i9.lock.platform.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/** 
 * 创建时间：2017年11月22日 下午4:38:13
 * @author  lby
 * @version  
 * 
 */
@Service
@Transactional
public class LockServiceImpl implements LockService{

    @Autowired
    private LockDao lockDao;

    @Autowired
    private UserDao userDao;
    
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

    @Override
    public void releaseLock(LockReleaseDto lockReleaseDto)
            throws BusinessException {
        try {
            Lock lock = lockDao.getLockById(lockReleaseDto.getLockId());
            if (lock == null) {
                throw new BusinessException(ErrorCode.RECEIVE_DATA_ERROR,"锁id错误");
            }
            User user = userDao.getUserById(lock.getUserId());
            
            //验证输入的房主信息和锁信息和数据库的是否匹配
            if (lock != null && user != null) {
                if (!user.getPhone().equals(lockReleaseDto.getPhone())){
                    throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR,"房主用户名错误");
                }
                String md5Password = StringUtil.MD5(lockReleaseDto.getPassword());
                if (!md5Password.equals(user.getPassword())) {
                    throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR,"房主密码错误");
                }
                if (!String.valueOf(lock.getKeyAdmin()).equals(lockReleaseDto.getKeyAdmin())){
                    throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR,"锁具码错误");
                }
            }else {
                throw new BusinessException(ErrorCode.RELEASE_LOCK_ERROR,"门锁移交错误");
            }
            
            //清空锁的绑定信息
            lockDao.releaseLock(lock.getId());
        } catch (BusinessException e) {
            throw new BusinessException(e.getErrorCode(),e.getErrorMessage());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"查询锁和用户失败",e.getMessage());
        }
        
    }
    

}
