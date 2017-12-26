package org.i9.lock.platform.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.i9.lock.platform.dao.ManagerDao;
import org.i9.lock.platform.model.Manager;
import org.i9.lock.platform.model.ManagerExample;
import org.i9.lock.platform.service.ManagerService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.i9.lock.platform.utils.PageBounds;
import org.i9.lock.platform.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/** 
 * 创建时间：2017年12月25日 下午2:08:37
 * @author  lby
 * @version  
 * 
 */
@Service
public class ManagerServiceImpl implements ManagerService{
    
    @Autowired
    private ManagerDao managerDao;
    
    @Override
    public void addManager(Manager manager) throws BusinessException {
        try {
            managerDao.addManager(manager);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateManager(Manager manager) throws BusinessException {
        try {
            managerDao.updateManager(manager);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deleteManager(Integer id) throws BusinessException {
        if (id == 1) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"这是系统管理员,不能删除");
        }
        try {
            managerDao.deleteManager(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Manager getManagerById(Integer id) throws BusinessException {
        try {
            return managerDao.getManagerById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public PageBounds<Manager> selectByLimitPage(ManagerExample example,
            int currectPage, int pageSize) throws BusinessException {
        try {
            return managerDao.selectByLimitPage(example, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Manager findManagerByName(String currentLoginName)
            throws BusinessException {
        try {
            return managerDao.findManagerByName(currentLoginName);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Manager getLoginUser() {
        Subject subject = SecurityUtils.getSubject();
        Session shiroSession = subject.getSession();
        Manager loginUser = (Manager) shiroSession.getAttribute("loginUser");
        return loginUser;
    }
    
    @Override
    public Manager login(Manager user) {
        if(user.getUsename() == null || user.getUsename().equals("")){
            throw new BusinessException("用户名不能为空");
        }
        if(user.getPassword() == null || user.getPassword().equals("")){
            throw new BusinessException("密码不能为空");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsename(),StringUtil.MD5(user.getPassword()));
        try {
            subject.login(token);
            Manager u = managerDao.findManagerByName(user.getUsename());
            Session shiroSession = subject.getSession();
            shiroSession.setAttribute("loginUser", u);
            return u;
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            throw new BusinessException("密码错误");
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            throw new BusinessException("帐号不存在");
        } catch (LockedAccountException eae) {
            // 帐号被锁定
            throw new BusinessException("帐号被锁定");
        } catch (Exception e) {
            throw new BusinessException("查询失败");
        }
    }
}
