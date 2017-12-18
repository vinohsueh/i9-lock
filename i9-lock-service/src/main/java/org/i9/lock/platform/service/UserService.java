package org.i9.lock.platform.service;

import java.util.List;

import org.i9.lock.platform.dao.vo.PwdDto;
import org.i9.lock.platform.dao.vo.UserSearchDto;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月6日 上午10:59:00
 * @author  lby
 * @version  
 * 
 */
public interface UserService {
    /**
     * 添加用户
     * @param User
     * @throws BusinessException
     */
    void addUser(User user) throws BusinessException;
    
    /**
     * 更新用户
     * @param User
     * @throws BusinessException
     */
    void updateUser(User user) throws BusinessException;
    
    /**
     * 删除用户
     * @param kid
     * @throws BusinessException
     */
    void deleteUser(List<Long> ids) throws BusinessException;
    
    /**
     * 根据ID获取用户
     * @param kid
     * @return
     * @throws BusinessException
     */
    User getUserById(Long id) throws BusinessException;
    
    /**
     * 根据用户名搜索
     * @param username
     * @return
     * @throws BusinessException
     */
    User getUserByUsername(String username) throws BusinessException;
    
    /**
     * 获取全部的用户
     * @return
     * @throws BusinessException
     */
    List<User> findAllUser() throws BusinessException;
    
    /**
     * 分页查询用户
     * @param UserSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<User> selectByLimitPage(UserSearchDto userSearchDto,
            int currectPage, int pageSize) throws BusinessException;
    
    /**
     * 用户登录
     * @param user
     * @param request
     * @return
     * @throws BusinessException
     */
    User login(User user) throws BusinessException;
    
    /**
     * 用户注册
     * @param phone
     * @param password
     */
    void regist(User user) throws BusinessException;
    
    /**
     * 获取当前登录的用户
     * @return
     * @throws BusinessException
     */
    User getCurrentUser() throws BusinessException;
    
    /**
     * 更新亲情号
     * @param phone
     */
    void updateFamilyPhone(String phone) throws BusinessException;
    
    /**
     * 更新密码
     * @param pwdDto
     */
    void updatePwd(PwdDto pwdDto) throws BusinessException;
}   
