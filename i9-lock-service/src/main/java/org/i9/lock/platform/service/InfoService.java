package org.i9.lock.platform.service;

import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.model.InfoExample;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;

/** 
 * 创建时间：2017年12月25日 下午2:08:04
 * @author  lby
 * @version  
 * 
 */
public interface InfoService {
    /**
     * 添加消息
     * @param Info
     * @throws BusinessException
     */
    void addInfo(Info info) throws BusinessException;
    
    /**
     * 更新消息
     * @param Info
     * @throws BusinessException
     */
    void updateInfo(Info info) throws BusinessException;
    
    /**
     * 删除消息
     * @param kid
     * @throws BusinessException
     */
    void deleteInfo(Integer id) throws BusinessException;
    
    /**
     * 根据ID获取消息
     * @param kid
     * @return
     * @throws BusinessException
     */
    Info getInfoById(Integer id) throws BusinessException;
    
    /**
     * 分页查询消息
     * @param InfoSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Info> selectByLimitPage(InfoExample example,
            int currectPage, int pageSize) throws BusinessException;
}
