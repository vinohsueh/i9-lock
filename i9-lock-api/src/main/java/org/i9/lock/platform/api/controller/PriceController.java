package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.i9.lock.platform.model.Price;
import org.i9.lock.platform.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
     * 生成账单
     * @param price
     * @return
     */
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> addPrice(@Valid Price price){
        HashMap<String, Object> result = new HashMap<String, Object>();
        priceService.addPrice(price);
        return result;
    }
    
    /**
     * 查看账单
     * @param price
     * @return
     */
    @RequestMapping(value={"/select"},method = {RequestMethod.POST})
    public HashMap<String, Object> selectPrice(Integer priceId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Price price = priceService.selectPrice(priceId);
        result.put("price",price);
        return result;
    }

}