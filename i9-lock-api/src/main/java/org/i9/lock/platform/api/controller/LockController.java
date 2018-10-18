package org.i9.lock.platform.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.i9.lock.platform.api.component.LockKeyPriceComponent;
import org.i9.lock.platform.api.component.LockListInfoComponent;
import org.i9.lock.platform.api.component.LockPriceComponent;
import org.i9.lock.platform.dao.vo.LockAddDto;
import org.i9.lock.platform.dao.vo.LockReleaseDto;
import org.i9.lock.platform.dao.vo.LockSearchDto;
import org.i9.lock.platform.dao.vo.LockUpdateDto;
import org.i9.lock.platform.dao.vo.UserLongPasswordDto;
import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.model.Lock;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.InfoService;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.service.LockService;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.DateUtils;
import org.i9.lock.platform.utils.PageBounds;
import org.i9.lock.platform.utils.PushUtils;
import org.i9.lock.platform.utils.ThumbPicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.jiguang.common.utils.StringUtils;

/** 
 * 创建时间：2017年11月22日 下午4:47:21
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("lock")
public class LockController {
    
	/*private static final String ROOT_PATH = "/usr/local/lockPic/";*/
	
	private static final String ROOT_PATH="/F:\\";
	
    @Autowired
    private LockService lockService;
    @Autowired
    private UserService userService;
    @Autowired
    private LockKeyService lockKeyService;
    @Autowired
    private InfoService infoService;
    
    /**
     * 添加锁(无照片)
     * @param lockAddDto
     * @param bindingResult 
     * @return
     */
    @RequestMapping(value={"/saveNoPicture"},method = {RequestMethod.POST})
    public HashMap<String, Object> saveLock(LockAddDto lockAddDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
            User user = userService.getCurrentUser();
            Lock lock = lockAddDto.getLock();
            lock.setUserId(user.getId());
            lockService.addLock(lock);
            String valueOf = String.valueOf(user.getId());
            PushUtils.sendPush(valueOf, "您好！绑定门锁成功，欢迎使用常通物联智能门锁。");
            Info info = new Info(); 
            info.setUserId(user.getId());
            info.setContent("您好！绑定门锁成功，欢迎使用常通物联智能门锁。");
            info.setCreateTime(new Date());
            infoService.addInfo(info);
        return result;
    }
    
    /**
     * 添加锁(有照片)
     * @param lockAddDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value={"/save"},method = {RequestMethod.POST})
    public HashMap<String, Object> saveLock(LockAddDto lockAddDto,BindingResult bindingResult
    		,@RequestParam(value = "uploadHead", required = false) MultipartFile uploadFile,
            HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*"); //生产环境绝对不允许设置为“*”
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> result = new HashMap<String, Object>();
        try {
        	//获得文件扩展名
            String ext = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
            //使用UUID产生一个随机的通用唯一识别码 加上 扩展名 组成一个一个新的文件名
            String filename = UUID.randomUUID().toString() +"."+ext;
            //压缩文件到900kb以内
            ThumbPicUtil.commpressPicForScale(uploadFile.getInputStream(), ROOT_PATH + filename, 900, 0.8);
            if(StringUtils.isNotEmpty(filename)) {
                User user = userService.getCurrentUser();
                Lock lock = lockAddDto.getLock();
                lock.setUserId(user.getId());
                lock.setDepartmentPicture(filename); 
                lock.setSynTime(new Date());
                lockService.addLock(lock);
                //推送
                String valueOf = String.valueOf(user.getId());
                PushUtils.sendPush(valueOf, "您好！绑定门锁成功，欢迎使用常通物联智能门锁。");
                Info info = new Info(); 
                info.setUserId(user.getId());
                info.setContent("您好！绑定门锁成功，欢迎使用常通物联智能门锁。");
                info.setCreateTime(new Date());
                infoService.addInfo(info);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return result;
    }
    
    /**
     * 更新锁
     * @param lock
     * @return
     */
    @RequestMapping(value={"/update"},method = {RequestMethod.POST} )
    public HashMap<String, Object> updateLock(@Valid Lock lock ,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.updateLock(lock);
        return result;
    }
    
    /**
     * 更换门锁
     * @param lock
     * @return
     */
    @RequestMapping(value={"/updateLockes"},method = {RequestMethod.POST} )
    public HashMap<String, Object> updateLocks(@Valid LockUpdateDto lockDto ,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.updateLockes(lockDto);
        User user = userService.getCurrentUser();
        //推送
        List<LockKey> lockKey = lockKeyService.getLockKeyByLockId(lockDto.getId());
        if (!lockKey.isEmpty()) {
			for(LockKey Key : lockKey){
				Integer keyId = Key.getId();
				String valueOf = String.valueOf(keyId);
				PushUtils.sendPush(valueOf, "您好！更换门锁成功，常通物联智能门锁欢迎您的再次使用。");
				 Info info = new Info(); 
		            info.setUserId(Key.getUserId());
		            info.setContent("您好！更换门锁成功，常通物联智能门锁欢迎您的再次使用。");
		            info.setCreateTime(new Date());
		            infoService.addInfo(info);
			}
		}
        String valueOf = String.valueOf(user.getId());
        PushUtils.sendPush(valueOf, "您好！更换门锁成功，常通物联智能门锁欢迎您的再次使用。");
        Info info = new Info(); 
        info.setUserId(user.getId());
        info.setContent("您好！更换门锁成功，常通物联智能门锁欢迎您的再次使用。");
        info.setCreateTime(new Date());
        infoService.addInfo(info);
        return result;
    }
    
    /**
     * 修改水电煤气
     * @param lock
     * @return
     */
    @RequestMapping(value={"/updateLocks"},method = {RequestMethod.POST} )
    public HashMap<String, Object> updateLocks(Lock lock){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        lockService.updateLocks(lock);
      //推送
        List<LockKey> lockKey = lockKeyService.getLockKeyByLockId(lock.getId());
        if (!lockKey.isEmpty()) {
			for(LockKey Key : lockKey){
				Integer keyId = Key.getId();
				String valueOf = String.valueOf(keyId);
				PushUtils.sendPush(valueOf, "您好！水，电，燃气，物业费进行了重新修改。");
				 Info info = new Info(); 
		            info.setUserId(Key.getUserId());
		            info.setContent("您好！水，电，燃气，物业费进行了重新修改。");
		            info.setCreateTime(new Date());
		            infoService.addInfo(info);
			}
		}
        String valueOf = String.valueOf(user.getId());
        PushUtils.sendPush(valueOf, "您好！水，电，燃气，物业费进行了重新修改。");
        Info info = new Info(); 
        info.setUserId(user.getId());
        info.setContent("您好！水，电，燃气，物业费进行了重新修改。");
        info.setCreateTime(new Date());
        infoService.addInfo(info);
        return result;
    }
    
    /**
     * 设备列表（分页）
     * @param lockSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value={"/list"},method = {RequestMethod.POST})
    public HashMap<String, Object> list(LockSearchDto lockSearchDto,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockSearchDto.setOrderByClause("createTime desc");
        PageBounds<Lock> pageBounds = lockService.selectByLimitPage(lockSearchDto, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Lock lock : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build();
            jsonArray.add(jsonObject);
        }
        result.put("locks", jsonArray);
        return result;
    }
    
    /**
     * 该用户是房东的所有房屋或者租的房子（不分页）
    * @Title: Alllock 
    * @Description: TODO
    * @param lockExample
    * @return
     */
    @RequestMapping(value={"/Alllock"},method = {RequestMethod.POST})
    public HashMap<String, Object> Alllock(LockSearchDto lockSearchDto){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockSearchDto.setOrderByClause("createTime desc");
        User user = userService.getCurrentUser();
        lockSearchDto.setUserId(user.getId()); 
        //若该用户是房东
        List<Lock> listLock = lockService.selectByLockDto(lockSearchDto);
        //若该用户是租户
        List<Lock> listLock2 = lockService.selectByLockKeyDto(lockSearchDto);
        JSONArray jsonHouseHold = new JSONArray();
        JSONArray jsonTenant = new JSONArray();
        for (Lock lock : listLock) { 
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build();
            jsonHouseHold.add(jsonObject);
        }
        for (Lock lock : listLock2) { 
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build();
            jsonTenant.add(jsonObject);
        }
        result.put("jsonHouseHold", jsonHouseHold);
        result.put("jsonTenant", jsonTenant);
        return result;
    }

    
    /**
     * 物业缴费
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/price"},method = {RequestMethod.POST})
    public HashMap<String, Object> price(Long lockId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Lock lock = lockService.getLockById(lockId);
        int keyCount = lockKeyService.selectLockKeyCountByLockId(lockId); 
        lock.setCusNumber(keyCount); 
        if (lock != null) {
            JSONObject jsonObject = new LockPriceComponent().setLock(lock).build();
            result.put("lock", jsonObject);
        }
        List<LockKey> lockKeys = lockKeyService.getLockKeyByLockId(lockId);
        JSONArray jsonArray = new JSONArray();
        for (LockKey lockKey : lockKeys) {
            JSONObject jsonObject = new LockKeyPriceComponent().setLockKey(lockKey).build();
            jsonArray.add(jsonObject);
        }
        result.put("keys", jsonArray);
        return result;
    }
    
    /**
     * 移交锁验证
     * @param lockReleaseDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value={"/releaseValidate"},method = {RequestMethod.POST})
    public HashMap<String, Object> releaseValidate(@Valid LockReleaseDto lockReleaseDto,BindingResult bindingResult){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.releaseLockValidate(lockReleaseDto);
        return result;
    }
    
    /**
     * 移交锁
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/release"},method = {RequestMethod.POST})
    public HashMap<String, Object> release(Lock lock){
    	User user = userService.getCurrentUser();
        HashMap<String, Object> result = new HashMap<String, Object>();
        lock.setShowType(1);
        lock.setDisturb(0);
        lock.setClickLock(0);
        lockService.updateLock(lock);
        UserLongPasswordDto userLongPasswordDto = new UserLongPasswordDto();
        userLongPasswordDto.setLockId(lock.getId());
        userLongPasswordDto.setUserId(user.getId());
        lockService.deletePwdByUidAndLockId(userLongPasswordDto);
        result.put("移交成功", "移交成功"); 
        List<LockKey> lockKey = lockKeyService.getLockKeyByLockId(lock.getId());
        if (!lockKey.isEmpty()) {
			for(LockKey Key : lockKey){
				Integer keyId = Key.getId();
				String valueOf = String.valueOf(keyId);
				PushUtils.sendPush(valueOf, "解绑门锁成功，常通物联智能门锁为您提供安全保障。");
				 Info info = new Info(); 
	             info.setUserId(Key.getUserId());
	             info.setContent("解绑门锁成功，常通物联智能门锁为您提供安全保障。");
	             info.setCreateTime(new Date());
	             infoService.addInfo(info);
			}
		}
        String valueOf = String.valueOf(user.getId());
        PushUtils.sendPush(valueOf, "解绑门锁成功，常通物联智能门锁为您提供安全保障。");
        Info info = new Info(); 
        info.setUserId(user.getId());
        info.setContent("解绑门锁成功，常通物联智能门锁为您提供安全保障。");
        info.setCreateTime(new Date());
        infoService.addInfo(info);
        return result;
    }
    
    /**
     * 租户设备列表
     * @return
     */
    @RequestMapping(value={"/authorizeList"},method = {RequestMethod.POST})
    public HashMap<String, Object> authorizeList(LockSearchDto lockSearchDto,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        lockSearchDto.setUserId(user.getId());
        lockSearchDto.setOrderByClause("createTime desc");
        PageBounds<Lock> pageBounds = lockService.selectAuthorizeLocks(lockSearchDto, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Lock lock : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build1();
            jsonArray.add(jsonObject);
        }
        result.put("locks", jsonArray);
        return result;
    }
    
    /**
     * 房东设备列表
     * @return
     */
    @RequestMapping(value={"/landlordKey"},method = {RequestMethod.POST})
    public HashMap<String, Object> landlordKey(LockSearchDto lockSearchDto,int currectPage, int pageSize){
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        lockSearchDto.setOrderByClause("createTime desc");
        lockSearchDto.setUserId(user.getId());
        PageBounds<Lock> pageBounds = lockService.selectByLimitPage(lockSearchDto, currectPage,pageSize);
        JSONArray jsonArray = new JSONArray();
        for (Lock lock : pageBounds.getPageList()) {
            JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build2();
            jsonArray.add(jsonObject);
        }
        result.put("locks", jsonArray);
        return result;
    }
    
    /**
     * 更新租房类型
     * @return
     */
    @RequestMapping(value={"/updateDepartmentType"},method = {RequestMethod.POST} )
    public HashMap<String, Object> updateDepartmentType(Integer lockId, Integer departmentType){
        HashMap<String, Object> result = new HashMap<String, Object>();
        lockService.updateDepartmentType(lockId,departmentType);
        return result;
    }
    
    /**
     * 双认证
     * @return
     */
    @RequestMapping(value={"/updateClickLock"},method = {RequestMethod.POST} )
    public HashMap<String, Object> updateClickLock(UserLongPasswordDto userLongPasswordDto){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Lock lock = lockService.getLockById(userLongPasswordDto.getLockId());
        lock.setBattery(userLongPasswordDto.getBattery());
        lockService.updateLock(lock);
        lockService.updateClickByUidAndLockId(userLongPasswordDto);
        return result;
    }
    
    /**
     * 获取认证状态
     * @param lockId
     * @return
     */
    @RequestMapping(value={"/getClickLock"},method = {RequestMethod.POST})
    public HashMap<String, Object> getClickLock(UserLongPasswordDto userLongPasswordDto){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Integer clickLock = lockService.getClickByUidAndLockId(userLongPasswordDto);
        if(null !=clickLock) {
        	result.put("clickLock", clickLock);
        }else {
        	result.put("clickLock", false);
        }
		return result;
    }
    
    /**
     * 获取报警时间
    * @Title: getLockWarnTime 
    * @Description: TODO
    * @param lockId
    * @return
     */
    @RequestMapping(value={"/getLockWarnTime"},method = {RequestMethod.POST})
    public HashMap<String, Object> getLockWarnTime(Long lockId){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	String WarnTime = lockService.getLockWarnTime(lockId);
    	result.put("lockWarnTime", WarnTime);
    	return result;
    }
    
    /**
     * 查询最近修改的keyAdmin的时间
    * @Title: getKeyAdminUptime
    * @Description: TODO
    * @param lockId
    * @return
     */
    @RequestMapping(value={"/getKeyAdminUptime"},method = {RequestMethod.POST})
    public HashMap<String, Object> getKeyAdminUptime(Long lockId){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	Date keyAdminUptime = lockService.getKeyAdminUptime(lockId);
    	String dateToString = DateUtils.dateToString(keyAdminUptime);
    	result.put("keyAdminUptime", dateToString);
    	return result;
    }
    
    /**
     * 更改报警时间
    * @Title: updapteLockWarnTime 
    * @Description: TODO
    * @param lock
    * @return
     */
    @RequestMapping(value={"/updapteLockWarnTime"},method = {RequestMethod.POST})
    public HashMap<String, Object> updapteLockWarnTime(Lock lock){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	lockService.updateLock(lock);
    	return result;
    }
    
    /**
     * 更改keyAdmin的时间
    * @Title: updapteKeyAdminUptime
    * @Description: TODO
    * @param lock
    * @return
     */
    @RequestMapping(value={"/updateKeyAdminUptime"},method = {RequestMethod.POST})
    public HashMap<String, Object> updateKeyAdminUptime(Lock lock){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	Date date = new Date();
    	lock.setUpdateKeyDate(date);
    	lockService.updateLock(lock);
    	return result;
    }
    
    
    /**
     * 同步锁的时间
    * @Title: updateSynTime
    * @Description: TODO
    * @param lock
    * @return
     */
    @RequestMapping(value={"/updateSynTime"},method = {RequestMethod.POST})
    public HashMap<String, Object> updateSynTime(Lock lock){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	lock.setSynTime(new Date());
    	lockService.updateLock(lock);
    	return result;
    }
    
    /**
     * 获取同步锁的时间
    * @Title: updateSynTime
    * @Description: TODO
    * @param lock
    * @return
     */
    @RequestMapping(value={"/getSynTime"},method = {RequestMethod.POST})
    public HashMap<String, Object> getSynTime(Long lockId){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	Lock lock = lockService.getLockById(lockId);
    	JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new LockListInfoComponent().setLock(lock).build3();
        jsonArray.add(jsonObject);
        result.put("lock", jsonArray);
    	return result;
    }
    
    /**
     * 更新免打扰
    * @Title: updateDisturb
    * @Description: TODO
    * @param lock
    * @return
     */
    @RequestMapping(value={"/updateDisturb"},method = {RequestMethod.POST})
    public HashMap<String, Object> updateDisturb(Lock lock){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	lockService.updateLock(lock);
    	return result;
    }
    
    /**
     * 获取免打扰
    * @Title: getDisturb
    * @Description: TODO
    * @param lock
    * @return
     */
    @RequestMapping(value={"/getDisturb"},method = {RequestMethod.POST})
    public HashMap<String, Object> getDisturb(Long lockId,String battery){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	Lock lock = lockService.getLockById(lockId);
    	lock.setBattery(battery);
        lockService.updateLock(lock);
        result.put("disturb", lock.getDisturb());
    	return result;
    }
    
    /**
     * 根据lockId查询长密码
    * @Title: getPwdByUidAndLockId
    * @param @param userLongPassword
    * @param @return
    * @return HashMap<String,Object>
     */
    @RequestMapping("/getPwdByUidAndLockId")
    public HashMap<String, Object> getPwdByUidAndLockId(UserLongPasswordDto userLongPassword){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	User currentUser = userService.getCurrentUser();
    	userLongPassword.setUserId(currentUser.getId());
    	String userLongPwd = lockService.getPwdByUidAndLockId(userLongPassword);
    	if(StringUtils.isNotEmpty(userLongPwd)) {
    		result.put("userLongPwd", true);
    	}else {
			result.put("userLongPwd", false);
		}
    	return result;
    }
    
    /**
     * 新增
    * @Title: insertPwdByUidAndLockId
    * @param @param userLongPassword
    * @param @return
    * @return HashMap<String,Object>
     */
    @RequestMapping("/insertPwdByUidAndLockId")
    public HashMap<String, Object> insertPwdByUidAndLockId(UserLongPasswordDto userLongPassword){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	Lock lock = lockService.getLockById(userLongPassword.getLockId());
    	lock.setBattery(userLongPassword.getBattery());
        lockService.updateLock(lock);
    	User currentUser = userService.getCurrentUser();
    	userLongPassword.setUserId(currentUser.getId());
    	lockService.insertPwdByUidAndLockId(userLongPassword);
    	return result;
    }
    
    /**
     * 删除
    * @Title: insertPwdByUidAndLockId
    * @param @param userLongPassword
    * @param @return
    * @return HashMap<String,Object>
     */
    @RequestMapping("/deletePwdByUidAndLockId")
    public HashMap<String, Object> deletePwdByUidAndLockId(UserLongPasswordDto userLongPassword){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	User currentUser = userService.getCurrentUser();
    	userLongPassword.setUserId(currentUser.getId());
    	lockService.deletePwdByUidAndLockId(userLongPassword);
    	result.put("success", "success");
    	return result;
    }
    
    /**
     * 新增双认证
    * @Title: insertPwdByUidAndLockId
    * @param @param userLongPassword
    * @param @return
    * @return HashMap<String,Object>
     */
    @RequestMapping("/insertClickByUidAndLockId")
    public HashMap<String, Object> insertClickByUidAndLockId(UserLongPasswordDto userLongPassword){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	Lock lock = lockService.getLockById(userLongPassword.getLockId());
    	lock.setBattery(userLongPassword.getBattery());
        lockService.updateLock(lock);
    	lockService.insertClickByUidAndLockId(userLongPassword);
    	return result;
    }
}
