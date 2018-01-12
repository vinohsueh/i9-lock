    package org.i9.lock.platform.dao.vo;

import java.io.Serializable;

/** 
 * 创建时间：2017年11月22日 下午4:13:49
 * @author  jz 
 * @version  
 * 
 */
public class LockSearchDto extends PageListDto implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3438464612849505923L;

	private Long userId;
	
    /**
     * 自定义名称
     */
    private String name;
    
    /**
     * 
     */
    private String keyUser;
    
    /**
     * 锁号
     */
    private String keyNumber;
    
    private String phone;
    
    private String mac;
    
    private String deviceName;
    
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    private String orderByClause;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyUser() {
		return keyUser;
	}

	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}

	public String getKeyNumber() {
		return keyNumber;
	}

	public void setKeyNumber(String keyNumber) {
		this.keyNumber = keyNumber;
	}

	public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    
}
