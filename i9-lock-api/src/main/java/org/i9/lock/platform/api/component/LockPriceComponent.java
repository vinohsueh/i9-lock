package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.Lock;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年11月24日 上午8:27:31
 * @author  lby
 * @version  
 * 
 */
public class LockPriceComponent {
    
    private Lock lock;
    
    public LockPriceComponent setLock(Lock lock){
        this.lock = lock;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("name", lock.getName());
        jsonObject.put("battery", lock.getBattery());
 //       jsonObject.put("eleNumber", lock.getEleNumber());
        jsonObject.put("elePrice", lock.getElePrice());
 //       jsonObject.put("gasNumber", lock.getGasNumber());
        jsonObject.put("gasPrice", lock.getGasPrice());
//        jsonObject.put("waterNumber", lock.getWaterNumber());
        jsonObject.put("waterPrice", lock.getWaterPrice());
        jsonObject.put("remark", lock.getRemark());
        jsonObject.put("cusNumber",lock.getCusNumber() );
        jsonObject.put("nameAndNumber", lock.getNameAndNumber()); 
        jsonObject.put("propertyPrice", lock.getPropertyPrice()); 
        return jsonObject;
    }
    
    public JSONObject build2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("battery", lock.getBattery());
        return jsonObject;
    }
    
}
