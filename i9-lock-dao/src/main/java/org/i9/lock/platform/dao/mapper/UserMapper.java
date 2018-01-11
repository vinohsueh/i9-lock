package org.i9.lock.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.dao.vo.UserSearchDto;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.model.UserExample;

public interface UserMapper {

    int countByExample(@Param("example") UserSearchDto userSearchDto);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(List<Long> ids);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByLimitPage(@Param("example") UserSearchDto userSearchDto, @Param("offset") int offset, @Param("limit") int pageSize);

}