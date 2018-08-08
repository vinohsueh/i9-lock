package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.PriceDao;
import org.i9.lock.platform.dao.mapper.PriceMapper;
import org.i9.lock.platform.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PriceDaoImpl implements PriceDao{

	@Autowired
    private PriceMapper priceMapper;
	
	@Override
	public void addPrice(Price Price) throws Exception {
		priceMapper.insertSelective(Price);
	}

	@Override
	public Price selectPrice(Integer priceId) {
		return priceMapper.selectByPrimaryKey(priceId);
	}

	@Override
	public List<Price> selectPriceAll(Integer lookId) throws Exception {
		return priceMapper.selectPriceAll(lookId);
	}

}
