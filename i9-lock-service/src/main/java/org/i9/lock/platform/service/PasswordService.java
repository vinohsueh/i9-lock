package org.i9.lock.platform.service;

import java.util.List;

import org.i9.lock.platform.dao.vo.PasswordSearchDto;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年12月6日 下午2:02:15
 * @author  lby
 * @version  
 * 
 */
public interface PasswordService {
    /**
     * 添加锁密码
     * @param Password
     * @throws BusinessException
     */
    void addPassword(Password password) throws BusinessException;
    
    /**
     * 更新锁密码
     * @param Password
     * @throws BusinessException
     */
    void updatePassword(Password password) throws BusinessException;
    
    /**
     * 删除锁密码
     * @param id
     * @param userId 
     * @throws BusinessException
     */
    void deletePassword(Integer id, Long userId) throws BusinessException;
    
    /**
     * 分页查询密码
     * @param ManagerSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Password> selectByLimitPage(PasswordSearchDto passwordSearchDto,
            int currectPage, int pageSize) throws BusinessException;
    
    /**
     * 根据ID获取锁密码
     * @param kid
     * @return
     * @throws BusinessException
     */
    Password getPasswordById(Integer id) throws BusinessException;
    
    /**
     * 查询用户已有的锁的密码
     * @param lockId
     * @param userId
     * @return
     * @throws BusinessException
     */
    List<Password> selectAllPasswords(Long lockId,Long userId) throws BusinessException;
    
    /**
     * 查询用户可用的锁的密码序号
     * @param lockId
     * @return
     * @throws BusinessException 
     */
    Integer selectUsefulOrderNumber(Long lockId) throws BusinessException;

    List<Password> listAllPasswords(Long lockId, Long id) throws BusinessException;
}
