package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.Password;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年12月25日 下午5:07:53
 * @author  lby
 * @version  
 * 
 */
public class PasswordComponent {
    private Password password;
    private int number;
    
    public PasswordComponent setPassword(Password password){
        this.password = password;
        return this;
    }
    
    public PasswordComponent setNumber(int userNumber) {
        this.number = userNumber;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", password.getName());
        jsonObject.put("orderNumber", password.getOrderNumber());
        jsonObject.put("userNumber", number);
        jsonObject.put("type", password.getTypeName());
        return jsonObject;
    }

    
}
