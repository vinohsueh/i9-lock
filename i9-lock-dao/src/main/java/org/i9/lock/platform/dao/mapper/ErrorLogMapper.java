package org.i9.lock.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.model.ErrorLog;
import org.i9.lock.platform.model.ErrorLogExample;

public interface ErrorLogMapper {
    long countByExample(ErrorLogExample example);

    int deleteByExample(ErrorLogExample example);

    int insert(ErrorLog record);

    int insertSelective(ErrorLog record);

    List<ErrorLog> selectByExample(ErrorLogExample example);

    int updateByExampleSelective(@Param("record") ErrorLog record, @Param("example") ErrorLogExample example);

    int updateByExample(@Param("record") ErrorLog record, @Param("example") ErrorLogExample example);

    int selectErrorlogBylockIdAndOrderNumber(@Param("lockId") Integer lockId,@Param("orderNumber") Integer orderNumber);

    void deleteErrorlogBylockIdAndOrderNumber(@Param("lockId") Integer lockId,@Param("orderNumber") Integer orderNumber);
}