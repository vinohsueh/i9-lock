package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.Lock;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年11月24日 上午8:27:31
 * @author  lby
 * @version  
 * 
 */
public class LockListInfoComponent {
    
    private Lock lock;
    
    public LockListInfoComponent setLock(Lock lock){
        this.lock = lock;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("name", lock.getName());
        jsonObject.put("battery", lock.getBattery());
        jsonObject.put("keyUser", lock.getKeyUser());
        jsonObject.put("receiveFlag", lock.getReceiveFlag());
        return jsonObject;
    }
}
