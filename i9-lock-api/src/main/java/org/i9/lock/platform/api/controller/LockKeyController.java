package org.i9.lock.platform.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.i9.lock.platform.api.component.LockKeyComponent;
import org.i9.lock.platform.api.component.LockKeyListComponent;
import org.i9.lock.platform.api.component.LockKeyPriceComponent;
import org.i9.lock.platform.dao.vo.LockKeyDto;
import org.i9.lock.platform.dao.vo.UpdateTimeDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.PageBounds;
import org.i9.lock.platform.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
 * 锁钥匙
 * 创建时间：2017年11月29日 下午3:53:23
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("lockKey")
public class LockKeyController {
    
    @Autowired
    private LockKeyService lockKeyService;
    
    @Autowired
    private LockService lockService;
    @Autowired
    private UserService userService;
    /**
     * 添加租户钥匙
     * @param lockKeyDto
     * @return
     */
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> addKey(LockKeyDto lockKeyDto){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockKeyService.addLockKey(lockKeyDto);
        return result;
    }
    
    /**
     * 临时密码
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/temporary"},method = {RequestMethod.POST})
    public HashMap<String, Object> addTemporaryKey(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        String keyDev = lockService.getLockById(lockId).getKeyDev();
        result.put("keyDev", keyDev);
        return result;
    }
    
    /**
     * 查询锁的所有钥匙
     * @param lockId
     * @param currectPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> listKey(Long lockId,Integer currectPage, Integer pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        LockKeyExample example = new LockKeyExample();
        example.createCriteria().andLockIdEqualTo(lockId);
        example.setOrderByClause("createTime desc");
        PageBounds<LockKey> list = lockKeyService.selectByLimitPage(example, currectPage, pageSize);
        List<LockKey> keys = list.getPageList();
        JSONArray jsonArray = new JSONArray();
        for (LockKey lockKey : keys) {
            JSONObject jsonObject = new LockKeyListComponent().setLockKey(lockKey).build();
            jsonArray.add(jsonObject);
        }
        result.put("keys", jsonArray);
        return result;
    }
    
    /**
     * 删除钥匙
     * @param lockKeyId
     * @return
     */
    @RequestMapping(value={"/delete"},method = {RequestMethod.POST})
    public HashMap<String, Object> delete(Integer lockKeyId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockKeyService.deleteLockKey(lockKeyId);
        return result;
    }
    
    /**
     * 更新租户钥匙
     * @param lockKey
     * @return
     */
    @RequestMapping(value={"/update"},method = {RequestMethod.POST})
    public HashMap<String, Object> updateKey(LockKey lockKey){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        lockKey.setUserId(user.getId());
        lockKeyService.updateLockKeyByTwoId(lockKey);
        return result;
    }
    
    /**
     * 获取用户组编号
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/getUserOrderNumber"},method = {RequestMethod.POST})
    public HashMap<String, Object> getUserOrderNumber(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        Lock lock = lockService.getLockById(lockId);
        //判断是否是房东
        if (lock.getUserId() - user.getId() == 0) {
        	result.put("userOrder", 0);
        }else{
        	LockKey lockKey = lockKeyService.selectLockKeyByLockIdAndUserId(lockId, user.getId());
        	if (null == lockKey.getState() && 0 == lockKey.getState()) {
        	    lockKey.setReceiveTime(null);
        	    lockKey.setEndTime(null);
            }
            result.put("userOrder", lockKey.getOrderNumber());
        }
        return result;
    }
    
    /**
     * 更新租期
     * @param updateTimeDto
     * @return
     */
    @RequestMapping(value={"/updateEndTime"},method = {RequestMethod.POST})
    public HashMap<String, Object> getUserOrderNumber(UpdateTimeDto updateTimeDto){
        HashMap<String, Object> result = new HashMap<String, Object>();
        LockKey lockKey = updateTimeDto.getLockKey(); 
        lockKeyService.updateEndTime(lockKey);
        return result;
    }
    
    /**
     * 根据锁号删除全部钥匙
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/deleteAll"},method = {RequestMethod.POST})
    public HashMap<String, Object> deleteAll(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockKeyService.deleteAll(lockId);
        return result;
    }
    
    /**
     * 根据lockkeyId查询
     * @param lockKeyId
     * @return
     */
    @RequestMapping(value={"/getLockKey"},method = {RequestMethod.POST})
    public HashMap<String, Object> getLockKey(Integer lockKeyId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        LockKey lockKey = lockKeyService.getLockKeyById(lockKeyId);
        JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new LockKeyComponent().setLockKey(lockKey).build();
            jsonArray.add(jsonObject);
        result.put("lockKey", jsonArray);
        return result;
    }
    
    /**
     * 根据锁号查询结束时间和ordernumber
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/getTimeAndOrderNum"},method = {RequestMethod.POST})
    public HashMap<String, Object> getTimeAndOrderNum(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<LockKey> lockKey=lockKeyService.getTimeAndOrderNum(lockId);
        JSONArray jsonArray = new JSONArray();
        for (LockKey lockKeys : lockKey) {
            JSONObject jsonObject = new LockKeyComponent().setLockKey(lockKeys).build();
            jsonArray.add(jsonObject);
        }
        result.put("lockKey", jsonArray);
        return result;
    }

    /**
     * 更换结束时间
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/updateEndTimeByLockId"},method = {RequestMethod.POST})
        public HashMap<String, Object> updateEndTimeByLockId(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User currentUser = userService.getCurrentUser();
        LockKey lockKey = lockKeyService.selectLockKeyByLockIdAndUserId(lockId, currentUser.getId());
        Date d=new Date(System.currentTimeMillis()-1000*60*60*24);
        lockKey.setEndTime(d);
        lockKeyService.updateLockKey(lockKey);
        lockKey.setUserId(null);
        lockKeyService.updateLockKeyByPriviteKey(lockKey);
        return result;
    }
}
