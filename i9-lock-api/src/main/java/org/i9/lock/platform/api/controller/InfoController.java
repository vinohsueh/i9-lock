package org.i9.lock.platform.api.controller;

import java.util.HashMap;

import org.i9.lock.platform.api.component.InfoComponent;
import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.model.InfoExample;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.InfoService;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年12月25日 下午4:24:51
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("info")
public class InfoController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private InfoService infoService;
    
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> updateLock(int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        InfoExample example = new InfoExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        example.setOrderByClause("createTime asc");
        PageBounds<Info> infos = infoService.selectByLimitPage(example, currectPage, pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Info info : infos.getPageList()) {
            JSONObject jsonObject = new InfoComponent().setInfo(info).build();
            jsonArray.add(jsonObject);
        }
        result.put("infos",jsonArray);
        return result;
    }
}
