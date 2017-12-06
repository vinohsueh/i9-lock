package org.i9.lock.platform.dao;

import java.util.List;

import org.i9.lock.platform.model.Password;

/** 
 * 创建时间：2017年12月6日 下午2:02:15
 * @author  lby
 * @version  
 * 
 */
public interface PasswordDao {
    /**
     * 添加锁密码
     * @param Password
     * @throws Exception
     */
    void addPassword(Password password) throws Exception;
    
    /**
     * 更新锁密码
     * @param Password
     * @throws Exception
     */
    void updatePassword(Password password) throws Exception;
    
    /**
     * 删除锁密码
     * @param id
     * @throws Exception
     */
    void deletePassword(Integer id) throws Exception;
    
    /**
     * 根据ID获取锁密码
     * @param kid
     * @return
     * @throws Exception
     */
    Password getPasswordById(Integer id) throws Exception;
    
    /**
     * 查询用户已有的锁的密码
     * @param lockId
     * @param userId
     * @return
     * @throws Exception
     */
    List<Password> selectAllPasswords(Long lockId,Long userId) throws Exception;
    /**
     * 查询用户已有的锁的密码序号
     * @param lockId
     * @param userId
     * @return
     * @throws Exception 
     */
    List<Integer> selectExistOrderNumber(Long lockId,Long userId) throws Exception;
}
