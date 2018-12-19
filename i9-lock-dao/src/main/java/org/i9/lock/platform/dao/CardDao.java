package org.i9.lock.platform.dao;

import java.util.ArrayList;
import java.util.List;

import org.i9.lock.platform.dao.vo.SyncLockDto;
import org.i9.lock.platform.model.Card;

public interface CardDao {
	 /**
     * 查询全部卡
	 * @param userId 
     * @param 
     * @return
     * @throws Exception
     */
	List<Card> getAllCard(Long lockId, Long userId)throws Exception;
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
	/**
	 * 根据lockId删除卡
	* @Title: deleteCardByLockId
	* @param @param id
	* @return void
	 */
	void deleteCardByLockId(Long id);
	
	/**
	 * 根据LockId和UserId查询用户组
	* @Title: selectExistOrderNumber
	* @param @param lockId
	* @param @param userId
	* @param @return
	 */
    List<Integer> selectExistOrderNumber(Long lockId, Long userId);
    
    void insertPwdByLockIdAndUserId(ArrayList<Card> pwdSameList);
    
    void delPwdByLockIdAndUserId(Long lockId, Long userId, ArrayList<Integer> unPwdSameList);
    
    List<Integer> selectExistOrderNumber2(Long lockId, Long userId);
    
    void updatePasswordByLockId(SyncLockDto syncLockDto);

}
