package com.dong.SE.reflect;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dfx
 */
public class TestCheck {
    //测试计算器类的所有含有@Check 的方法
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IOException {
        //0.创建一个计算器类对象
        Calculator2 calculator = new Calculator2();
        //1.获取计算器类
        Class calculatorClass = calculator.getClass();
        //2.获取计算器类的所有方法
        Method[] methods = calculatorClass.getMethods();

        int number = 0;//记录出现异常的次数
        //日志文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("learn_tomcat/src/bug.txt"));

        //3.遍历方法
        for (Method method : methods){
            //4.判断是否有check注解
            if (method.isAnnotationPresent(Check.class)){
                //5.如果有,执行该方法
                try {
                    method.invoke(calculator);
                }catch (Exception e) {
                    //6.捕获异常，记录到日志文件中
                    number++;

                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------");
                    bw.newLine();
                }
            }
        }

        bw.write("一共出现了"+number+"次异常");
        bw.newLine();

        bw.close();
    }
}
