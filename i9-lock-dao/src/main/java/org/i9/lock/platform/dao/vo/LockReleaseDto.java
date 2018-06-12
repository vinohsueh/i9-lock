package org.i9.lock.platform.dao.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 创建时间：2017年12月5日 上午10:23:59
 * @author  lby
 * @version  
 * 
 */
public class LockReleaseDto {
    
    @NotBlank(message="电话号码不能为空")
    @Pattern(regexp="^1[3|4|5|6|7|8][0-9]\\d{8}$",message="请输入正确的手机号")
    private String phone;
    
    @NotBlank(message="密码不能为空")
    private String password;
    
    @NotBlank(message="锁具码不能为空") 
    @Pattern(regexp="^[0-9]{8}$",message="锁具码为8个数字")
    private String keyAdmin;
    
    /**
     * 解绑的锁id
     */
    @NotNull(message="锁id不能为空") 
    private Long lockId;
    
    public Long getLockId() {
        return lockId;
    }

    public void setLockId(Long lockId) {
        this.lockId = lockId;
    }

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

    public String getKeyAdmin() {
        return keyAdmin;
    }

    public void setKeyAdmin(String keyAdmin) {
        this.keyAdmin = keyAdmin;
    }
    
    
    
}
