package com.dong.SE.reflect;

import com.dong.domain.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author dfx
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //获取student的class对象
        Class<Student> stuCls = Student.class;

        //getFields()获取所有public修饰的成员变量
        Field[] fields = stuCls.getFields();
        for (Field f : fields){
            System.out.println(f);
        }

        System.out.println("--------------");
        //getField()  也只能获取 public修饰的变量
        Field a = stuCls.getField("a");
        System.out.println(a);
        //获取变量name 的值
        Student stu = new Student();
        Object value = a.get(stu);
        System.out.println(value);
        //设置变量a的值
        a.set(stu,"a的值");
        System.out.println(a.get(stu));

        System.out.println("===============");
        //getDeclaredFields()  获取所有成员变量
        Field[] declaredFields = stuCls.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println(field);
        }
        //获取私有变量
        Field name = stuCls.getDeclaredField("name");
        //忽略访问权限修饰符的限制
        name.setAccessible(true);
        System.out.println(name.get(stu));
        name.set(stu,"张三");
        System.out.println(name.get(stu));
    }

    @Test
    public void testConstructors() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> studentClass = Student.class;
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }

        System.out.println("----------------");
        Constructor<Student> constructor = studentClass.getConstructor(String.class, Integer.class);
        System.out.println(constructor);

        Student stu = constructor.newInstance("张三", 15);
        System.out.println(stu);

        System.out.println("===============");
        Student stu2 = Student.class.newInstance();
        System.out.println(stu2);

    }
}
