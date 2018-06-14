package org.i9.lock.platform.model;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户实体类
 * 
 * 
 * @author lby
 *
 * @create 2017年12月26日
 *
 */
public class User {
    private Long id;
    
    /**
     * 用户名  
     */
    private String username;
    
    /**
     * 名字
     */
    private String name;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空") 
    @Size(min = 5, max = 11, message = "请输入正确密码格式(5-11位)")
    private String password;
    
    /**
     * 电话
     */
    @NotBlank(message = "电话号码不能为空") 
    @Pattern(regexp = "^1[3|4|5|6|7|8][0-9]\\d{8}$", message = "请输入正确的手机号")
    private String phone;
    
    /**
     * 亲情号
     */
    private String familyPhone;
    
    /**
     * 创建日期
     */
    private Date createTime;
    
    /**
     * 修改亲情号时间
     */
    private Date modifyFamilyPhoneTime;
    
    /**
     * 用户类型 0:房东  1:房客
     */
    private Short userFlag;
    
    /**
     * 头像地址
     */
    private String headPicture ="1111.jpg";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone == null ? null : familyPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyFamilyPhoneTime() {
        return modifyFamilyPhoneTime;
    }

    public void setModifyFamilyPhoneTime(Date modifyFamilyPhoneTime) {
        this.modifyFamilyPhoneTime = modifyFamilyPhoneTime;
    }

    public Short getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Short userFlag) {
        this.userFlag = userFlag;
    }

	public String getHeadPicture() {
		return headPicture;
	}

	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
    
    
}