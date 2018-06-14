package org.i9.lock.platform.service;

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
     * @param Price
     * @throws BusinessException
     */
    void addPrice(Price price) throws BusinessException;
    
    /**
     * 查看账单
     * @param priceId
     * @throws BusinessException
     */
	Price selectPrice(Integer priceId)throws BusinessException;
    
}
