package org.i9.lock.platform.service;

import org.i9.lock.platform.model.ErrorLog;
import org.i9.lock.platform.utils.BusinessException;

/**
 * 锁错误日志
* @ClassName: ErrorLogService
* @author xph
* @date 2018年11月23日
 */
public interface ErrorLogService {
    
    /**
     * 新增错误日志
    * @Title: insertErrorlog
    * @param @param errorLog
    * @param @throws BusinessException
     */
    void insertErrorlog(ErrorLog errorLog) throws BusinessException;
    
    /**
     * 根据lockid和orderNumber查询
    * @Title: selectErrorlogBylockIdAndOrderNumber
    * @param @param lockId
    * @param @param orderNumber
    * @param @throws BusinessException
     * @return 
     */
    ErrorLog selectErrorlogBylockIdAndOrderNumber(Integer lockId, Integer orderNumber)throws BusinessException;
    
    /**
     * 根据lockid和orderNumber删除
    * @Title: selectErrorlogBylockIdAndOrderNumber
    * @param @param lockId
    * @param @param orderNumber
    * @param @throws BusinessException
     * @return 
     */
    void deleteErrorlogBylockIdAndOrderNumber(Integer lockId, Integer orderNumber)throws BusinessException;
    
    /**
     * 更新
    * @Title: updateErrorlog
    * @param @param errorLog
    * @param @throws BusinessException
     */
    void updateErrorlog(ErrorLog errorLog)throws BusinessException;
    
    /**
     * 查询数量
    * @Title: selectCountBylockIdAndOrderNumber
    * @param @param lockId
    * @param @param orderNumber
    * @param @return
    * @param @throws BusinessException
     */
    int selectCountBylockIdAndOrderNumber(Integer lockId, Integer orderNumber)throws BusinessException;
    
}
