package org.i9.lock.platform.api.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.i9.lock.platform.dao.vo.LockKeyDto;
import org.i9.lock.platform.dao.vo.TemporaryKeyDto;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.LockKeyExample;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.utils.PageBounds;
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
    
    /**
     * 添加租户钥匙
     * @param lockKeyDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> addKey(@Valid LockKeyDto lockKeyDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockKeyService.addLockKey(lockKeyDto);
        return result;
    }
    
    /**
     * 临时密码
     * @param applyPwd
     * @return
     */
    @RequestMapping(value={"/temporary"},method = {RequestMethod.POST})
    public HashMap<String, Object> addTemporaryKey(@Valid TemporaryKeyDto temporaryKeyDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockKeyService.addTemporaryKey(temporaryKeyDto);
        return result;
    }
    
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> listKey(Long lockId,Integer currectPage, Integer pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        LockKeyExample example = new LockKeyExample();
        example.createCriteria().andLockIdEqualTo(lockId);
        PageBounds<LockKey> list = lockKeyService.selectByLimitPage(example, currectPage, pageSize);
        return result;
    }
}
