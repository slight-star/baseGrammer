package com.dong.SE.reflect;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author dfx
 */
@MyAnno(className = "com.dong.domain.Student",methodName = "eat")
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.加载配置文件
        //1.1创建prop对象
        Properties prop = new Properties();
        //1.2加载配置文件,转换成一个集合
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        prop.load(is);

        //2.加载配置文件中的数据
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建该类的对象
        Object obj = cls.newInstance();
        //5.获取方法的对象
        Method method = cls.getMethod(methodName);
        //6.执行该方法
        method.invoke(obj);


    }

    //使用注解实现上面的案例
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.获取当前类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.使用当前类对象，获取当前的注解对象
        MyAnno annotation = reflectTestClass.getAnnotation(MyAnno.class);
        //3.使用注解对象获取类名和方法名
        String className = annotation.className();
        String methodName = annotation.methodName();
        //4.加载该类进内存
        Class cls = Class.forName(className);
        //5.创建该类的对象
        Object obj = cls.newInstance();
        //6.获取方法的对象
        Method method = cls.getMethod(methodName);
        //7.执行方法
        method.invoke(obj);

    }
}
