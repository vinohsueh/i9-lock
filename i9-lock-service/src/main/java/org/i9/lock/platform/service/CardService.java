package org.i9.lock.platform.service;

import java.util.List;

import org.i9.lock.platform.model.Card;
import org.i9.lock.platform.utils.BusinessException;

public interface CardService {
	 /**
     * 查询全部卡
	 * @param lockId 
	 * @param userId 
     * @param Card
     * @throws BusinessException
     */
	List<Card> getAllCard(Long lockId, Long userId)throws BusinessException;
	/**
     * 添加卡
     * @param Card
     * @throws BusinessException
     */
	void addCard(Card card)throws BusinessException;
	/**
     * 删除卡
     * @param Card
     * @throws BusinessException
     */
	void deleteCard(Integer cardId)throws BusinessException;
	/**
     * 通过id查询
     * @param Card
     * @throws BusinessException
     */
	Card getCardById(Integer cardId)throws BusinessException;
	/**
     * 查询已存在的序号
     * @param Card
     * @throws BusinessException
     */
	Integer selectExistOrderNumber(Long lockId)throws BusinessException;
	/**
	 * 根据lockId删除
	* @Title: deleteCardByLockId
	* @param @param id
	* @param @throws BusinessException
	* @return void
	 */
	void deleteCardByLockId(Long id)throws BusinessException;

}
