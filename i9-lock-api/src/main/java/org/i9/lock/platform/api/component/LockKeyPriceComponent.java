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
        jsonObject.put("endTime", StringUtil.dateToStringByRep(lockKey.getEndTime(), "yyyy/MM/dd"));
        return jsonObject;
    }
}
