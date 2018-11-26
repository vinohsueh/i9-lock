package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import org.i9.lock.platform.model.ErrorLog;
import org.i9.lock.platform.service.ErrorLogService;
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
        int iferror = errorLogService.selectErrorlogBylockIdAndOrderNumber(lockId,orderNumber);
        result.put("iferror",iferror);
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
