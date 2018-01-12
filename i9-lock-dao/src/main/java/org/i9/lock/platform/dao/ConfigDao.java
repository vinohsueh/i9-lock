package org.i9.lock.platform.dao;

import java.util.List;

import org.i9.lock.platform.model.Config;

/** 
 * 创建时间：2018年1月3日 上午10:16:49
 * @author  lby
 * @version  
 * 
 */
public interface ConfigDao {
    /**
     * 更新配置
     * @param config
     * @throws Exception
     */
    void updateConfig(Config config) throws Exception;
    
    /**
     * 查询最大房客数
     * @return
     * @throws Exception
     */
    Config selectMaxHirer() throws Exception;
    
    /**
     * 查询最大密码数
     * @return
     * @throws Exception
     */
    Config selectMaxPassword() throws Exception;
    
    
    /**
     * 查询全部配置
     * @return
     * @throws Exception
     */
    List<Config> selectAllConfigs() throws Exception;
}
