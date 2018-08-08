package org.i9.lock.platform.service;

import java.util.List;

import org.i9.lock.platform.model.Price;
import org.i9.lock.platform.utils.BusinessException;

/** 
 * 创建时间：2018年6月14日 
 * @author  gbq
 * @version  
 * 
 */
public interface PriceService {
	/**
     * 生成账单
	 * @param state 
     * @param Price
     * @throws BusinessException
     */
    void addPrice(Price price, Integer state) throws BusinessException;
    
    /**
     * 查看账单
     * @param priceId
     * @throws BusinessException
     */
	Price selectPrice(Integer priceId)throws BusinessException;
	  /**
     * 查询房屋物业费
     * @param lookId
     * @throws BusinessException
     */
	List<Price> selectPriceAll(Integer lookId)throws BusinessException;
    
}
