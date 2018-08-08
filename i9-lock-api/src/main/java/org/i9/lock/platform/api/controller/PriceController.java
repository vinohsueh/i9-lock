package org.i9.lock.platform.api.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.i9.lock.platform.api.component.PriceComponent;
import org.i9.lock.platform.model.Price;
import org.i9.lock.platform.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2018年6月14日 下午
 * @author  gbq
 * @version  
 * 
 */
@RestController
@RequestMapping("price")
public class PriceController {
	
	@Autowired
    private PriceService priceService;
	
	/**
     *确认账单
     * @param price
     * @return
     */
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> addPrice(@Valid Price price,Integer state){
        HashMap<String, Object> result = new HashMap<String, Object>();
        priceService.addPrice(price,state);
        return result;
    }
    
    /**
     * 生成账单
     * @param price
     * @return
     */
    @RequestMapping(value={"/select"},method = {RequestMethod.POST})
    public HashMap<String, Object> selectPrice(Integer priceId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Price price = priceService.selectPrice(priceId);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new PriceComponent().setPrice(price).build();
        jsonArray.add(jsonObject);
        result.put("price",price);
        return result;
    }
    
    /**
     * 查询房屋物业费
     */
     @RequestMapping(value={"/selectPriceAll"},method = {RequestMethod.POST})
     public HashMap<String, Object> selectPriceAll(Integer lookId){
         HashMap<String, Object> result = new HashMap<String, Object>();
         List<Price> price = priceService.selectPriceAll(lookId);
         JSONArray jsonArray = new JSONArray();
         for (Price prices : price) {
             JSONObject jsonObject = new PriceComponent().setPrice(prices).build();
             jsonArray.add(jsonObject);
         }
         result.put("price",price);
         return result;
     }
}
