package org.i9.lock.platform.dao;

import org.i9.lock.platform.model.Manager;
import org.i9.lock.platform.model.ManagerExample;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月22日 下午4:20:20
 * @author  lby
 * @version  
 * 
 */
public interface ManagerDao {
    /**
     * 添加管理员
     * @param Manager
     * @throws Exception
     */
    void addManager(Manager manager) throws Exception;
    
    /**
     * 更新管理员
     * @param Manager
     * @throws Exception
     */
    void updateManager(Manager manager) throws Exception;
    
    /**
     * 删除管理员
     * @param kid
     * @throws Exception
     */
    void deleteManager(Integer id) throws Exception;
    
    /**
     * 根据ID获取管理员
     * @param kid
     * @return
     * @throws Exception
     */
    Manager getManagerById(Integer id) throws Exception;
    
    /**
     * 分页查询管理员
     * @param ManagerSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Manager> selectByLimitPage(ManagerExample example,
            int currectPage, int pageSize) throws Exception;
    
    /**
     * 根据名字查找
     * @param currentLoginName
     * @return
     * @throws Exception
     */
    Manager findManagerByName(String currentLoginName) throws Exception;
    
}
