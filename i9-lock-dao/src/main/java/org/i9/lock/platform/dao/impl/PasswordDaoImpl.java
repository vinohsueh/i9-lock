package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.PasswordDao;
import org.i9.lock.platform.dao.mapper.PasswordMapper;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.model.PasswordExample;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Password> selectAllPasswords(Long lockId, Long userId)
            throws Exception {
        PasswordExample example = new PasswordExample();
        example.createCriteria().andLockIdEqualTo(lockId);
        example.createCriteria().andUserIdEqualTo(userId);
        List<Password> list = passwordMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<Integer> selectExistOrderNumber(Long lockId, Long userId)
            throws Exception {
        return passwordMapper.selectExistOrderNumber(lockId,userId);
    }

}
