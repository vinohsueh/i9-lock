package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.LockLog;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年11月27日 下午2:00:48
 * @author  lby
 * @version  
 * 
 */
public class LockLogInfoComponent {
    private LockLog lockLog;
    
    public LockLogInfoComponent setLockLog(LockLog lockLog){
        this.lockLog = lockLog;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lockLog.getId());
        jsonObject.put("username", lockLog.getUsername());
        jsonObject.put("operation", lockLog.getOperationString());
        jsonObject.put("time", lockLog.getTimeString());
        return jsonObject;
    }
}
