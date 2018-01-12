package org.i9.lock.platform.service.impl;

import java.util.List;

import org.i9.lock.platform.dao.ConfigDao;
import org.i9.lock.platform.model.Config;
import org.i9.lock.platform.service.ConfigService;
import org.i9.lock.platform.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 创建时间：2018年1月3日 上午11:03:05
 * @author  lby
 * @version  
 * 
 */
@Service
public class ConfigServiceImpl implements ConfigService{

    @Autowired
    private ConfigDao configDao;
    
    @Override
    public void updateConfig(Config config) throws BusinessException {
        try {
            configDao.updateConfig(config);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Config selectMaxHirer() throws BusinessException {
        try {
            return configDao.selectMaxHirer();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Config selectMaxPassword() throws BusinessException {
        try {
            return configDao.selectMaxPassword();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Config> selectAllConfigs() throws BusinessException {
        try {
            return configDao.selectAllConfigs();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
