package org.i9.lock.platform.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.i9.lock.platform.dao.CardDao;
import org.i9.lock.platform.dao.ConfigDao;
import org.i9.lock.platform.model.Card;
import org.i9.lock.platform.model.Config;
import org.i9.lock.platform.service.CardService;
import org.i9.lock.platform.utils.BusinessException;
import org.i9.lock.platform.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/** 
 * 创建时间：2018年7月17日 下午4:38:13
 * @author gbq
 * @version  
 * 
 */
@Service
@Transactional
public class CardServiceImpl implements CardService {

	 @Autowired
	 private CardDao cardDao;
	 @Autowired
	 private ConfigDao configDao;
	 
	@Override
	public List<Card> getAllCard(Long lockId) throws BusinessException {
	    try {
            return cardDao.getAllCard(lockId);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"查询卡失败",e.getMessage());
        }
	}

	@Override
	public void addCard(Card card) throws BusinessException {
		try {
         // 查询1-9的编号 最小未使用编号
            List<Integer> list = cardDao.selectExistOrderNumber(card.getLockId());
            //查询最大可用编号数
            Config config = configDao.selectMaxHirer();
            int max = config.getConfigValue();
            if (list.size() >= max-1) {
                throw new BusinessException(ErrorCode.CRUD_ERROR,
                        "该锁租户已满,不能再添加了");
            }
            Integer orderNumber = selectOrderNumber(list,max);
            // 将最小编号赋给卡的序号
            card.setOrderNumber(orderNumber);
            cardDao.addCard(card);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"添加卡失败",e.getMessage());
        }
	}

	@Override
	public void deleteCard(Integer cardId) throws BusinessException {
		try {
            cardDao.deleteCard(cardId);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"删除卡失败",e.getMessage());
        }
	}

	@Override
	public Card getCardById(Integer cardId) throws BusinessException {
		try {
            return cardDao.getCardById(cardId);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"通过id查询卡失败",e.getMessage());
        }
	}
	
	/**
     * 查询1-9的编号 最小未使用编号
     * 
     * @param list
     * @return
     */
    private static Integer selectOrderNumber(List<Integer> list,int max) {
        //最大可用编号数集合
        List<Integer> maxArray = new ArrayList<Integer>();
        for (int i = 1; i < max; i++) {
            maxArray.add(i);
        }
        
        List<Integer> array = new ArrayList<Integer>();
        for (Integer integer : maxArray) {
            if (!array.contains(integer) && !list.contains(integer)) {
                array.add(integer);
            }
        }
        Integer orderNumber = Collections.min(array);
        return orderNumber;
    }

	@Override
	public Integer selectExistOrderNumber(Long lockId) throws BusinessException{
		try {
			List<Integer> list = cardDao.selectExistOrderNumber(lockId);
			List<Integer> a = new ArrayList<>();
			for(int i = 1; i<10;i++){
				if(!list.contains(i)){
					a.add(i);
				}
			}
			 if (a.size() > 0) {
		         return a.get(0);
		        }
			return null;
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.CRUD_ERROR,"通过id查询卡失败",e.getMessage());
        }
	}

}
