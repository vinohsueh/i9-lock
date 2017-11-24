package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.i9.lock.platform.api.component.LockInfoComponent;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(value={"/save"},method = {RequestMethod.POST})
    public HashMap<String, Object> saveLock(@Valid @NotBlank(message="密钥不能为空") @Pattern(regexp="^[0-9]{8}$",message="请输入8个数字")String keyDev){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        Lock lock = new Lock();
        lock.setKeyDev(Long.valueOf(keyDev));
        lock.setUserId(user.getId());
        lockService.addLock(lock);
        return result;
    }
    
    @RequestMapping(value={"/update"},method = {RequestMethod.POST})
    public HashMap<String, Object> updateLock(Lock lock){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.updateLock(lock);
        return result;
    }
    
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> list(LockSearchDto lockSearchDto,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBounds<Lock> pageBounds = lockService.selectByLimitPage(lockSearchDto, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Lock lock : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockInfoComponent().setLock(lock).build();
            jsonArray.add(jsonObject);
        }
        result.put("locks", jsonArray);
        return result;
    }
}
