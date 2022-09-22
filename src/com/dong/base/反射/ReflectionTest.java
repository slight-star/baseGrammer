package com.dong.base.反射;

import com.dong.base.Person;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test() throws ClassNotFoundException {
        //方式1
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式2
        System.out.println('a');
        Person p1 = new Person();
        System.out.println('b');
        Class clazz2 = p1.getClass();

        System.out.println(clazz2);

        //方式3
        Class clazz3 = Class.forName("com.dong.base.Person");
        System.out.println(clazz3);

        //方式4
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.dong.base.Person");
        System.out.println(clazz4);
    }

    //如何操作运行时类中的指定的方法 --需要掌握
    @Test
    public void testMethod() throws Exception {
        //方式1
        //        Class clazz = Person.class;

        //方式2
//        Person p1 = new Person();
//        Class clazz = p1.getClass();

        //方式3  最常用，体现了反射的动态性
        String classPath = "com.dong.base.Person";
        Class clazz = Class.forName(classPath);
        //因为要调用的方法不是静态的，所以创建运行时类的对象
        Person p = (Person)clazz.newInstance();

        //1.获取指定的某个方法
        Method show = clazz.getDeclaredMethod("show", String.class);
        //2.保证方法是可访问的
        show.setAccessible(true);
        //3.调用方法的invoke方法
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.invoke(clazz);
    }

    //创建一个指定类的对象
    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
