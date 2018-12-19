package org.i9.lock.platform.dao.impl;

import org.i9.lock.platform.dao.ErrorLogDao;
import org.i9.lock.platform.dao.mapper.ErrorLogMapper;
import org.i9.lock.platform.model.ErrorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ErrorLogDaoImpl implements ErrorLogDao {

    @Autowired
    private ErrorLogMapper errorLogMapper;
    
    @Override
    public void insertErrorlog(ErrorLog errorLog) throws Exception {
        errorLogMapper.insert(errorLog);
    }

    @Override
    public ErrorLog selectErrorlogBylockIdAndOrderNumber(Integer lockId, Integer orderNumber) throws Exception {
       return  errorLogMapper.selectErrorlogBylockIdAndOrderNumber(lockId,orderNumber);
    }

    @Override
    public void deleteErrorlogBylockIdAndOrderNumber(Integer lockId, Integer orderNumber) throws Exception {
        errorLogMapper.deleteErrorlogBylockIdAndOrderNumber(lockId,orderNumber);
    }

    @Override
    public void updateErrorlog(ErrorLog errorLog) throws Exception {
        errorLogMapper.updateErrorlog(errorLog);
    }

    @Override
    public int selectCountBylockIdAndOrderNumber(Integer lockId, Integer orderNumber) throws Exception {
        return errorLogMapper.selectCountBylockIdAndOrderNumber(lockId,orderNumber);
    }

}
