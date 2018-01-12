package org.i9.lock.platform.dao.vo;

import java.io.Serializable;

/** 
 * 创建时间：2017年11月6日 上午10:43:30
 * @author  lby
 * @version  
 * 
 */
public class PasswordSearchDto extends PageListDto implements Serializable{
    
    /**
     * <code>serialVersionUID</code> - 
     */
    private static final long serialVersionUID = 144890267006805792L;

    /*
     * 密码自定义名称
     * */
    private String name;
    
    /*
     * 锁号
     * */
    private String lockNumber;
    
    /*
     * 锁自定义名称
     * */
    private String lockName;
    
    /*
     * 用户名称
     * */
    private String userName;
    
    /*
     * 用户手机号
     * */
    private String userPhone;
    
    private String orderByClause;
    
    

    
    public String getOrderByClause() {
        return orderByClause;
    }


    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the lockName
     */
    public String getLockName() {
        return lockName;
    }


    /**
     * @param lockName the lockName to set
     */
    public void setLockName(String lockName) {
        this.lockName = lockName;
    }


    /**
     * @return the lockNumber
     */
    public String getLockNumber() {
        return lockNumber;
    }


    /**
     * @param lockNumber the lockNumber to set
     */
    public void setLockNumber(String lockNumber) {
        this.lockNumber = lockNumber;
    }


    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }


    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * @return the userPhone
     */
    public String getUserPhone() {
        return userPhone;
    }


    /**
     * @param userPhone the userPhone to set
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }


   
    
    
}
