package org.i9.lock.platform.api.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.i9.lock.platform.api.component.LockPriceComponent;
import org.i9.lock.platform.api.component.PasswordComponent;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.service.PasswordService;
import org.i9.lock.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年12月7日 下午3:26:25
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("password")
public class PasswordController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordService passwordService;
    
    @Autowired
    private LockKeyService lockKeyService;
    @Autowired
    private LockService lockService;
    /**
     * 获取锁的可用顺序编号
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/getUsefulOrderNumber"},method = {RequestMethod.POST})
    public HashMap<String, Object> getUsefulOrderNumber(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Integer orderNumber = passwordService.selectUsefulOrderNumber(lockId);
        result.put("orderNumber", orderNumber);
        return result;
    }
    
    /**
     * 添加密码
     * @param password
     * @return
     */
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> add(@Valid Password password,BindingResult bindingResult,Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        password.setUserId(user.getId());
        passwordService.addPassword(password);
        Lock lock2 = lockService.getLockById(lockId);
        result.put("battery", lock2.getBattery());
        return result;
    }
    
    /**
     * 删除密码
     * @param password
     * @return
     */
    @RequestMapping(value={"/delete"},method = {RequestMethod.POST})
    public HashMap<String, Object> delete(Integer passwordId,Long id){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        passwordService.deletePassword(passwordId,user.getId());
        Lock lock2 = lockService.getLockById(id);
        result.put("battery", lock2.getBattery());
        return result;
    }
    
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> list(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        List<Password> list = passwordService.listAllPasswords(lockId, user.getId());
        Lock lock = lockService.getLockById(lockId);
        Integer userNumber = null;
        if (lock.getUserId() == user.getId()){
            userNumber = 0;
        }else{
          //查询用户组编号
            LockKey existLockKey = lockKeyService.selectLockKeyByLockIdAndUserId(lockId, user.getId());
            userNumber = existLockKey.getOrderNumber();
        }
        
        JSONArray jsonArray = new JSONArray();
        for (Password password : list) {
            JSONObject jsonObject = new PasswordComponent().setPassword(password).setNumber(userNumber).build();
            jsonArray.add(jsonObject);
        }
        result.put("passwords", jsonArray);
        return result;
    }
}
