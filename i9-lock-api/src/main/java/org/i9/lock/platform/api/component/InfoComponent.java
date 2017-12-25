package org.i9.lock.platform.api.component;

import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.utils.StringUtil;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年12月25日 下午5:07:53
 * @author  lby
 * @version  
 * 
 */
public class InfoComponent {
    private Info info;
    
    public InfoComponent setInfo(Info info){
        this.info = info;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", info.getContent());
        jsonObject.put("createTime", StringUtil.dateToStringByRep(info.getCreateTime(), "yyyy-MM-dd HH:mm"));
        return jsonObject;
    }
}
