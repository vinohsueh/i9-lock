package org.i9.lock.platform.core.controller;

import java.util.HashMap;

import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.service.InfoService;
import org.i9.lock.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 创建时间：2018年1月3日 下午4:12:27
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("info")
public class InfoController {
    
    @Autowired
    private InfoService infoService;
    @Autowired
    private UserService userService;
    @RequestMapping(value={"/add"},method = {RequestMethod.POST})
    public HashMap<String, Object> addKey(@RequestBody Info info){
        HashMap<String, Object> result = new HashMap<String, Object>();
        infoService.publishInfo(info);
        return result;
    }
}
