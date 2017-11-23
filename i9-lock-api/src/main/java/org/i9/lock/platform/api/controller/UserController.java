package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间：2017年11月6日 上午11:06:34
 * 
 * @author lby
 * @version
 * 
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public HashMap<String, Object> login(@Valid User user,BindingResult bindingResult) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        userService.login(user);
        return result;
    }
    
    @RequestMapping("/regist")
    public HashMap<String, Object> regist(@Valid User user,BindingResult bindingResult) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        userService.regist(user);
        return result;
    }
    
    @RequestMapping("/currentUser")
    public HashMap<String, Object> currentUser() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        byte [] a = EncryptUtils.longToBytes(user.getId());
        String keyAdmin = EncryptUtils.bytesToHexString(a);
        result.put("keyAdmin", keyAdmin);
        return result;
    }
}
