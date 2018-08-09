package org.i9.lock.platform.api.component;

import org.i9.lock.platform.dao.enums.HireTypeEnum;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.utils.StringUtil;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年12月6日 下午3:37:58
 * @author  lby
 * @version  
 * 
 */
public class LockKeyPriceComponent {
    private LockKey lockKey;
    
    public LockKeyPriceComponent setLockKey(LockKey lockKey) {
        this.lockKey = lockKey;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lockKey.getId());
        if (lockKey.getUser() != null) {
            jsonObject.put("username", lockKey.getUser().getUsername());
            jsonObject.put("phone", lockKey.getUser().getPhone());
        }
        jsonObject.put("hireType", HireTypeEnum.getNameById(lockKey.getHireType()));
        jsonObject.put("hirePrice", lockKey.getHirePrice());
        jsonObject.put("eleNumber", lockKey.getEleNumber());
        jsonObject.put("gasNumber", lockKey.getGasNumber());
        jsonObject.put("waterNumber", lockKey.getWaterNumber());
        jsonObject.put("state", lockKey.getState());
        jsonObject.put("rentState", lockKey.getRentState());
        jsonObject.put("name", lockKey.getName());
        jsonObject.put("overTime", StringUtil.dateToStringByRep(lockKey.getOverTime(), "yyyy-MM-dd"));
        if (2 == lockKey.getHireType()){
            jsonObject.put("startTime", StringUtil.dateToStringByRep(lockKey.getStartTime(), "yyyy-MM-dd HH:00:00"));
            jsonObject.put("endTime", StringUtil.dateToStringByRep(lockKey.getEndTime(), "yyyy-MM-dd HH:00:00"));
        }else{
            jsonObject.put("startTime", StringUtil.dateToStringByRep(lockKey.getStartTime(), "yyyy-MM-dd"));
            jsonObject.put("endTime", StringUtil.dateToStringByRep(lockKey.getEndTime(), "yyyy-MM-dd"));
        }
        
        return jsonObject;
    }
}
