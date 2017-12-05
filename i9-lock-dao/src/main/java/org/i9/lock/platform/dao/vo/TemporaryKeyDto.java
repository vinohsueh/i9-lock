package org.i9.lock.platform.dao.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 创建时间：2017年12月4日 上午10:25:30
 * @author  lby
 * @version  
 * 
 */
public class TemporaryKeyDto {
    @NotBlank(message="申请码不能为空") 
    @Pattern(regexp="^[0-9]{6}$",message="密码请输入6个数字的申请码") 
    private String applyPwd;
    
    /**
     * 锁id
     */
    private Long lockId;
    
    /**
     * 锁产生的随机数
     */
    private byte[] randomNumber;
    
    
    
    public byte[] getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(byte[] randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getApplyPwd() {
        return applyPwd;
    }

    public void setApplyPwd(String applyPwd) {
        this.applyPwd = applyPwd;
    }

    public Long getLockId() {
        return lockId;
    }

    public void setLockId(Long lockId) {
        this.lockId = lockId;
    }
    
    
    
}
