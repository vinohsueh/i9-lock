package org.i9.lock.platform.dao.vo;

import org.hibernate.validator.constraints.NotBlank;

public class LockUpdateDto {
	private Long id;
	
	 /**
     *  密钥
     */
    @NotBlank(message="keyAdmin不能为空")
    private String keyAdmin;
    
    /**
     * 锁号
     */
    @NotBlank(message="keyNumber不能为空")
    private String keyNumber;
    
    @NotBlank(message="keyDev不能为空")
    private String keyDev;
    
    /**
     * 电量
     */
    private String battery;
    
    /**
     * 设备名称
     */
    private String deviceName;
    
    /**
     * mac地址
     */
    private String mac;
    
    /**
     * 是否显示 0:显示 1:隐藏
     */
    private Integer showType;
    
    /**
     * 
     */
    @NotBlank(message="keyUser不能为空")
    private String keyUser;
    

	public String getKeyUser() {
		return keyUser;
	}

	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyAdmin() {
		return keyAdmin;
	}

	public void setKeyAdmin(String keyAdmin) {
		this.keyAdmin = keyAdmin;
	}

	public String getKeyNumber() {
		return keyNumber;
	}

	public void setKeyNumber(String keyNumber) {
		this.keyNumber = keyNumber;
	}

	public String getKeyDev() {
		return keyDev;
	}

	public void setKeyDev(String keyDev) {
		this.keyDev = keyDev;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
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

	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}
    
    
    
}
