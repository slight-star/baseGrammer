package com.dong.SE.exception;

import java.util.Scanner;

/**
 * @author dfx
 */
public class ExceptionDemo2 {
    static String[] users = {"张三","李四","王五"};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要注册的用户名：");
        String name = sc.next();

        checkName(name);
    }

    private static void checkName(String name)  {
        for (String user : users){
            if (name.equals(user)){
                try {
                    throw new RegisterException2("该账号已注册");
                } catch (RegisterException2 registerException2) {
                    registerException2.printStackTrace();
                    return;
                }
            }
        }
        System.out.println("恭喜您注册成功！");
    }
}
