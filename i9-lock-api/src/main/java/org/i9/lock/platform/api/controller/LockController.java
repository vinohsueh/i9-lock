package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.i9.lock.platform.api.component.LockListInfoComponent;
import org.i9.lock.platform.api.component.LockPriceComponent;
import org.i9.lock.platform.dao.vo.LockAddDto;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.User;
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
    
    /**
     * 添加锁
     * @param keyDev
     * @return
     */
    @RequestMapping(value={"/save"},method = {RequestMethod.POST})
    public HashMap<String, Object> saveLock(@Valid LockAddDto lockAddDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        Lock lock = new Lock();
        lock.setKeyAdmin(Long.valueOf(lockAddDto.getKeyAdmin()));
        lock.setName(lockAddDto.getName());
        lock.setUserId(user.getId());
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
    public HashMap<String, Object> price(long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Lock lock = lockService.getLockById(lockId);
        if (lock != null) {
            JSONObject jsonObject = new LockPriceComponent().setLock(lock).build();
            result.put("lock", jsonObject);
        }
        return result;
    }
}
