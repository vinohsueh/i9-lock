package org.i9.lock.platform.core.controller;

import java.util.HashMap;

import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 创建时间：2017年12月26日  下午14:30
 * @author  姜哲
 * @version  
 * 
 */
@RestController
@RequestMapping("lock")
public class LockController {

	@Autowired
	private LockService lockService;
	
	/**
     * 分页查询
     * @param lockPageDto
     * @return
     */
    @RequestMapping(value="/pageLock",method=RequestMethod.POST)
    public HashMap<String, Object> pageLock(@RequestBody LockSearchDto lockSearchDto){
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBounds<Lock> pageBounds = lockService.selectByLimitPage(lockSearchDto, lockSearchDto.getCurrentPage(), lockSearchDto.getPageSize());
        result.put("data", pageBounds);
        return result;
    }
    
    /**
     * 根据id查询
     * @param lockId
     * @return
     */
    @RequestMapping(value="/getLock",method=RequestMethod.POST)
    public HashMap<String, Object> getLock(@RequestBody Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Lock lock = lockService.getLockById(lockId);
        result.put("data", lock);
        return result;
    }
   
}
