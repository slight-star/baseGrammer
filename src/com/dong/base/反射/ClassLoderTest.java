package com.dong.base.反射;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoderTest {
    @Test
    public void test() throws IOException {
        Properties props = new Properties();
        //方式一  此时文件默认在当前的module下
        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
        props.load(fis);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        System.out.println(user+' '+password);

        //方式二  此时文件默认在当前的module的src下
//        ClassLoader classLoader = ClassLoderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
//        props.load(is);
//
//        String user = props.getProperty("user");
//        String password = props.getProperty("password");
//        System.out.println(user+' '+password);
    }
}
