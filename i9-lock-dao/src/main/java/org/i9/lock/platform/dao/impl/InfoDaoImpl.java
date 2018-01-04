package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.InfoDao;
import org.i9.lock.platform.dao.mapper.InfoMapper;
import org.i9.lock.platform.dao.vo.InfoSearchDto;
import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * 创建时间：2017年12月25日 下午2:05:21
 * @author  lby
 * @version  
 * 
 */
@Repository
public class InfoDaoImpl implements InfoDao{

    @Autowired
    private InfoMapper infoMapper;
    
    @Override
    public void addInfo(Info info) throws Exception {
        infoMapper.insertSelective(info);
    }

    @Override
    public void updateInfo(Info info) throws Exception {
        infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public void deleteInfo(Integer id) throws Exception {
        infoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Info getInfoById(Integer id) throws Exception {
        return infoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBounds<Info> selectByLimitPage(InfoSearchDto example,
            int currectPage, int pageSize) throws Exception {
        final int totalSize = infoMapper.countByExample(example);
        PageBounds<Info> pageBounds = new PageBounds<Info>(currectPage, totalSize, pageSize);
        List<Info> list = infoMapper.selectByLimitPage(example, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

}
