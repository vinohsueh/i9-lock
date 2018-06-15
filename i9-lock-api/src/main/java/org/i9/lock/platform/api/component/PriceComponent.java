package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.Price;

import com.alibaba.fastjson.JSONObject;

public class PriceComponent {
	private Price price;
	
	 public PriceComponent setPrice(Price price) {
	        this.price = price;
	        return this;
	    }
	 
	 public JSONObject build() {
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("hirerPhone", price.getLockKey().getHirerPhone());
	        jsonObject.put("name", price.getLockKey().getName());
	        jsonObject.put("startTime", price.getLockKey().getStartTime());
	        jsonObject.put("endTime", price.getLockKey().getEndTime());
	        jsonObject.put("hireType", price.getLockKey().getHireType());
	        jsonObject.put("hirePrice", price.getLockKey().getHirePrice());
	        jsonObject.put("eleNumber", price.getLockKey().getEleNumber());
	        jsonObject.put("gasNumber", price.getLockKey().getGasNumber());
	        jsonObject.put("waterNumber", price.getLockKey().getWaterNumber());
	        jsonObject.put("elePrices", price.getElePrices());
	        jsonObject.put("gasPrices", price.getGasPrices());
	        jsonObject.put("waterPrices", price.getWaterPrices());
	        return jsonObject;
	    }
}
