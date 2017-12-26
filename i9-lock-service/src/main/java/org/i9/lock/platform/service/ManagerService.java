package org.i9.lock.platform.service;

import org.i9.lock.platform.model.Manager;
import org.i9.lock.platform.model.ManagerExample;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年12月25日 下午2:08:04
 * @author  lby
 * @version  
 * 
 */
public interface ManagerService {
    /**
     * 添加管理员
     * @param Manager
     * @throws BusinessException
     */
    void addManager(Manager manager) throws BusinessException;
    
    /**
     * 更新管理员
     * @param Manager
     * @throws BusinessException
     */
    void updateManager(Manager manager) throws BusinessException;
    
    /**
     * 删除管理员
     * @param kid
     * @throws BusinessException
     */
    void deleteManager(Integer id) throws BusinessException;
    
    /**
     * 根据ID获取管理员
     * @param kid
     * @return
     * @throws BusinessException
     */
    Manager getManagerById(Integer id) throws BusinessException;
    
    /**
     * 分页查询管理员
     * @param ManagerSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Manager> selectByLimitPage(ManagerExample example,
            int currectPage, int pageSize) throws BusinessException;
    
    
    Manager findManagerByName(String currentLoginName) throws BusinessException;
    
    /**
     * 获取登录人信息
     * @return
     */
    Manager getLoginUser();
    
    /**
     * 登录
     * @param manager
     * @return
     */
    Manager login(Manager manager) throws BusinessException;
}
