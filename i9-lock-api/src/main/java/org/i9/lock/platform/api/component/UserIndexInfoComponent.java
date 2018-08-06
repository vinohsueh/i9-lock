package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.User;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年12月18日 下午1:39:18
 * @author  lby
 * @version  
 * 
 */
public class UserIndexInfoComponent {
    private User user;
    
    public UserIndexInfoComponent setUser(User user) {
        this.user = user;
        return this;
    }
    
    public JSONObject build(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone", user.getPhone());
        jsonObject.put("familyPhone", user.getFamilyPhone());
        jsonObject.put("name", user.getName());
        jsonObject.put("headPicture",user.getHeadPicture() );
        return jsonObject;
    }
    
}
