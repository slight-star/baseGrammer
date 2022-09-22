package com.dong.SE.exception;

import java.util.Scanner;

/**
 * @author dfx
 */
public class ExceptionDemo {
    static String[] users = {"张三","李四","王五"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要注册的用户名：");
        String name = sc.next();

        checkName(name);
    }

    private static void checkName(String name) {
        for (String user : users){
            if (name.equals(user)){
                throw new RegisterException("该账号已注册");
            }
        }
        System.out.println("恭喜您注册成功！");
    }
}
