package org.i9.lock.platform.dao.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.utils.BusinessException;

/** 
 * 创建时间：2017年12月20日 下午4:38:17
 * @author  lby
 * @version  
 * 
 */
public class UpdateTimeDto {
    
    private Integer id;
    
    @NotNull(message="结束时间不能为空")
    private Byte hireType;
    
    @NotBlank(message="开始时间不能为空")
    private String startTimeString;
    
    @NotBlank(message="结束时间不能为空")
    private String endTimeString;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getHireType() {
        return hireType;
    }

    public void setHireType(Byte hireType) {
        this.hireType = hireType;
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
    
    public LockKey getLockKey(){
        LockKey lockKey = new LockKey();
        lockKey.setId(id);
        lockKey.setHireType(hireType);
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
