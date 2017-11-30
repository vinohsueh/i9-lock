package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.i9.lock.platform.dao.vo.LockKeyDto;
import org.i9.lock.platform.service.LockKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> addKey(@Valid LockKeyDto lockKeyDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockKeyService.addLockKey(lockKeyDto);
        return result;
    }
}
