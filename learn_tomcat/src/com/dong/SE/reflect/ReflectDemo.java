package com.dong.SE.reflect;

import com.dong.domain.Student;

/**
 * @author dfx
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取class对象的3种方式
        //1.Class.forname("全类名")
        Class cls1 = Class.forName("com.dong.domain.Student");
        System.out.println(cls1);

        //2.类名.class
        Class<Student> cls2 = Student.class;
        System.out.println(cls2);

        //3.对象.getClass()
        Student stu = new Student();
        Class cls3 = stu.getClass();
        System.out.println(cls3);

        System.out.println(cls1 == cls2);//true
        System.out.println(cls1 == cls3);//true
    }
}
