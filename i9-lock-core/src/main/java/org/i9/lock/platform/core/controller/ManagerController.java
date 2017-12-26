package org.i9.lock.platform.core.controller;

import java.util.HashMap;

import org.i9.lock.platform.dao.pageQueryDto.ManagerPageDto;
import org.i9.lock.platform.model.Manager;
import org.i9.lock.platform.model.ManagerExample;
import org.i9.lock.platform.service.ManagerService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 创建时间：2017年12月26日 上午8:52:37
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("manager")
public class ManagerController {
    
    @Autowired
    private ManagerService managerService;
    
    /**
     * 分页查询
     * @param managerPageDto
     * @return
     */
    @RequestMapping("/pageManager")
    public HashMap<String, Object> pageManager(@RequestBody ManagerPageDto managerPageDto){
        HashMap<String, Object> result = new HashMap<String, Object>();
        ManagerExample example = new ManagerExample();
        PageBounds<Manager> pageBounds = managerService.selectByLimitPage(example, managerPageDto.getCurrentPage(), managerPageDto.getPageSize());
        result.put("data", pageBounds);
        return result;
    }
    
    /**
     * 根据id查询
     * @param managerId
     * @return
     */
    @RequestMapping("/getManager")
    public HashMap<String, Object> getManager(@RequestBody Integer managerId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Manager manager = managerService.getManagerById(managerId);
        result.put("data", manager);
        return result;
    }
    
    /**
     * 保存管理员
     * @param manager
     * @return
     */
    @RequestMapping("/addManager")
    public HashMap<String, Object> addManager(@RequestBody Manager manager){
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (manager.getId() != null) {
            managerService.updateManager(manager);
        }else{
            managerService.addManager(manager);
        }
        result.put("data", manager);
        return result;
    }
    
    /**
     * 删除
     * @param managerId
     * @return
     */
    @RequestMapping("/delManager")
    public HashMap<String, Object> delManager(@RequestBody Integer managerId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.deleteManager(managerId);
        return result;
    }
}
