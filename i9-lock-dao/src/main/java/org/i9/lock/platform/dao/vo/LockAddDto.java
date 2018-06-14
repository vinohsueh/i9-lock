package org.i9.lock.platform.dao.vo;

import org.hibernate.validator.constraints.NotBlank;
import org.i9.lock.platform.model.Lock;
import org.springframework.beans.BeanUtils;

/** 
 * 创建时间：2017年11月30日 下午2:35:22
 * @author  lby
 * @version  
 * 
 */
public class LockAddDto {
    @NotBlank(message="keyAdmin不能为空")
    private String keyAdmin;
    
    @NotBlank(message="名字不能为空") 
    private String name;
    
    @NotBlank(message="keyNumber不能为空")
    private String keyNumber;
    
    @NotBlank(message="keyDev不能为空")
    private String keyDev;
    
    @NotBlank(message="keyUser不能为空")
    private String keyUser;
    
    private String battery;
    
    private String deviceName; 
    
    private String mac;
    
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

    public String getKeyAdmin() {
        return keyAdmin;
    }

    public void setKeyAdmin(String keyAdmin) {
        this.keyAdmin = keyAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Lock getLock(){
        Lock lock = new Lock();
        BeanUtils.copyProperties(this, lock);
        return lock;
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
    
    
    
}
