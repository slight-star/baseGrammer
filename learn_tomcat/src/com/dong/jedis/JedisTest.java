package com.dong.jedis;

import com.dong.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dfx
 */
public class JedisTest {
    //对字符串操作
    @Test
    public void test(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","zhangsan");
        jedis.set("password","1234");

        //获取值
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()存储可以指定过期时间的key value
        jedis.setex("activeCode",20,"654897");
        //3.关闭连接
        jedis.close();
    }

    //对哈希操作
    @Test
    public void test2(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");

        Map<String, String> user = jedis.hgetAll("user");

        for(String key : user.keySet()){
            System.out.println(key + ":" + user.get(key));
        }

        jedis.close();
    }

    //对list操作
    @Test
    public void test3(){
        Jedis jedis = new Jedis();

//        jedis.lpush("mylist","a","b","c");
//        jedis.rpush("mylist","a","b","c");

        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        jedis.rpop("mylist");

        mylist = jedis.lrange("mylist",0,-1);
        System.out.println(mylist);

        jedis.del("mylist");
        mylist = jedis.lrange("mylist",0,-1);
        System.out.println(mylist);
        jedis.close();
    }

    //对set操作
    @Test
    public void test4(){
        Jedis jedis = new Jedis();

        jedis.sadd("myset","java","pandas","springboot");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.srem("myset","pandas");
        myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.close();
    }

    //对sortedSet操作
    @Test
    public void test5(){
        Jedis jedis = new Jedis();

//        jedis.zadd("mysortedset",5,"zhangsan");
//        jedis.zadd("mysortedset",8,"lisi");
//        jedis.zadd("mysortedset",50,"wangwu");
//        jedis.zadd("mysortedset",5,"zhaoliu");
//        jedis.zadd("mysortedset",5,"dongwang");
        jedis.zadd("mysortedset",5,"zhangsan5");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);
        jedis.close();
    }

    //jedis 连接池
    @Test
    public void test6(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);//最大连接数
        config.setMaxIdle(10);//最大空闲数

        //1.创建连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("haha","hello");

        //关闭，归还到连接池
        jedis.close();

    }

    //jedis 连接池
    @Test
    public void test7(){
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("lalala","啦啦啦");

        jedis.close();
    }
}
