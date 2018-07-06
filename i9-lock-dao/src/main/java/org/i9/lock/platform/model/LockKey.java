package org.i9.lock.platform.model;

import java.math.BigDecimal;
import java.util.Date;

import org.i9.lock.platform.utils.StringUtil;

/**
 * 钥匙实体类
 * 
 * 
 * @author lby
 *
 * @create 2017年12月26日
 *
 */
public class LockKey {
    private Integer id;
    
    /**
     * 锁id
     */
    private Long lockId;
    
    private Lock lock;
    
    /**
     * 租户姓名
     */
    private String name;
    
    /**
     * 租户电话
     */
    private String hirerPhone;
    
    /**
     * 开门密码
     */
    private String password;
    
    /**
     * 出租类型(月日时) 日0  月1 时2
     */
    private Byte hireType;
    
    /**
     * 租金
     */
    private BigDecimal hirePrice;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
    
    /**
     * 钥匙类型 0:租户钥匙   1:临时钥匙
     */
    private Byte type;
    
    /**
     * 用户组编号
     */
    private Integer orderNumber;
    
    /**
     * 租户(用户)编号
     */
    private Long userId;
    
    private User user;
    /**
     * 领取标记 0未领取   1领取
     */
    private Byte receiveFlag;
    
    /**
     * 领取时间
     */
    private Date receiveTime;
    
    /**
     * 
     */
    private Date createTime;
    
    /**
     * 电表数
     */
    private Double eleNumber;
    
    /**
     * 燃气数
     */
    private Double gasNumber;
    
    /**
     * 水表数
     */
    private Double waterNumber;
    
    private Integer state;
    
    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Double getEleNumber() {
		return eleNumber;
	}

	public void setEleNumber(Double eleNumber) {
		this.eleNumber = eleNumber;
	}

	public Double getGasNumber() {
		return gasNumber;
	}

	public void setGasNumber(Double gasNumber) {
		this.gasNumber = gasNumber;
	}

	public Double getWaterNumber() {
		return waterNumber;
	}

	public void setWaterNumber(Double waterNumber) {
		this.waterNumber = waterNumber;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Byte getReceiveFlag() {
        return receiveFlag;
    }

    public void setReceiveFlag(Byte receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

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

    public String getHirerPhone() {
        return hirerPhone;
    }

    public void setHirerPhone(String hirerPhone) {
        this.hirerPhone = hirerPhone == null ? null : hirerPhone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getHireType() {
        return hireType;
    }

    public void setHireType(Byte hireType) {
        this.hireType = hireType;
    }

    public BigDecimal getHirePrice() {
        return hirePrice;
    }

    public void setHirePrice(BigDecimal hirePrice) {
        this.hirePrice = hirePrice;
    }

    public Date getStartTime() {
        return startTime;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
    
    public String getReceiveTimeString(){
        return StringUtil.dateToStringWithoutTime(receiveTime);
    }
}