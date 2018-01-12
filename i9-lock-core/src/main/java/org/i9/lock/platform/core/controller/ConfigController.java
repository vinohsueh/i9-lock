package org.i9.lock.platform.core.controller;

import java.util.HashMap;
import java.util.List;

import org.i9.lock.platform.model.Config;
import org.i9.lock.platform.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 创建时间：2018年1月3日 上午11:12:53
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("config")
public class ConfigController {
    @Autowired
    private ConfigService configService;
    
    /**
     * 查询全部配置
     * @return
     */
    @RequestMapping(value="/pageConfig",method=RequestMethod.POST)
    public HashMap<String, Object> pageConfig(){
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Config> list= configService.selectAllConfigs();
        result.put("data", list);
        return result;
    }
    
    /**
     * 更新配置
     * @param config
     * @return
     */
    @RequestMapping(value="/updateConfig",method=RequestMethod.POST)
    public HashMap<String, Object> updateConfig(@RequestBody Config config){
        HashMap<String, Object> result = new HashMap<String, Object>();
        configService.updateConfig(config);
        return result;
    }
}
