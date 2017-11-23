package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value={"/save"},method = {RequestMethod.POST})
    public HashMap<String, Object> saveLock(Lock lock){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.addLock(lock);
        return result;
    }
}
