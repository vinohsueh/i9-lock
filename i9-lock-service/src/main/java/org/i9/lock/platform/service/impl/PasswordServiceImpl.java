package org.i9.lock.platform.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.i9.lock.platform.dao.LockKeyDao;
import org.i9.lock.platform.dao.PasswordDao;
import org.i9.lock.platform.dao.vo.PasswordSearchDto;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.service.PasswordService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 创建时间：2017年12月6日 下午2:18:44
 * @author  lby
 * @version  
 * 
 */
@Service
public class PasswordServiceImpl implements PasswordService{

    @Autowired
    private PasswordDao passwordDao;
    
    @Autowired
    private LockKeyDao lockKeyDao;
    
    private static final Integer [] ARRAY = {0,1,2,3,4,5,6,7,8,9};
    @Override
    public void addPassword(Password password) throws BusinessException {
        try {
            LockKey lockKey = lockKeyDao.selectLockKeyByLockIdAndUserId(password.getLockId(),password.getUserId());
            if (lockKey == null) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,"该用户非本房屋租户,不能设密码");
            }
            List<Integer> existNumbers = passwordDao.selectExistOrderNumber(password.getLockId(), password.getUserId());
            if(existNumbers.contains(password.getOrderNumber())) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,"该密码顺序编号已存在");
            }
            passwordDao.addPassword(password);
        } catch (BusinessException e) {
            throw new BusinessException(e.getErrorCode(),e.getErrorMessage());
        } catch (Exception e) {
            throw new BusinessException("添加密码失败",e.getMessage());
        }
    }

    @Override
    public void updatePassword(Password password) throws BusinessException {
        try {
            passwordDao.updatePassword(password);
        } catch (Exception e) {
            throw new BusinessException("更新密码失败",e.getMessage());
        }
    }

    @Override
    public void deletePassword(Integer id) throws BusinessException {
        try {
            passwordDao.deletePassword(id);
        } catch (Exception e) {
            throw new BusinessException("删除密码失败",e.getMessage());
        }
    }

    @Override
    public Password getPasswordById(Integer id) throws BusinessException {
        try {
            Password password = passwordDao.getPasswordById(id);
            return password;
        } catch (Exception e) {
            throw new BusinessException("根据id查询密码失败",e.getMessage());
        }
    }

    @Override
    public List<Password> selectAllPasswords(Long lockId, Long userId)
            throws BusinessException {
        try {
            List<Password> passwords = passwordDao.selectAllPasswords(lockId,userId);
            return passwords;
        } catch (Exception e) {
            throw new BusinessException("查询用户全部密码失败",e.getMessage());
        }
    }

    @Override
    public Integer selectUsefulOrderNumber(Long lockId, Long userId)
            throws BusinessException {
        try {
            List<Integer> list = passwordDao.selectExistOrderNumber(lockId, userId);
            if (list.size() >= 10) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,"密码最多不能超过10组");
            }
            return selectOrderNumber(list);
        } catch (BusinessException e) {
            throw new BusinessException(e.getErrorCode(),e.getErrorMessage());
        } catch (Exception e) {
            throw new BusinessException("查询用户已有的锁的密码序号失败",e.getMessage());
        }
    }
    /**
     * 查询0-9的编号 最小未使用编号
     * @param list
     * @return
     */
    private static Integer selectOrderNumber(List<Integer> list) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < ARRAY.length; i++) {
            if (!array.contains(ARRAY[i]) && !list.contains(ARRAY[i])) {
                array.add(ARRAY[i]);
            }
        }
        Integer orderNumber = Collections.min(array);
        return orderNumber;
    }

	@Override
	public PageBounds<Password> selectByLimitPage(PasswordSearchDto passwordSearchDto, int currectPage, int pageSize)
			throws BusinessException {
		 try {
	            return passwordDao.selectByLimitPage(passwordSearchDto, currectPage, pageSize);
	        } catch (Exception e) {
	            throw new BusinessException(e.getMessage());
	        }
	}
}
