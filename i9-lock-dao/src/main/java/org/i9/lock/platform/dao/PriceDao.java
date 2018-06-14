package org.i9.lock.platform.dao;

import org.i9.lock.platform.model.Price;

/** 
 * 创建时间：2018年6月14日 
 * @author  gbq
 * @version  
 * 
 */
public interface PriceDao {
	 /**
     * 生成账单
     * @param Price
     * @throws Exception
     */
    void addPrice(Price Price) throws Exception;
    /**
     * 查看账单
     * @param Price
     * @throws Exception
     */
	Price selectPrice(Integer priceId);
}
