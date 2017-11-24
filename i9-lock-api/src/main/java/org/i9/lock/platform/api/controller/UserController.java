package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
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
    
    /**
     * 登录
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping("/login")
    public HashMap<String, Object> login(@Valid User user,BindingResult bindingResult) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        userService.login(user);
        return result;
    }
    
    /**
     * 注册
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping("/regist")
    public HashMap<String, Object> regist(@Valid User user,BindingResult bindingResult) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        userService.regist(user);
        return result;
    }
    
    /**
     * 获取帐号7字节
     * @return
     */
    @RequestMapping("/currentUser")
    public HashMap<String, Object> currentUser() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        byte [] a = EncryptUtils.longToBytes(user.getId());
        byte [] b = new byte[a.length-1];
        System.arraycopy(a, 1, b, 0, b.length);
        String keyAdmin = EncryptUtils.bytesToHexString(b);
        result.put("account", keyAdmin);
        return result;
    }
    
    @RequestMapping("/updateFamilyPhone")
    public HashMap<String, Object> updateFamilyPhone(@Valid @NotBlank(message="手机号不能为空") @Pattern(regexp = "^1[3|4|5|7|8][0-9]\\d{8}$", message = "请输入正确的手机号")String phone) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        userService.updateFamilyPhone(phone);
        return result;
    }
}
