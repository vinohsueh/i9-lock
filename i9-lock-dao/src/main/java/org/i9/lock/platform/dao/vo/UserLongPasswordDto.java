package org.i9.lock.platform.dao.vo;

/**
 * 获取密码锁
* @ClassName: UserLongPassword
* @author lenovo
* @date 2018年10月16日
 */
public class UserLongPasswordDto {
	
	private Long lockId;
	
	private Long userId;
	
	private String userPassword;
	
	private String battery;

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
