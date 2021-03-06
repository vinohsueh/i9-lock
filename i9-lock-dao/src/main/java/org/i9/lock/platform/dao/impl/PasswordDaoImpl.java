package org.i9.lock.platform.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.i9.lock.platform.dao.PasswordDao;
import org.i9.lock.platform.dao.mapper.PasswordMapper;
import org.i9.lock.platform.dao.vo.PasswordSearchDto;
import org.i9.lock.platform.dao.vo.SyncLockDto;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.model.PasswordExample;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * 创建时间：2017年12月6日 下午2:10:53
 * @author  lby
 * @version  
 * 
 */
@Repository
public class PasswordDaoImpl implements PasswordDao{

    @Autowired
    private PasswordMapper passwordMapper;
    
    @Override
    public void addPassword(Password password) throws Exception {
        passwordMapper.insertSelective(password);
    }

    @Override
    public void updatePassword(Password password) throws Exception {
        passwordMapper.updateByPrimaryKeySelective(password);
    }

    @Override
    public void deletePassword(Integer id) throws Exception {
        passwordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Password getPasswordById(Integer id) throws Exception {
        return passwordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Password> selectAllPasswords(Long lockId, Long userId)
            throws Exception {
        PasswordExample example = new PasswordExample();
        example.createCriteria().andLockIdEqualTo(lockId).andUserIdEqualTo(userId);
        List<Password> list = passwordMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<Integer> selectExistOrderNumber(Long lockId, Long userId)
            throws Exception {
        return passwordMapper.selectExistOrderNumber(lockId,userId);
    }

	@Override
	public PageBounds<Password> selectByLimitPage(PasswordSearchDto passwordSearchDto, int currectPage, int pageSize)
			throws Exception {
		 	final int totalSize = passwordMapper.countByExample(passwordSearchDto);
	        PageBounds<Password> pageBounds = new PageBounds<Password>(currectPage, totalSize, pageSize);
	        List<Password> list = passwordMapper.selectByLimitPage(passwordSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
	        pageBounds.setPageList(list);
	        return pageBounds;
	}

	@Override
	public List<Integer> selectExistOrderNumbers(Long lockId,Long userId)throws Exception {
		// TODO Auto-generated method stub
		return passwordMapper.selectExistOrderNumber(lockId,userId);
	}

	@Override
	public void deletePasswordByLockId(Long id) throws Exception {
		passwordMapper.deletePasswordByLockId(id);
	}

    @Override
    public List<Integer> selectExistOrderNumber3(Long lockId, Long userId) throws Exception {
        return passwordMapper.selectExistOrderNumber3(lockId,userId);
    }

    @Override
    public void insertPwdByLockIdAndUserId(ArrayList<Password> pwdSameList) throws Exception {
        passwordMapper.insertPwdByLockIdAndUserId(pwdSameList);
    }

    @Override
    public void delPwdByLockIdAndUserId(Long lockId, Long userId, ArrayList<Integer> unPwdSameList) throws Exception {
        passwordMapper.delPwdByLockIdAndUserId(lockId,userId,unPwdSameList);
    }

    @Override
    public void updatePasswordByLockId(SyncLockDto syncLockDto) throws Exception {
        passwordMapper.updatePasswordByLockId(syncLockDto);
    }

}
