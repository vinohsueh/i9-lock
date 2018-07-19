package org.i9.lock.platform.api.controller;

import java.util.HashMap;
import java.util.List;

import org.i9.lock.platform.model.Card;
import org.i9.lock.platform.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 创建时间：2018年7月17日 下午4:47:21
 * @author  gbq
 * @version  
 * 
 */
@RestController
@RequestMapping("card")
public class CardController {
	@Autowired
    private  CardService cardService;
	
	 /**
     * 查询全部卡
     * @param 
     * @return
     */
    @RequestMapping(value={"/getAllCard"},method = {RequestMethod.POST})
    public HashMap<String, Object> getAllCard(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Card> card = cardService.getAllCard(lockId);
        result.put("card", card);
        return result;
    }
    /**
     * 添加卡
     * @param 
     * @return
     */
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> addCard(Card card){
        HashMap<String, Object> result = new HashMap<String, Object>();
        cardService.addCard(card);
        return result;
    }
    
    /**
     * 删除卡
     * @param 
     * @return
     */
    @RequestMapping(value={"/delete"},method = {RequestMethod.POST})
    public HashMap<String, Object> deleteCard(Integer cardId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        cardService.deleteCard(cardId);
        return result;
    }
    /**
     * 通过id查询
     * @param 
     * @return
     */
    @RequestMapping(value={"/getCard"},method = {RequestMethod.POST})
    public HashMap<String, Object> getCardById(Integer cardId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Card card = cardService.getCardById(cardId);
        result.put("card", card);
        return result;
    }
    
    /**
     * 查询已存在的序号
     * @param 
     * @return
     */
    @RequestMapping(value={"/selectExistOrderNumber"},method = {RequestMethod.POST})
    public HashMap<String, Object> selectExistOrderNumber(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Integer orderNumber = cardService.selectExistOrderNumber(lockId);
        result.put("list", orderNumber);
        return result;
    }
}
