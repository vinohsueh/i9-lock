package org.i9.lock.platform.dao.vo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.utils.BusinessException;

/** 
 * 创建时间：2017年11月29日 下午4:23:41
 * @author  lby
 * @version  
 * 
 */
public class LockKeyDto {
    
    /**
     * 锁id
     */
    private Long lockId;
    
    /**
     * 租户电话
     */
    @NotBlank(message="电话号码不能为空")
    @Pattern(regexp="^1[3|4|5|7|8][0-9]\\d{8}$",message="请输入正确的手机号")
    private String hirerPhone;
    
    /**
     * 开门密码
     */
    @NotBlank(message="密码不能为空")
    @Pattern(regexp="^[0-9]{9}$",message="密码请输入9个数字")
    private String password;
    
    /**
     * 出租类型(月日时) 日0  月1 时2
     */
    private Byte hireType;
    
    /**
     * 租金
     */
    @DecimalMin(value="0",message="请输入正确的金额")
    @Digits(fraction=2, integer = 12,message="小数不能超过两位，整数不能超过12位")
    @NotNull(message="租金不能为空")
    private BigDecimal hirePrice;

    /**
     * 开始时间
     */
    private Date startTime;
    
    @NotNull(message="开始时间不能为空")
    private String startTimeString;
    
    /**
     * 结束时间
     */
    
    private Date endTime;
    
    @NotNull(message="结束时间不能为空")
    private String endTimeString;
    
    /**
     * 钥匙类型 0:租户钥匙   1:临时钥匙
     */
    private Byte type;
    
    /**
     * 是否合租
     */
    private byte ifShare;
    
    /**
     * 是否开启安全模式
     */
    private byte safeMode;
    
    @NotBlank(message="确认密码不能为空")
    @Pattern(regexp="^[0-9]{9}$",message="密码请输入9个数字")
    private String confirmPwd;
    

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }


    public byte getIfShare() {
        return ifShare;
    }

    public void setIfShare(byte ifShare) {
        this.ifShare = ifShare;
    }

    public byte getSafeMode() {
        return safeMode;
    }

    public void setSafeMode(byte safeMode) {
        this.safeMode = safeMode;
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
        this.hirerPhone = hirerPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    public LockKey getLockKey() {
        LockKey lockKey = new LockKey();
        lockKey.setHirePrice(hirePrice);
        lockKey.setHirerPhone(hirerPhone);
        lockKey.setHireType(hireType);
        lockKey.setLockId(lockId);
        lockKey.setPassword(password);
        lockKey.setType(type);
        SimpleDateFormat sdf = null;
        try {
            if (hireType == 2) {
                sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                lockKey.setStartTime(sdf.parse(startTimeString));
                lockKey.setEndTime(sdf.parse(endTimeString));
            }else{
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                lockKey.setStartTime(sdf.parse(startTimeString));
                lockKey.setEndTime(sdf.parse(endTimeString));
            }
        } catch (ParseException e) {
            throw new BusinessException("时间格式错误！");
        }
        return lockKey;
    }

    
}
