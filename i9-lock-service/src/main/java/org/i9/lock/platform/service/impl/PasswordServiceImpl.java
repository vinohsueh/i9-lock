package org.i9.lock.platform.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.i9.lock.platform.dao.ConfigDao;
import org.i9.lock.platform.dao.LockDao;
import org.i9.lock.platform.dao.LockKeyDao;
import org.i9.lock.platform.dao.PasswordDao;
import org.i9.lock.platform.dao.vo.PasswordSearchDto;
import org.i9.lock.platform.model.Config;
import org.i9.lock.platform.model.Lock;
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
    
    @Autowired
    private ConfigDao configDao;
    
    @Autowired
    private LockDao lockDao;
    @Override
    public void addPassword(Password password) throws BusinessException {
        try {
            LockKey lockKey = lockKeyDao.selectLockKeyByLockIdAndUserId(password.getLockId(),password.getUserId());
            Lock lock = lockDao.getLockById(password.getLockId());
            if (lockKey == null && lock.getUserId() != password.getUserId()) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,"该用户非本房屋租户或房主,不能设密码");
            }
            List<Integer> existNumbers = passwordDao.selectExistOrderNumber(password.getLockId(), password.getUserId());
            if(existNumbers.contains(password.getOrderNumber())) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,"该密码顺序编号已存在");
            }
            /*Integer orderNumber = this.selectUsefulOrderNumber(password.getLockId(), password.getUserId());
            password.setOrderNumber(orderNumber);*/
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
    public void deletePassword(Integer id, Long userId) throws BusinessException {
        try {
            Password password = passwordDao.getPasswordById(id);
            if (password.getUserId() != userId){
                throw new BusinessException("不能删除别人的密码!");
            }
            passwordDao.deletePassword(id);
        } catch (BusinessException e) {
            throw new BusinessException(e.getErrorMessage());
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
    public Integer selectUsefulOrderNumber(Long lockId)
            throws BusinessException {
        try {
            List<Integer> list = passwordDao.selectExistOrderNumbers(lockId);
          //查询最大可用编号数
            Config config = configDao.selectMaxPassword();
            int max = config.getConfigValue();
            if (list.size() >= max) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,"密码最多不能超过"+max+"组");
            }
            return selectOrderNumber(list,max);
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
    private static Integer selectOrderNumber(List<Integer> list,int max) {
        //最大可用编号数集合
        List<Integer> maxArray = new ArrayList<Integer>();
        for (int i = 0; i < max; i++) {
            maxArray.add(i);
        }
        
        List<Integer> array = new ArrayList<Integer>();
        for (Integer integer : maxArray) {
            if (!array.contains(integer) && !list.contains(integer)) {
                array.add(integer);
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

    @Override
    public List<Password> listAllPasswords(Long lockId, Long userId)
            throws BusinessException {
        try {
            List<Password> passwords = passwordDao.selectAllPasswords(lockId,userId);
            //查询最大可用编号数
            /*Config config = configDao.selectMaxPassword();
            int max = config.getConfigValue();
            //最大可用编号数集合
            List<Integer> maxArray = new ArrayList<Integer>();
            for (int i = 0; i < max; i++) {
                maxArray.add(i);
            }
            
            List<Integer> array = new ArrayList<Integer>();
            for (Password password : passwords) {
                array.add(password.getOrderNumber());
            }
            //将密码填充满 
            maxArray.removeAll(array);
            for (Integer integer : maxArray) {
                Password password = new Password();
                password.setName("未设置");
                password.setOrderNumber(integer);
                passwords.add(password);
            }
            Collections.sort(passwords, new PasswordComparator());*/
            return passwords;
        } catch (Exception e) {
            throw new BusinessException("查询用户全部密码失败",e.getMessage());
        }
    }

	@Override
	public void deletePasswordByLockId(Long id) throws BusinessException {
		try {
             passwordDao.deletePasswordByLockId(id);
        } catch (Exception e) {
            throw new BusinessException("删除用户指纹密码失败",e.getMessage());
        }
	}
}
