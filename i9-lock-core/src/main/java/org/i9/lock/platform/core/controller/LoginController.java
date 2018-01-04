package org.i9.lock.platform.core.controller;

import java.util.HashMap;

import org.i9.lock.platform.model.Manager;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.service.ManagerService;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/** 
 * 创建时间：2017年12月26日 上午8:52:54
 * @author  lby
 * @version  
 * 
 */
@Controller
@RequestMapping("")
public class LoginController {
    
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @Autowired
    private LockService lockService;
    
    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/")
    public String defaultPage() {
        return "redirect:/index.html";
    }
    
    @RequestMapping("/login.html")
    public String toLogin(@ModelAttribute Manager manager) {
        return "login";
    }
    
    
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Manager manager){
        try {
            managerService.login(manager);
            return new ModelAndView("redirect:index.html");
        } catch (BusinessException e) {
            return new ModelAndView("login").addObject("exception", e);
        }
        
    }
    
    @RequestMapping("/currentUser")
    @ResponseBody
    public HashMap<String, Object> current() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Manager manager = managerService.getLoginUser();
        Integer userNumber = userService.selectCount();
        Integer lockNumber = lockService.selectCount();
        result.put("data", manager);
        result.put("userNumber", userNumber);
        result.put("lockNumber", lockNumber);
        return result;
    }
}
