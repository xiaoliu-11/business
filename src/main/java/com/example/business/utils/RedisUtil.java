package com.example.business.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: 刘树国
 * @create: 2022-02-10
 */

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 存入数据到缓存
    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 通过key获得数据
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 存入数据到缓存并设置过期时间（单位为秒）
    public void setValueAndExpire(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    // 删除缓存
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
