package org.i9.lock.platform.api.component;

import java.util.Collections;
import java.util.Date;

import org.i9.lock.platform.dao.vo.LockKeyComparator;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.utils.StringUtil;

import com.alibaba.fastjson.JSONObject;

/** 
 * 创建时间：2017年11月24日 上午8:27:31
 * @author  lby
 * @version  
 * 
 */
public class LockListInfoComponent {
    
    private Lock lock;
    
    public LockListInfoComponent setLock(Lock lock){
        this.lock = lock;
        return this;
    }
    
    public JSONObject build() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("name", lock.getName());
        jsonObject.put("battery", lock.getBattery());
        jsonObject.put("keyUser", lock.getKeyUser());
        jsonObject.put("keyAdmin", lock.getKeyAdmin());
        jsonObject.put("keyNumber", lock.getKeyNumber());
        jsonObject.put("keyDev", lock.getKeyDev());
        jsonObject.put("receiveFlag", lock.getReceiveFlag());
        jsonObject.put("remark", lock.getRemark());
        jsonObject.put("safeMode", lock.getSafeMode());
        jsonObject.put("mac", lock.getMac());
        jsonObject.put("deviceName", lock.getDeviceName());
        jsonObject.put("startTime", null);
        jsonObject.put("endTime", null);
        jsonObject.put("departmentType",lock.getDepartmentType());
        jsonObject.put("departmentAddress",lock.getDepartmentAddress());
        jsonObject.put("departmentNumber", lock.getDepartmentNumber());
        jsonObject.put("departmentPicture", lock.getDepartmentPicture());
        jsonObject.put("cusNumber",lock.getCusNumber());
        jsonObject.put("showType", lock.getShowType());
        if (lock.getStartTime() != null) {
            jsonObject.put("startTime", StringUtil.dateToStringByRep(lock.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (lock.getEndTime() != null) {
            jsonObject.put("endTime", StringUtil.dateToStringByRep(lock.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return jsonObject;
    }
    
    public JSONObject build1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("name", lock.getName());
        jsonObject.put("battery", lock.getBattery());
        jsonObject.put("keyUser", lock.getKeyUser());
        jsonObject.put("keyAdmin", lock.getKeyAdmin());
        jsonObject.put("keyNumber", lock.getKeyNumber());
        jsonObject.put("keyDev", lock.getKeyDev());
        jsonObject.put("receiveFlag", lock.getReceiveFlag());
        jsonObject.put("remark", lock.getRemark());
        jsonObject.put("safeMode", lock.getSafeMode());
        jsonObject.put("mac", lock.getMac());
        jsonObject.put("deviceName", lock.getDeviceName());
        jsonObject.put("startTime", null);
        jsonObject.put("endTime", null);
        jsonObject.put("remains", null);
        if (lock.getStartTime() != null) {
            jsonObject.put("startTime", StringUtil.dateToStringByRep(lock.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (lock.getEndTime() != null) {
            jsonObject.put("endTime", StringUtil.dateToStringByRep(lock.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (lock.getHireType() != null){
            long time = lock.getEndTime().getTime()-new Date().getTime();
            if(1 == lock.getHireType()){
                int day = (int) (time/60/60/1000/24);
                jsonObject.put("remains", day+"天");
            }else{
                int hour = (int) (time/60/60/1000/24);
                jsonObject.put("remains", hour+"小时");
            }
        }
        return jsonObject;
    }
    
    public JSONObject build2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("name", lock.getName());
        jsonObject.put("battery", lock.getBattery());
        jsonObject.put("keyUser", lock.getKeyUser());
        jsonObject.put("keyAdmin", lock.getKeyAdmin());
        jsonObject.put("keyNumber", lock.getKeyNumber());
        jsonObject.put("keyDev", lock.getKeyDev());
        jsonObject.put("receiveFlag", lock.getReceiveFlag());
        jsonObject.put("remark", lock.getRemark());
        jsonObject.put("safeMode", lock.getSafeMode());
        jsonObject.put("mac", lock.getMac());
        jsonObject.put("deviceName", lock.getDeviceName());
        jsonObject.put("startTime", null);
        jsonObject.put("endTime", null);
        jsonObject.put("remains", null);
        if (lock.getStartTime() != null) {
            jsonObject.put("startTime", StringUtil.dateToStringByRep(lock.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (lock.getEndTime() != null) {
            jsonObject.put("endTime", StringUtil.dateToStringByRep(lock.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (lock.getKeys() != null && lock.getKeys().size() > 0){
            Collections.sort(lock.getKeys(), new LockKeyComparator());
            LockKey nearestKey = lock.getKeys().get(0);
            long time = nearestKey.getEndTime().getTime()-new Date().getTime();
            if(1 == nearestKey.getHireType()){
                int day = (int) (time/60/60/1000/24);
                jsonObject.put("remains", day+"天");
            }else{
                int hour = (int) (time/60/60/1000/24);
                jsonObject.put("remains", hour+"小时");
            }
        }
        return jsonObject;
    }
    public JSONObject build3() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("battery", lock.getBattery());
        if (lock.getSynTime() != null) {
            jsonObject.put("synTime", StringUtil.dateToStringByRep(lock.getSynTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return jsonObject;
    }
    
    public JSONObject build4() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("disturb", lock.getDisturb());
        jsonObject.put("battery", lock.getBattery());
        return jsonObject;
    }
    
    public JSONObject build5() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", lock.getId());
        jsonObject.put("name", lock.getName());
        jsonObject.put("battery", lock.getBattery());
        jsonObject.put("keyUser", lock.getKeyUser());
        jsonObject.put("keyAdmin", lock.getKeyAdmin());
        jsonObject.put("keyNumber", lock.getKeyNumber());
        jsonObject.put("keyDev", lock.getKeyDev());
        jsonObject.put("receiveFlag", lock.getReceiveFlag());
        jsonObject.put("remark", lock.getRemark());
        jsonObject.put("safeMode", lock.getSafeMode());
        jsonObject.put("mac", lock.getMac());
        jsonObject.put("deviceName", lock.getDeviceName());
        jsonObject.put("startTime", null);
        jsonObject.put("endTime", null);
        jsonObject.put("departmentType",lock.getDepartmentType());
        jsonObject.put("departmentAddress",lock.getDepartmentAddress());
        jsonObject.put("departmentNumber", lock.getDepartmentNumber());
        jsonObject.put("departmentPicture", lock.getDepartmentPicture());
        jsonObject.put("cusNumber",lock.getCustomerNumber());
        jsonObject.put("showType", lock.getShowType());
        if (lock.getStartTime() != null) {
            jsonObject.put("startTime", StringUtil.dateToStringByRep(lock.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (lock.getEndTime() != null) {
            jsonObject.put("endTime", StringUtil.dateToStringByRep(lock.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return jsonObject;
    }
}
