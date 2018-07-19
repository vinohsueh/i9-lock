package org.i9.lock.platform.dao;

import java.util.List;

import org.i9.lock.platform.model.Card;

public interface CardDao {
	 /**
     * 查询全部卡
     * @param 
     * @return
     * @throws Exception
     */
	List<Card> getAllCard(Long lockId)throws Exception;
	 /**
     * 添加卡
     * @param 
     * @return
     * @throws Exception
     */
	void addCard(Card card)throws Exception;
	 /**
     * 删除卡
     * @param 
     * @return
     * @throws Exception
     */
	void deleteCard(Integer cardId)throws Exception;
	 /**
     * 通过id查询卡
     * @param 
     * @return
     * @throws Exception
     */
	Card getCardById(Integer cardId)throws Exception;
	
	/**
     * 查询已经存在的卡序号
     * @param 
     * @return
     * @throws Exception
     */
	List<Integer> selectExistOrderNumber(Long cardId);

}
