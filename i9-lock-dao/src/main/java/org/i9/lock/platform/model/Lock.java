package org.i9.lock.platform.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.i9.lock.platform.utils.DateUtils;

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
    @NotBlank(message="keyAdmin不能为空")
    private String keyAdmin;
    
    /**
     *  修改keyAdmin时间
     */
    private Date updateKeyDate;
    
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
    @NotBlank(message="名字不能为空") 
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
    @NotBlank(message="keyUser不能为空")
    private String keyUser;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 锁号
     */
    @NotBlank(message="keyNumber不能为空")
    private String keyNumber;

    @NotBlank(message="keyDev不能为空")
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
    
    /**
     * 公寓类型(1.出租公寓  2. 私家公寓)
     */
    private Integer departmentType;
    
    /**
     * 公寓地址
     */
    private String departmentAddress;
    
    /**
     * 公寓门牌号
     */
    private String departmentNumber;
    
    /**
     * 公寓照片地址
     */
    private String departmentPicture;
    
    /**
     * 租户数量
     */
    private Integer cusNumber;
    
    /**
     * 是否显示 0:显示 1:隐藏
     */
    private Integer showType;
    
    /**
     * 报警时间
     */
    private String warnTime;
    
	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}

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
    /**
     * 双击开锁
     */
    private Integer clickLock;
    
    public Integer getClickLock() {
		return clickLock;
	}

	public void setClickLock(Integer clickLock) {
		this.clickLock = clickLock;
	}

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
	public Integer getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(Integer departmentType) {
		this.departmentType = departmentType;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentPicture() {
		return departmentPicture;
	}

	public void setDepartmentPicture(String departmentPicture) {
		this.departmentPicture = departmentPicture;
	}

	public Integer getCusNumber() {
		return cusNumber;
	}

	public void setCusNumber(Integer cusNumber) {
		this.cusNumber = cusNumber;
	}
    
	public String getNameAndNumber() {
		return name+departmentNumber;
	}

	public Date getUpdateKeyDate() {
		return updateKeyDate;
	}

	public void setUpdateKeyDate(Date updateKeyDate) {
		this.updateKeyDate = updateKeyDate;
	}
	 public String getKeyTimeString() {
	        return DateUtils.dateToString(updateKeyDate);
	    } 
	
}