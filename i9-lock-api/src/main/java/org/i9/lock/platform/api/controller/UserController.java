package org.i9.lock.platform.api.controller;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.i9.lock.platform.api.component.UserIndexInfoComponent;
import org.i9.lock.platform.dao.vo.PwdDto;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.EncryptUtils;
import org.i9.lock.platform.utils.ThumbPicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import cn.jiguang.common.utils.StringUtils;

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

	private static final String ROOT_PATH = "/usr/local/lockPic/";
	
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
        User currentUser = userService.login(user);
        byte [] a = EncryptUtils.longToBytes(currentUser.getId());
        byte [] b = new byte[a.length-1];
        System.arraycopy(a, 1, b, 0, b.length);
        String keyAdmin = EncryptUtils.bytesToHexString(b);
        result.put("account", keyAdmin);
        result.put("id", currentUser.getId());
        return result;
    }
    
    /**
     * 注册
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping("/regist")
    public HashMap<String, Object> regist(@Valid User user,BindingResult bindingResult,@RequestParam(value = "uploadHead", required = false) MultipartFile uploadFile,
            HttpServletRequest request,HttpServletResponse response) throws Exception  {
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
        			user.setHeadPicture(filename); 
        		}
        		userService.regist(user); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    /**
     * 注册无照片
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping("/registNoPicture")
    public HashMap<String, Object> registNoPicture(@Valid User user,BindingResult bindingResult
            ) throws Exception  {
    	HashMap<String, Object> result = new HashMap<String, Object>();
        try {
        	 userService.regist(user); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    
    /**
     * 更新亲情号
     * @param phone
     * @return
     */
    @RequestMapping("/updateFamilyPhone")
    public HashMap<String, Object> updateFamilyPhone(@Valid @NotBlank(message="手机号不能为空") @Pattern(regexp = "^1[3|4|5|6|7|8][0-9]\\d{8}$", message = "请输入正确的手机号")String phone) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        userService.updateFamilyPhone(phone);
        return result;
    }
    
    /**
     * 更新密码
     * @param phone
     * @return
     */
    @RequestMapping("/updatePwd")
    public HashMap<String, Object> updatePwd(@Valid PwdDto pwdDto,BindingResult bindingResult) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        userService.updatePwd(pwdDto);
        return result;
    }
    
    /**
     * 个人中心
     * @return
     */
    @RequestMapping("/index")
    public HashMap<String, Object> index() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        User user = userService.getCurrentUser();
        JSONObject jsonObject = new UserIndexInfoComponent().setUser(user).build();
        result.put("user", jsonObject);
        return result;
    }
    
    /**
     * 更换用户头像
    * @Title: updateUserHeadPicture 
    * @Description: TODO
    * @param user
    * @param bindingResult
    * @param uploadFile
    * @param request
    * @param response
    * @return
     */
    @RequestMapping("/updateUserHeadPicture")
    public HashMap<String, Object>updateUserHeadPicture(User user ,BindingResult bindingResult,@RequestParam(value = "uploadHead", required = false) MultipartFile uploadFile,
            HttpServletRequest request,HttpServletResponse response){
    	response.setHeader("Access-Control-Allow-Origin", "*"); //生产环境绝对不允许设置为“*”
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> result = new HashMap<String, Object>();
        User loginUser = userService.getCurrentUser();
        user.setId(loginUser.getId()); 
        try {
        		//获得文件扩展名
        		String ext = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
        		//使用UUID产生一个随机的通用唯一识别码 加上 扩展名 组成一个一个新的文件名
        		String filename = UUID.randomUUID().toString() +"."+ext;
        		//压缩文件到900kb以内
        		ThumbPicUtil.commpressPicForScale(uploadFile.getInputStream(), ROOT_PATH + filename, 900, 0.8);
        		if(StringUtils.isNotEmpty(filename)) { 
        			user.setHeadPicture(filename); 
        		}
        		userService.updateUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    /**
     * 更改用户信息（除了头像，密码，亲情号）
    * @Title: updateUserInfo 
    * @Description: TODO
    * @return
     */
    @RequestMapping("/updateUserInfo")
    public HashMap<String, Object>updateUserInfo(User user){
    	 HashMap<String, Object> result = new HashMap<String, Object>();
    	 User loginUser = userService.getCurrentUser();
    	 try {
    		 user.setId(loginUser.getId());
    		 userService.updateUser(user); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result; 
    }
}
