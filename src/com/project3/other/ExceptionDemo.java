package com.project3.other;

public class ExceptionDemo {
    public static void main(String[] args) {
        try{
            Student stu = new Student();
            stu.regist(-1001);
            System.out.println("注册成功");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
