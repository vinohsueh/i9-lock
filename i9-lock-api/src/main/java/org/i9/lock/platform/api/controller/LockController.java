package org.i9.lock.platform.api.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.i9.lock.platform.api.component.LockKeyPriceComponent;
import org.i9.lock.platform.api.component.LockListInfoComponent;
import org.i9.lock.platform.api.component.LockPriceComponent;
import org.i9.lock.platform.dao.vo.LockAddDto;
import org.i9.lock.platform.dao.vo.LockReleaseDto;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年11月22日 下午4:47:21
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("lock")
public class LockController {
    
    @Autowired
    private LockService lockService;
    @Autowired
    private UserService userService;
    @Autowired
    private LockKeyService lockKeyService;
    /**
     * 添加锁
     * @param lockAddDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value={"/save"},method = {RequestMethod.POST})
    public HashMap<String, Object> saveLock(@Valid LockAddDto lockAddDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        Lock lock = new Lock();
        lock.setKeyAdmin(lockAddDto.getKeyAdmin());
        lock.setName(lockAddDto.getName());
        lock.setKeyNumber(lockAddDto.getKeyNumber());
        lock.setKeyUser(lockAddDto.getKeyUser());
        lock.setKeyDev(lockAddDto.getKeyDev());
        lock.setUserId(user.getId());
        lock.setBattery(lockAddDto.getBattery());
        lockService.addLock(lock);
        return result;
    }
    
    /**
     * 更新锁
     * @param lock
     * @return
     */
    @RequestMapping(value={"/update"},method = {RequestMethod.POST})
    public HashMap<String, Object> updateLock(Lock lock){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.updateLock(lock);
        return result;
    }
    
    /**
     * 设备列表
     * @param lockSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> list(LockSearchDto lockSearchDto,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockSearchDto.setOrderByClause("createTime desc");
        PageBounds<Lock> pageBounds = lockService.selectByLimitPage(lockSearchDto, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Lock lock : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build();
            jsonArray.add(jsonObject);
        }
        result.put("locks", jsonArray);
        return result;
    }
    
    /**
     * 物业缴费
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/price"},method = {RequestMethod.POST})
    public HashMap<String, Object> price(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Lock lock = lockService.getLockById(lockId);
        if (lock != null) {
            JSONObject jsonObject = new LockPriceComponent().setLock(lock).build();
            result.put("lock", jsonObject);
        }
        List<LockKey> lockKeys = lockKeyService.getLockKeyByLockId(lockId);
        JSONArray jsonArray = new JSONArray();
        for (LockKey lockKey : lockKeys) {
            JSONObject jsonObject = new LockKeyPriceComponent().setLockKey(lockKey).build();
            jsonArray.add(jsonObject);
        }
        result.put("keys", jsonArray);
        return result;
    }
    
    /**
     * 移交锁验证
     * @param lockReleaseDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value={"/releaseValidate"},method = {RequestMethod.POST})
    public HashMap<String, Object> releaseValidate(@Valid LockReleaseDto lockReleaseDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.releaseLockValidate(lockReleaseDto);
        return result;
    }
    
    /**
     * 移交锁
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/release"},method = {RequestMethod.POST})
    public HashMap<String, Object> release(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.releaseLock(lockId);
        return result;
    }
    
    /**
     * 租户设备列表
     * @return
     */
    @RequestMapping(value={"/authorizeList"},method = {RequestMethod.POST})
    public HashMap<String, Object> authorizeList(LockSearchDto lockSearchDto,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        lockSearchDto.setUserId(user.getId());
        lockSearchDto.setOrderByClause("createTime desc");
        PageBounds<Lock> pageBounds = lockService.selectAuthorizeLocks(lockSearchDto, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Lock lock : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build();
            jsonArray.add(jsonObject);
        }
        result.put("locks", jsonArray);
        return result;
    }
    
    /**
     * 房东设备列表
     * @return
     */
    @RequestMapping(value={"/landlordKey"},method = {RequestMethod.POST})
    public HashMap<String, Object> landlordKey(LockSearchDto lockSearchDto,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        lockSearchDto.setOrderByClause("createTime desc");
        lockSearchDto.setUserId(user.getId());
        PageBounds<Lock> pageBounds = lockService.selectByLimitPage(lockSearchDto, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Lock lock : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build();
            jsonArray.add(jsonObject);
        }
        result.put("locks", jsonArray);
        return result;
    }
}
