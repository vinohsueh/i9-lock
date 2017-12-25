package org.i9.lock.platform.service.impl;

import org.i9.lock.platform.dao.InfoDao;
import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.model.InfoExample;
import org.i9.lock.platform.service.InfoService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 创建时间：2017年12月25日 下午2:08:37
 * @author  lby
 * @version  
 * 
 */
@Service
public class InfoServiceImpl implements InfoService{
    
    @Autowired
    private InfoDao infoDao;
    
    @Override
    public void addInfo(Info info) throws BusinessException {
        try {
            infoDao.addInfo(info);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void updateInfo(Info info) throws BusinessException {
        try {
            infoDao.updateInfo(info);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deleteInfo(Integer id) throws BusinessException {
        try {
            infoDao.deleteInfo(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Info getInfoById(Integer id) throws BusinessException {
        try {
            return infoDao.getInfoById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public PageBounds<Info> selectByLimitPage(InfoExample example,
            int currectPage, int pageSize) throws BusinessException {
        try {
            return infoDao.selectByLimitPage(example, currectPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
