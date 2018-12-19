package org.i9.lock.platform.dao.vo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 创建时间：2017年12月18日 下午1:49:55
 * @author  lby
 * @version  
 * 
 */
public class PwdDto {
    
    @NotBlank(message = "密码不能为空") 
    @Size(min = 5, max = 11, message = "请输入正确密码格式(5-11位)")
    private String password;
    
    @NotBlank(message = "确认密码不能为空") 
    @Size(min = 5, max = 11, message = "请输入正确密码格式(5-11位)")
    private String confirmPwd;
    
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3|4|5|6|7|8][0-9]\\d{8}$", message = "请输入正确的手机号")
    private String phone;
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    
    
}
