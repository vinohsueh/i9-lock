package org.i9.lock.platform.api.quartz;

import java.util.Date;
import java.util.List;

import org.i9.lock.platform.model.Info;
import org.i9.lock.platform.model.LockKey;
import org.i9.lock.platform.service.InfoService;
import org.i9.lock.platform.service.LockKeyService;
import org.i9.lock.platform.utils.PushUtils;
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
    @Autowired
    private InfoService infoService;
	//每天查询一下结束时间
	@Scheduled(cron= "0 0 0 * * ?" ) //每天执行一次0*****
	public void stepTimer(){  
		//如果时间小于5，修改State
		lockKeyService.updateLockKeyState();
		//提醒租客续租，发送推送
		List<LockKey> lockKey = lockKeyService.getTime();
		if (!lockKey.isEmpty()) {
			for(LockKey key : lockKey){
				Integer keyId = key.getId();
				try {
					String valueOf = String.valueOf(keyId);
					PushUtils.sendPush(valueOf, "您好！租客账单即将到期，请重新生成账单进行续期！");
				} catch (Exception e) {
					e.getMessage();
				} finally {
			        Info info = new Info(); 
			        info.setUserId(key.getUserId());
			        info.setContent("您好！租客账单即将到期，请重新生成账单进行续期！");
			        info.setCreateTime(new Date());
			        infoService.addInfo(info);
				}
		       
			}
		}
	}  
}
