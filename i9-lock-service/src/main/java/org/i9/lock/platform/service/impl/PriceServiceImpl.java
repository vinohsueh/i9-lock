package org.i9.lock.platform.service.impl;

import org.i9.lock.platform.dao.LockKeyDao;
import org.i9.lock.platform.dao.PriceDao;
import org.i9.lock.platform.dao.vo.PriceDto;
import org.i9.lock.platform.model.Price;
import org.i9.lock.platform.service.PriceService;
import org.i9.lock.platform.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PriceServiceImpl implements PriceService{
	
	@Autowired
    private PriceDao priceDao;
	@Autowired
	private LockKeyDao LockKeyDao;

	@Override
	public void addPrice(Price price) throws BusinessException {
		try {
			//通过keyId查询水电燃气单价，物业费，使用数量，userId，lockId
			PriceDto priceDto = LockKeyDao.selectAllPrice(price.getLockeyId());
			price.setElePrices(priceDto.getElePrices());
			price.setGasPrices(priceDto.getGasPrices());
			price.setWaterPrices(priceDto.getWaterPrices());
			price.setLockId(priceDto.getLockId());
			price.setUserId(priceDto.getUserId());
		    priceDao.addPrice(price);
		}catch (Exception e) {
		    throw new BusinessException("生成账单失败",e.getMessage());
		}
	}

	@Override
	public Price selectPrice(Integer priceId) throws BusinessException {
		try {
			return priceDao.selectPrice(priceId);
		}catch (Exception e) {
		    throw new BusinessException("查看账单失败",e.getMessage());
		}
	}

}
