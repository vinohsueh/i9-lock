package org.i9.lock.platform.model;

import javax.validation.constraints.NotNull;

public class Password {
    /**
     * 
     */
    private Integer id;
    
    /**
     * 锁id
     */
    @NotNull(message="锁号不能为空")
    private Long lockId;
    
    /**
     * 用户id
     */
    private Long userId;
    
    /**
     * 自定义名称
     */
    private String name;
    
    /**
     * 密码类型 0:密码  1:指纹 2:密码加指纹
     */
    private Byte type;
    
    /**
     * 密码序号
     */
    @NotNull(message="密码序号不能为空")
    private Integer orderNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getLockId() {
        return lockId;
    }

    public void setLockId(Long lockId) {
        this.lockId = lockId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}