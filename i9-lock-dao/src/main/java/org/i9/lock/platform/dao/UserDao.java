package org.i9.lock.platform.dao;

import java.util.List;

import org.i9.lock.platform.dao.vo.UserSearchDto;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月6日 上午10:32:58
 * @author  lby
 * @version  
 * 
 */
public interface UserDao {
    /**
     * 添加用户
     * @param User
     * @throws Exception
     */
    void addUser(User user) throws Exception;
    
    /**
     * 更新用户
     * @param User
     * @throws Exception
     */
    void updateUser(User user) throws Exception;
    
    /**
     * 删除用户
     * @param kid
     * @throws Exception
     */
    void deleteUser(List<Long> ids) throws Exception;
    
    /**
     * 根据ID获取用户
     * @param kid
     * @return
     * @throws Exception
     */
    User getUserById(Long id) throws Exception;
    
    /**
     * 根据用户名搜索
     * @param username
     * @return
     * @throws Exception
     */
    User getUserByUsername(String username) throws Exception;
    
    /**
     * 获取全部的用户
     * @return
     * @throws Exception
     */
    List<User> findAllUser() throws Exception;
    
    /**
     * 分页查询用户
     * @param UserSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<User> selectByLimitPage(UserSearchDto userSearchDto,
            int currectPage, int pageSize) throws Exception;
    
    /**
     *     
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);
}
