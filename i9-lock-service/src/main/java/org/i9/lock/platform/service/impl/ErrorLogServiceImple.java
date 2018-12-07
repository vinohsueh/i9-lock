package org.i9.lock.platform.service.impl;

import org.i9.lock.platform.dao.ErrorLogDao;
import org.i9.lock.platform.model.ErrorLog;
import org.i9.lock.platform.service.ErrorLogService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ErrorLogServiceImple implements ErrorLogService {
    
    @Autowired
    private ErrorLogDao errorLogDao;
    
    @Override
    public void insertErrorlog(ErrorLog errorLog) throws BusinessException {
        try {
            errorLogDao.insertErrorlog(errorLog);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"新增错误日志失败",e.getMessage());
        }
    }

    @Override
    public ErrorLog selectErrorlogBylockIdAndOrderNumber(Integer lockId, Integer orderNumber) throws BusinessException {
        if(null ==lockId ||  null ==orderNumber) {
            throw new BusinessException("参数为空！");
        }
        try {
            return errorLogDao.selectErrorlogBylockIdAndOrderNumber(lockId,orderNumber);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"查询错误日志失败",e.getMessage());
        }
    }

    @Override
    public void deleteErrorlogBylockIdAndOrderNumber(Integer lockId, Integer orderNumber) throws BusinessException {
        if(null ==lockId ||  null ==orderNumber) {
            throw new BusinessException("参数为空！");
        }
        try {
             errorLogDao.deleteErrorlogBylockIdAndOrderNumber(lockId,orderNumber);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"查询错误日志失败",e.getMessage());
        }        
    }

    @Override
    public void updateErrorlog(ErrorLog errorLog) throws BusinessException {
        try {
            errorLogDao.updateErrorlog(errorLog);
       } catch (Exception e) {
           throw new BusinessException(ErrorCode.CRUD_ERROR,"更新错误日志失败",e.getMessage());
       }
    }

    @Override
    public int selectCountBylockIdAndOrderNumber(Integer lockId, Integer orderNumber) throws BusinessException {
        if(null ==lockId ||  null ==orderNumber) {
            throw new BusinessException("参数为空！");
        }
        try {
            return errorLogDao.selectCountBylockIdAndOrderNumber(lockId,orderNumber);
       } catch (Exception e) {
           throw new BusinessException(ErrorCode.CRUD_ERROR,"查询数量失败",e.getMessage());
       }
    }

}
