package org.i9.lock.platform.core.controller;

import java.util.HashMap;

import org.i9.lock.platform.dao.vo.PasswordSearchDto;
import org.i9.lock.platform.model.Password;
import org.i9.lock.platform.service.PasswordService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 创建时间：2017年12月26日 上午8:52:37
 * @author  gbq
 * @version  
 * 
 */
@RestController
@RequestMapping("password")
public class PasswordController {
    
     @Autowired
     private PasswordService passwordService;
      /**
         * 分页查询
         * @param managerPageDto
         * @return
         */
     @RequestMapping("/pagePassword")
     public HashMap<String, Object> pagePassword(@RequestBody PasswordSearchDto passwordDto){
         HashMap<String, Object> result = new HashMap<String, Object>();
         PageBounds<Password> pageBounds =passwordService.selectByLimitPage(passwordDto, passwordDto.getCurrentPage(), passwordDto.getPageSize());
         result.put("data", pageBounds);
         return result;
     }

     /**
         * 根据id查询
         * @param managerId
         * @return
         */
        @RequestMapping("/getPassword")
        public HashMap<String, Object> getPassword(@RequestBody Integer passwordId){
            HashMap<String, Object> result = new HashMap<String, Object>();
            Password password = passwordService.getPasswordById(passwordId);
            result.put("data", password);
            return result;
        }
        
        /**
         * 修改
         * @param managerId
         * @return
         */
        @RequestMapping("/updatePassword")
        public HashMap<String, Object> updatePassword(@RequestBody Password password){
            HashMap<String, Object> result = new HashMap<String, Object>();
            passwordService.updatePassword(password);
            return result;
        }
}
