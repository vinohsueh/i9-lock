package org.i9.lock.platform.dao.impl;

import java.util.List;

import org.i9.lock.platform.dao.CardDao;
import org.i9.lock.platform.dao.mapper.CardMapper;
import org.i9.lock.platform.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/** 
 * 创建时间：2018年7月16日 下午
 * @author  gbq
 * @version  
 * 
 */
@Repository
public class CardDaoImpl implements CardDao {
	 @Autowired
	 private CardMapper cardMapper;

	@Override
	public List<Card> getAllCard(Long lockId) throws Exception {
		return cardMapper.getAllCard(lockId);
	}

	@Override
	public void addCard(Card card) throws Exception {
		cardMapper.insertSelective(card);
	}

	@Override
	public void deleteCard(Integer cardId) throws Exception {
		cardMapper.deleteByPrimaryKey(cardId);	
	}

	@Override
	public Card getCardById(Integer cardId) throws Exception {
		return cardMapper.selectByPrimaryKey(cardId);
	}

	@Override
	public List<Integer> selectExistOrderNumber(Long cardId) {
		return cardMapper.selectExistOrderNumber(cardId);
	}

	@Override
	public void deleteCardByLockId(Long id) {
		cardMapper.deleteCardByLockId(id);
	}


}
