package org.i9.lock.platform.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.i9.lock.platform.model.User;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
* 创建时间：2017年11月6日 下午3:05:03
* @author  lby
* @version  
* 
*/

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String url = request.getRequestURL().toString();
        if (!url.endsWith("login") && !url.endsWith("regist")) {
            if (user == null) {
                throw new BusinessException(ErrorCode.USER_NOT_LOGIN, "用户未登录");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }
    
} 
