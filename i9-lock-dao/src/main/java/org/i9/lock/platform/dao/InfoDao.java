package org.i9.lock.platform.dao;

import org.i9.lock.platform.dao.vo.InfoSearchDto;
import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年11月22日 下午4:20:20
 * @author  lby
 * @version  
 * 
 */
public interface InfoDao {
    /**
     * 添加消息
     * @param Info
     * @throws Exception
     */
    void addInfo(Info info) throws Exception;
    
    /**
     * 更新消息
     * @param Info
     * @throws Exception
     */
    void updateInfo(Info info) throws Exception;
    
    /**
     * 删除消息
     * @param kid
     * @throws Exception
     */
    void deleteInfo(Integer id) throws Exception;
    
    /**
     * 根据ID获取消息
     * @param kid
     * @return
     * @throws Exception
     */
    Info getInfoById(Integer id) throws Exception;
    
    /**
     * 分页查询消息
     * @param InfoSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Info> selectByLimitPage(InfoSearchDto example,
            int currectPage, int pageSize) throws Exception;
    
}
