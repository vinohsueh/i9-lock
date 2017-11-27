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