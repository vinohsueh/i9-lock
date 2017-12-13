package org.i9.lock.platform.model;

import java.util.Date;

public class Lock {
    private Long id;
    
    /**
     *  密钥
     */
    private String keyAdmin;
    
    /**
     * 是否有效 1：有效   0：无效
     */
    private Byte effective;
    
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
    
    /**
     * 电表数
     */
    private Double eleNumber;
    
    /**
     * 电费
     */
    private Double elePrice;
    
    /**
     * 燃气数
     */
    private Double gasNumber;
    
    /**
     * 燃气价格
     */
    private Double gasPrice;
    
    /**
     * 水表数
     */
    private Double waterNumber;
    
    /**
     * 水费
     */
    private Double waterPrice;
    
    /**
     * 房客安全模式
     */
    private Byte safeMode;
    
    /**
     * 是否合租
     */
    private Byte ifShared;
    
    /**
     * 报警时长
     */
    private Integer alertMinute;
    
    /**
     * 
     */
    private String keyUser;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 锁号
     */
    private String keyNumber;

    private String keyDev;
    
    
    private byte receiveFlag;
    
    public byte getReceiveFlag() {
        return receiveFlag;
    }

    public void setReceiveFlag(byte receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public String getKeyDev() {
        return keyDev;
    }

    public void setKeyDev(String keyDev) {
        this.keyDev = keyDev;
    }

    public String getKeyNumber() {
        return keyNumber;
    }

    public void setKeyNumber(String keyNumber) {
        this.keyNumber = keyNumber;
    }

    public Byte getIfShared() {
        return ifShared;
    }

    public void setIfShared(Byte ifShared) {
        this.ifShared = ifShared;
    }

    public Integer getAlertMinute() {
        return alertMinute;
    }

    public void setAlertMinute(Integer alertMinute) {
        this.alertMinute = alertMinute;
    }

    public Double getEleNumber() {
        return eleNumber;
    }

    public void setEleNumber(Double eleNumber) {
        this.eleNumber = eleNumber;
    }

    public Double getElePrice() {
        return elePrice;
    }

    public void setElePrice(Double elePrice) {
        this.elePrice = elePrice;
    }

    public Double getGasNumber() {
        return gasNumber;
    }

    public void setGasNumber(Double gasNumber) {
        this.gasNumber = gasNumber;
    }

    
    
    public String getKeyAdmin() {
        return keyAdmin;
    }

    public void setKeyAdmin(String keyAdmin) {
        this.keyAdmin = keyAdmin;
    }

    public Byte getEffective() {
        return effective;
    }

    public void setEffective(Byte effective) {
        this.effective = effective;
    }

    public Double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(Double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public Double getWaterNumber() {
        return waterNumber;
    }

    public void setWaterNumber(Double waterNumber) {
        this.waterNumber = waterNumber;
    }

    public Double getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(Double waterPrice) {
        this.waterPrice = waterPrice;
    }

    public Byte getSafeMode() {
        return safeMode;
    }

    public void setSafeMode(Byte safeMode) {
        this.safeMode = safeMode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getKeyUser() {
        return keyUser;
    }

    public void setKeyUser(String keyUser) {
        this.keyUser = keyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
}