package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.UserDao;
import org.i9.lock.platform.dao.mapper.UserMapper;
import org.i9.lock.platform.dao.vo.UserSearchDto;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.model.UserExample;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/** 
 * 创建时间：2017年11月6日 上午10:45:20
 * @author  lby
 * @version  
 * 
 */
@Repository
public class UserDaoImpl implements UserDao{
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public void addUser(User user) throws Exception {
        userMapper.insertSelective(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(List<Long> ids) throws Exception {
        userMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> findAllUser() throws Exception {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public PageBounds<User> selectByLimitPage(UserSearchDto userSearchDto,
            int currectPage, int pageSize) throws Exception {
        final int totalSize = userMapper.countByExample(userSearchDto);
        PageBounds<User> pageBounds = new PageBounds<User>(currectPage, totalSize, pageSize);
        List<User> list = userMapper.selectByLimitPage(userSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
    }

    @Override
    public User getUserByPhone(String phone) {
        UserExample example = new UserExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<User> list = userMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
}
