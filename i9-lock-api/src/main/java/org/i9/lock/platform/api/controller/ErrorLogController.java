package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import org.i9.lock.platform.model.ErrorLog;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.ErrorLogService;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 锁异常处理
* @ClassName: ErrorLogController
* @author xph
* @date 2018年11月23日
 */

@Controller
@RequestMapping("/errorLog")
public class ErrorLogController {
    
    @Autowired
    private ErrorLogService errorLogService;
    @Autowired
    private UserService userService;
    @Autowired
    private LockKeyService lockKeyService;
    @Autowired
    private LockService lockService;
    
    /**
     * 新增错误日志
    * @Title: insertErrorlog
    * @param @param errorLog
    * @param @return
     */
    @ResponseBody
    @RequestMapping("/insertErrorlog")
    public HashMap<String, Object> insertErrorlog(ErrorLog errorLog) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        User currentUser = userService.getCurrentUser();
        Lock lock = lockService.getLockById(errorLog.getLockId().longValue());
      //判断是否是房东
        if (lock.getUserId() - currentUser.getId() == 0) {
            errorLog.setOrderNumber(0);
        }else{
            LockKey lockKey = lockKeyService.selectLockKeyByLockIdAndUserId(errorLog.getLockId().longValue(), currentUser.getId());
            errorLog.setOrderNumber(lockKey.getOrderNumber());
        }
        int count = errorLogService.selectCountBylockIdAndOrderNumber(errorLog.getLockId(), errorLog.getOrderNumber());
        if(count >0) {
            errorLogService.updateErrorlog(errorLog);
            return result;
        }
        errorLogService.insertErrorlog(errorLog);
        return result;
    }
    
    /**
     * 根据lockId,orderNumber查询状态
    * @Title: insertErrorlog
    * @param @param errorLog
    * @param @return
     */
    @ResponseBody
    @RequestMapping("/selectErrorlogBylockId")
    public HashMap<String, Object> selectErrorlogBylockId(Integer lockId, Integer orderNumber) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ErrorLog errorLog =errorLogService.selectErrorlogBylockIdAndOrderNumber(lockId,orderNumber);
        if(null ==errorLog) {
            result.put("iferror",0);
            return result;
        }
        result.put("iferror",errorLog.getIferror());
        return result;
    }
    
    /**
     * 根据lockId,orderNumber删除状态
    * @Title: insertErrorlog
    * @param @param errorLog
    * @param @return
     */
    @ResponseBody
    @RequestMapping("/deleteErrorlogBylockId")
    public HashMap<String, Object> deleteErrorlogBylockId(Integer lockId, Integer orderNumber) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        errorLogService.deleteErrorlogBylockIdAndOrderNumber(lockId,orderNumber);
        return result;
    }
}
