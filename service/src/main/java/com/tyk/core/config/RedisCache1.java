package com.tyk.core.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DigestUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache1 implements Cache {

    private static final Log logger = LogFactory.getLog(RedisCache1.class);
    private String id;
    private static RedisTemplate redisTemplate;
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static final long EXPRIRE_TIME_IN_MINUT = 60;
    private final String COMMON_CACHE_KEY = "com:tyk:";

    public RedisCache1(String id) {
        if (id == null) {
            throw new IllegalArgumentException("缓存对象的id不能为空");
        }
        this.id = id;
    }

    private String getKeys() {
        return COMMON_CACHE_KEY + ":*";
    }

    private Object getKey(Object key) {
        return COMMON_CACHE_KEY + this.id + DigestUtils.sha1DigestAsHex(String.valueOf(key));
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public static void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache1.redisTemplate = redisTemplate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            redisTemplate.opsForValue().set(getKey(o), o1, EXPRIRE_TIME_IN_MINUT, TimeUnit.MINUTES);
            logger.info("缓存对象保存成功，key:"+getKey(o));
        } catch (Throwable throwable) {
            logger.error("异常："+throwable);
            logger.error("缓存对象保存失败，key:"+getKey(o));
        }
    }

    @Override
    public Object getObject(Object o) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            Object result = redisTemplate.opsForValue().get(getKey(o));
            logger.info("缓存对象获取成功，key:"+getKey(o));
            return result;
        } catch (Throwable throwable) {
            logger.error("缓存对象获取失败，key:"+getKey(o));
            return null;
        }
    }

    @Override
    public Object removeObject(Object o) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            redisTemplate.delete(getKey(o));
            logger.info("删除缓存对象成功，key:"+getKey(o));
        } catch (Throwable throwable) {
            logger.error("删除缓存对象失败，key:"+getKey(o));
        }
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        Set<String> keys = redisTemplate.keys(getKeys());
        redisTemplate.delete(keys);
        logger.debug("清空缓存对象成功keys："+keys);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
