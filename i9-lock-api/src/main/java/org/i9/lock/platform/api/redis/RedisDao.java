package org.i9.lock.platform.api.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 
     * @param key
     * @param value
     */
    public String getValueByKey(String key) {
        if (key != null) {
            return this.stringRedisTemplate.opsForValue().get(key);
        }
        return null;
    }
    
    public void saveValue(String key,String value) {
        this.stringRedisTemplate.opsForValue().set(key, value);
    }
}
