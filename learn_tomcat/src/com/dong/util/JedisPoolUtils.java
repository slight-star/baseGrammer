package com.dong.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author dfx
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static{
        //获取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPooolConfig
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));

        //初始化jedisPool
        jedisPool = new JedisPool(config,prop.getProperty("host"),Integer.parseInt(prop.getProperty("port")));

    }

    //获取连接
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }


}
