package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.ConfigDao;
import org.i9.lock.platform.dao.mapper.ConfigMapper;
import org.i9.lock.platform.model.Config;
import org.i9.lock.platform.model.ConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * 创建时间：2018年1月3日 上午10:22:43
 * @author  lby
 * @version  
 * 
 */
@Repository
public class ConfigDaoImpl implements ConfigDao{
    private static final String MAX_HIRER = "maxHirer";
    
    private static final String MAX_PASSWORD = "maxPassword";
    
    @Autowired
    private ConfigMapper configMapper;
    
    @Override
    public void updateConfig(Config config) throws Exception {
        configMapper.updateByPrimaryKeySelective(config);
    }

    @Override
    public Config selectMaxHirer() throws Exception {
        ConfigExample example = new ConfigExample();
        example.createCriteria().andConfigKeyEqualTo(MAX_HIRER);
        List<Config> list = configMapper.selectByExample(example);
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Config selectMaxPassword() throws Exception {
        ConfigExample example = new ConfigExample();
        example.createCriteria().andConfigKeyEqualTo(MAX_PASSWORD);
        List<Config> list = configMapper.selectByExample(example);
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Config> selectAllConfigs() throws Exception {
        ConfigExample example = new ConfigExample();
        List<Config> list = configMapper.selectByExample(example);
        return list;
    }

}
