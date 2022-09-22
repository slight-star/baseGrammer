package com.dong.json;

import com.dong.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author dfx
 */
@SuppressWarnings("all")
public class jsonTest {

    @Test
    public void test() throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("asd");
        user.setPassword("123");
        user.setBirth(new Date());

        //创建jackson对象，将java对象转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //将数据写到文件中
        mapper.writeValue(new File("d://a.txt"),user);
        mapper.writeValue(new FileOutputStream(new File("d://b.txt")),user);
    }

    @Test
    public void test1() throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("asd");
        user.setPassword("123");

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("asd");
        user1.setPassword("123");

        User user2 = new User();
        user2.setId(1);
        user2.setUsername("asd");
        user2.setPassword("123");

        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);

        //创建jackson对象，将java对象转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);

    }

    @Test
    public void test2() throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("asd");
        user.setPassword("123");

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());

        //创建jackson对象，将java对象转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);

        //将数据写到文件中
//        mapper.writeValue(new File("d://a.txt"),user);
//        mapper.writeValue(new FileOutputStream(new File("d://b.txt")),user);
    }

    @Test
    public void test3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(new File("d://a.txt"), User.class);
        System.out.println(user);
    }
}
