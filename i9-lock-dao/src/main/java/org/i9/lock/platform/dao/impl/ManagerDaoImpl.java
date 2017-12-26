package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.ManagerDao;
import org.i9.lock.platform.dao.mapper.ManagerMapper;
import org.i9.lock.platform.model.Manager;
import org.i9.lock.platform.model.ManagerExample;
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
public class ManagerDaoImpl implements ManagerDao{

    @Autowired
    private ManagerMapper managerMapper;
    
    @Override
    public void addManager(Manager manager) throws Exception {
        managerMapper.insertSelective(manager);
    }

    @Override
    public void updateManager(Manager manager) throws Exception {
        managerMapper.updateByPrimaryKeySelective(manager);
    }

    @Override
    public void deleteManager(Integer id) throws Exception {
        managerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Manager getManagerById(Integer id) throws Exception {
        return managerMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBounds<Manager> selectByLimitPage(ManagerExample example,
            int currectPage, int pageSize) throws Exception {
        final int totalSize = managerMapper.countByExample(example);
        PageBounds<Manager> pageBounds = new PageBounds<Manager>(currectPage, totalSize, pageSize);
        List<Manager> list = managerMapper.selectByLimitPage(example, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

    @Override
    public Manager findManagerByName(String currentLoginName) throws Exception {
        ManagerExample example = new ManagerExample();
        example.createCriteria().andUsenameEqualTo(currentLoginName);
        List<Manager> list = managerMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
