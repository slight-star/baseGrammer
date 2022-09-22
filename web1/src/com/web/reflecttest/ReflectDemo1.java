package com.web.reflecttest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo1 {

    //使用反射操作普通发放
    @Test
    public void test4() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //得到class对象
        Class<Person> aClass = (Class<Person>) Class.forName("com.web.reflecttest.Person");
        //得到person实例
        Person person = aClass.newInstance();
        //得到普通方法
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        //执行普通方法
        setName.invoke(person, "bawu");
        System.out.println(person.getName());
    }

    //使用反射操作属性
    @Test
    public void test3() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //得到class对象
        Class<Person> aClass = (Class<Person>) Class.forName("com.web.reflecttest.Person");
        //得到person实例
        Person person = aClass.newInstance();
        //得到属性，参数是属性名称
        Field name = aClass.getDeclaredField("Name");
        //因为操作私有属性，所以要设置权限
        name.setAccessible(true);
        //设置属性
        name.set(person, "wangwu");
        System.out.println(person.getName());
    }

    //使用反射操作有参构造方法
    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //得到class对象
        Class<Person> aClass = (Class<Person>) Class.forName("com.web.reflecttest.Person");
        //获取所有的有参构造方法
//        aClass.getConstructors()  不常用
        //使用有参的构造方法
        Constructor<Person> constructor = aClass.getConstructor(String.class, String.class);
        //使用有参的构造方法，创建person类实例
        Person lisi = constructor.newInstance("200", "lisi");
        System.out.println(lisi.getID());

    }

    //使用反射操作无参构造方法
    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //得到class对象
        Class<Person> aClass = (Class<Person>) Class.forName("com.web.reflecttest.Person");
        //使用无参的构造方法，创建实例
        Person person = aClass.newInstance();
        person.setID("100");
        System.out.println(person.getID());
    }
}


