package org.i9.lock.platform.utils;

public class ErrorCode {
    
    /**
     * 未知错误
     */
    public static final int UNKNOWN_ERROR = -99999;
    /**
     * 数据认证错误
     */
    public static final Object BINDING_RESULT_ERROR = -99998;
    
    /**
     * 用户未登录
     */
    public static final int USER_NOT_LOGIN = 10005;
    
    /**
     * 登录错误
     */
    public static final int LOGIN_ERROR = 10006;
    
    /**
     * 增删改查失败
     */
    public static final int CRUD_ERROR = 10007;
    
    /**
     * 修改亲情号时间错误
     */
    public static final int UNABLE_MODIFY = 10008;
    
    /**
     * 移交锁具失败
     */
    public static final int RELEASE_LOCK_ERROR = 10009;
    
    /**
     * 接收数据错误
     */
    public static final int RECEIVE_DATA_ERROR = 10010;
    
}
