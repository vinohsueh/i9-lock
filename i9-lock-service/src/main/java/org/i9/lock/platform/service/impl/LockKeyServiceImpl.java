package org.i9.lock.platform.service.impl;

import java.nio.ByteBuffer;

import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.LockKeyDao;
import org.i9.lock.platform.dao.vo.LockKeyDto;
import org.i9.lock.platform.dao.vo.TemporaryKeyDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.EncryptUtils;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 创建时间：2017年11月29日 下午3:37:39
 * @author  lby
 * @version  
 * 
 */
@Service
@Transactional
public class LockKeyServiceImpl implements LockKeyService{

    @Autowired
    private LockKeyDao lockKeyDao;
    
    @Autowired
    private LockDao lockDao;
    
    @Override
    public void addLockKey(LockKeyDto lockKeyDto) throws BusinessException {
        try {
            lockKeyDao.addLockKey(lockKeyDto.getLockKey());
            Lock lock = lockDao.getLockById(lockKeyDto.getLockId());
            lock.setIfShared(lockKeyDto.getIfShare());
            lock.setSafeMode(lockKeyDto.getSafeMode());
            lockDao.updateLock(lock);
        } catch (Exception e) {
           throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateLockKey(LockKey lockKey) throws BusinessException {
        try {
            lockKeyDao.updateLockKey(lockKey);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deleteLockKey(Integer id) throws BusinessException {
        try {
            lockKeyDao.deleteLockKey(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public LockKey getLockKeyById(Integer id) throws BusinessException {
        try {
            return lockKeyDao.getLockKeyById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public PageBounds<LockKey> selectByLimitPage(LockKeyExample example,
            int currectPage, int pageSize) throws BusinessException {
        try {
            return lockKeyDao.selectByLimitPage(example, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void addTemporaryKey(TemporaryKeyDto temporaryKeyDto) {
        byte [] a = EncryptUtils.longToBytes(temporaryKeyDto.getLockId());
        byte [] b = new byte[2];
        System.arraycopy(a, 6, b, 0, b.length);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.put(b);
        byte[] pwd = EncryptUtils.numberStringToByte(temporaryKeyDto.getApplyPwd());
        byteBuffer.put(pwd);
        byte[] temporaryKey = EncryptUtils.encrypt(byteBuffer.array(), temporaryKeyDto.getRandomNumber());
        LockKey lockKey = new LockKey();
        lockKey.setLockId(temporaryKeyDto.getLockId());
    }

}
