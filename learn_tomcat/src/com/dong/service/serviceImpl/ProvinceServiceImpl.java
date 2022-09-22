package com.dong.service.serviceImpl;

import com.dong.dao.ProvinceDao;
import com.dong.dao.daoImpl.ProvinceDaoImpl;
import com.dong.domain.Province;
import com.dong.service.ProvinceService;
import com.dong.util.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author dfx
 */
public class ProvinceServiceImpl implements ProvinceService{
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findProvince() {
        List<Province> province = dao.findProvince();
        return province;
    }

    //使用redis缓存
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        //1.2查询省份数据
        String province_json = jedis.get("province");
        //2.判断是否为null
        if(province_json == null || province_json.length()==0){
            //没有缓存
            System.out.println("redis没有缓存，查询数据库");
            //2.1从数据库中查询
            List<Province> province = dao.findProvince();
            //2.2转换为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(province);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将json数据存入redis
            jedis.set("province",province_json);
            //3.关闭jedis
            jedis.close();
        }else{
            //有缓存
            System.out.println("redis有缓存数据,查询缓存");
        }

        return province_json;
    }
}
