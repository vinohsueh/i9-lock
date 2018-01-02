package org.i9.lock.platform.core.controller;

import java.util.HashMap;

import org.i9.lock.platform.dao.vo.UserSearchDto;
import org.i9.lock.platform.model.User;
import org.i9.lock.platform.service.UserService;
import org.i9.lock.platform.utils.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.javac.util.List;

/**
 * 创建时间:2017年12月26日14:58:33
 * @author xph
 * @version
 */

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 分页查询
	 * @param userPageDto
	 * @return
	 */
	@RequestMapping("/pageUser") 
	public HashMap<String,Object> pageUser(@RequestBody UserSearchDto userSearchDto){
		HashMap<String, Object> result = new HashMap<String, Object>();
		PageBounds<User> pageBounds = userService.selectByLimitPage(userSearchDto, userSearchDto.getCurrentPage(), userSearchDto.getPageSize());
		result.put("data", pageBounds);
		return result;
	}
	
	/**
	 * 根据id查询
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getUser")
	public HashMap<String, Object>getUser(@RequestBody Long userId){
		HashMap<String, Object> result = new HashMap<String, Object>();
		User user = userService.getUserById(userId);
		result.put("data", user);
		return result;
	}
	
	 
}
