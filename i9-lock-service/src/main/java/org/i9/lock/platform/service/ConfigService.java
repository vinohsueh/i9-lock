package org.i9.lock.platform.service;

import java.util.List;

import org.i9.lock.platform.model.Config;
import org.i9.lock.platform.utils.BusinessException;

/** 
 * 创建时间：2018年1月3日 上午10:16:49
 * @author  lby
 * @version  
 * 
 */
public interface ConfigService {
    /**
     * 更新配置
     * @param config
     * @throws BusinessException
     */
    void updateConfig(Config config) throws BusinessException;
    
    /**
     * 查询最大房客数
     * @return
     * @throws BusinessException
     */
    Config selectMaxHirer() throws BusinessException;
    
    /**
     * 查询最大密码数	
     * @return
     * @throws BusinessException
     */
    Config selectMaxPassword() throws BusinessException;
    
    
    /**
     * 查询全部配置
     * @return
     * @throws BusinessException
     */
    List<Config> selectAllConfigs() throws BusinessException;
}
