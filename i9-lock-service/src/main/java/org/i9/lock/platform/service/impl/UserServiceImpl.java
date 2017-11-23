package org.i9.lock.platform.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.i9.lock.platform.dao.UserDao;
import org.i9.lock.platform.dao.vo.UserSearchDto;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.i9.lock.platform.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 创建时间：2017年11月6日 上午10:59:52
 * @author  lby
 * @version  
 * 
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private HttpServletRequest request;
    
    @Override
    public void addUser(User user) throws BusinessException {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) throws BusinessException {
        try {
            userDao.updateUser(user);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(List<Long> ids) throws BusinessException {
        try {
            userDao.deleteUser(ids);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public User getUserById(int id) throws BusinessException {
        try {
            return userDao.getUserById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        
    }

    @Override
    public User getUserByUsername(String username) throws BusinessException {
        try {
            return userDao.getUserByUsername(username);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<User> findAllUser() throws BusinessException {
        try {
            return userDao.findAllUser();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public PageBounds<User> selectByLimitPage(UserSearchDto userSearchDto,
            int currectPage, int pageSize) throws BusinessException {
        try {
            return userDao.selectByLimitPage(userSearchDto, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public User login(User user)
            throws BusinessException {
        User currentUser = null;
        try {
            currentUser = userDao.getUserByPhone(user.getPhone());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"查询失败",e.getMessage());
        }
        
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.LOGIN_ERROR,"用户不存在");
        }
        if (!currentUser.getPassword().equals(StringUtil.MD5(user.getPassword()))){
            throw new BusinessException(ErrorCode.LOGIN_ERROR,"密码错误");
        }
        request.getSession().setAttribute("user", currentUser);
        return currentUser;
    }

    @Override
    public void regist(User user) throws BusinessException {
        User currentUser = null;
        try {
            currentUser = userDao.getUserByPhone(user.getPhone());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.LOGIN_ERROR,"查询失败",e.getMessage());
        }
        if (currentUser != null) {
            throw new BusinessException(ErrorCode.LOGIN_ERROR,"该手机号已注册");
        }
        //加密
        String encrypePassword = StringUtil.MD5(user.getPassword());
        user.setPassword(encrypePassword);
        user.setCreateTime(new Date());
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"注册失败",e.getMessage());
        }
    }

    @Override
    public User getCurrentUser() throws BusinessException {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }
}
