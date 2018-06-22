package org.i9.lock.platform.api.quartz;

import org.i9.lock.platform.service.LockKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/** 
* 创建时间：2018年4月19日 上午9:50:13
* @author  lby
* @version  
* 
*/
@Configuration          //证明这个类是一个配置文件  
@EnableScheduling       //打开quartz定时器总开关  
public class Timer {
	
	@Autowired
	private LockKeyService lockKeyService;
	//每天查询一下结束时间
	@Scheduled(cron= "0/5 * * * * ?" ) //每天执行一次
	public void stepTimer(){  
		//批量处理问题设备
		lockKeyService.updateLockKeyState();
	}  
}
