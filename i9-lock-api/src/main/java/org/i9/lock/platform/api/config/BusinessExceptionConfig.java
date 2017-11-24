package org.i9.lock.platform.api.config;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.i9.lock.platform.utils.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * 创建时间：2017年11月6日 下午2:52:37
 * @author  lby
 * @version  
 * 
 */
@ControllerAdvice
@ResponseBody
public class BusinessExceptionConfig {
    
    @ExceptionHandler(BusinessException.class)
    public Object exceptionHandler(BusinessException e, HttpServletResponse response) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);
        result.put("errorMsg", e.getErrorMessage());
        result.put("result", "");
        return result;
    }
}
