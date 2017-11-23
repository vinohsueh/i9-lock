package org.i9.lock.platform.model;

public class Lock {
    private Long id;
    
    /**
     *  固定密钥
     */
    private Long keyDev;
    
    /**
     * 房东id
     */
    private Long userId;
    
    /**
     * 自定义名称
     */
    private String name;
    
    /**
     * 电量
     */
    private Byte battery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKeyDev() {
        return keyDev;
    }

    public void setKeyDev(Long keyDev) {
        this.keyDev = keyDev;
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

    public Byte getBattery() {
        return battery;
    }

    public void setBattery(Byte battery) {
        this.battery = battery;
    }
}