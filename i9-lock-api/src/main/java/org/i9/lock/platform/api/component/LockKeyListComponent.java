package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.LockKey;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年12月6日 下午3:37:58
 * @author  lby
 * @version  
 * 
 */
public class LockKeyListComponent {
    private LockKey lockKey;
    
    public LockKeyListComponent setLockKey(LockKey lockKey) {
        this.lockKey = lockKey;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lockKey.getId());
        jsonObject.put("receiveTime", lockKey.getReceiveTimeString());
        jsonObject.put("receiveFlag", lockKey.getReceiveFlag()==0?"未领取":"已领取");
        if (lockKey.getUser() != null) {
            jsonObject.put("username", lockKey.getUser().getUsername());
        }
        return jsonObject;
    }
}
