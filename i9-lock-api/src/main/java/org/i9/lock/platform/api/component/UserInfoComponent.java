package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.User;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年11月6日 下午3:35:02
 * @author  lby
 * @version  
 * 
 */
public class UserInfoComponent {
    private User user;
    
    public UserInfoComponent setUser(User user) {
        this.user = user;
        return this;
    }
    
    public JSONObject build(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", user.getUsername());
        jsonObject.put("password", user.getPassword());
        return jsonObject;
    }
    
}
