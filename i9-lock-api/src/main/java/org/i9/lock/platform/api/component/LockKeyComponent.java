package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.LockKey;

import com.alibaba.fastjson.JSONObject;

public class LockKeyComponent {
	 private LockKey lockKey;
	    
	    public LockKeyComponent setLockKey(LockKey lockKey) {
	        this.lockKey = lockKey;
	        return this;
	    }
	    public JSONObject build() {
	        JSONObject jsonObject = new JSONObject();
//	        jsonObject.put("hirerPhone", lockKey.getHirerPhone());
//	        jsonObject.put("name", lockKey.getName());
	        jsonObject.put("startTime", lockKey.getStartTimeString());
	        jsonObject.put("endTime", lockKey.getEndTimeString());
	        jsonObject.put("orderNumber", lockKey.getOrderNumber());
//	        jsonObject.put("hireType", lockKey.getHireType());
//	        jsonObject.put("eleNumber", lockKey.getEleNumber());
//	        jsonObject.put("gasNumber", lockKey.getGasNumber());
//	        jsonObject.put("waterNumber", lockKey.getWaterNumber());
//	        jsonObject.put("elePrices", lockKey.getLock().getElePrice());
//	        jsonObject.put("gasPrices", lockKey.getLock().getGasPrice());
//	        jsonObject.put("waterPrices", lockKey.getLock().getWaterPrice());
//	        jsonObject.put("propertyPrice", lockKey.getLock().getPropertyPrice());
	        return jsonObject;
	    }
}
