package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import org.i9.lock.platform.api.component.LockLogInfoComponent;
import org.i9.lock.platform.model.LockLog;
import org.i9.lock.platform.model.LockLogExample;
import org.i9.lock.platform.service.LockLogService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
 * 锁日志
 * 创建时间：2017年11月27日 上午11:43:03
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("locklog")
public class LockLogController {
    
    @Autowired
    private LockLogService lockLogService;
    
    /**
     * 锁日志列表
     * @param lockSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> list(long lockId,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        LockLogExample example = new LockLogExample();
        example.createCriteria().andLockIdEqualTo(lockId);
        PageBounds<LockLog> pageBounds = lockLogService.selectByLimitPage(example, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (LockLog lockLog : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockLogInfoComponent().setLockLog(lockLog).build();
            jsonArray.add(jsonObject);
        }
        result.put("locklogs", jsonArray);
        return result;
    }
    
}
