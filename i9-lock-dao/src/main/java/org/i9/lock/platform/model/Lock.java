package org.i9.lock.platform.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 锁实体类
 * 
 * 
 * @author lby
 *
 * @create 2017年12月26日
 *
 */
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
    private String battery;
    
    /**
     * 电费单价
     */
    private BigDecimal elePrice;
    
    /**
     * 燃气价格单价
     */
    private BigDecimal gasPrice;
    
    /**
     * 水费单价
     */
    private BigDecimal waterPrice;
    
    /**
     * 物业费
     */
    private BigDecimal propertyPrice;
    
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
    
    /**
     * 其他备注
     */
    private String remark;
    
    /**
     * 设备名称
     */
    private String deviceName;
    
    /**
     * mac地址
     */
    private String mac;
    
    
    private Date startTime;
    
    private Date endTime;
    
    private Byte hireType; 
    
    private byte receiveFlag;
    
    private User user;
    
    
    
    public Byte getHireType() {
        return hireType;
    }

    public void setHireType(Byte hireType) {
        this.hireType = hireType;
    }

    /**
     * 钥匙
     */
    private List<LockKey> keys;
    
    
    public List<LockKey> getKeys() {
        return keys;
    }

    public void setKeys(List<LockKey> keys) {
        this.keys = keys;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

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

    public BigDecimal getElePrice() {
        return elePrice;
    }

    public void setElePrice(BigDecimal elePrice) {
        this.elePrice = elePrice;
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

    public BigDecimal getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(BigDecimal gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigDecimal getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(BigDecimal waterPrice) {
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

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

	public BigDecimal getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(BigDecimal propertyPrice) {
		this.propertyPrice = propertyPrice;
	}
    
}