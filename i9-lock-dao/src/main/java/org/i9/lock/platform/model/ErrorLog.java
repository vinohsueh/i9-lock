package org.i9.lock.platform.model;

public class ErrorLog {
    
    /**
     * 锁id
     */
    private Integer lockId;
    
    /**
     * 组编号
     */
    private Integer orderNumber;
    
    /**
     * 0:正常 1:异常
     */
    private Integer iferror;

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getIferror() {
        return iferror;
    }

    public void setIferror(Integer iferror) {
        this.iferror = iferror;
    }
}