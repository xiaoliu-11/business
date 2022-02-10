package com.example.business.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @author: 刘树国
 * @create: 2022-02-10
 */

public class RedisCacheManager implements CacheManager {

    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        System.out.println(cacheName);
        return null;
    }
}
