package com.dong.base;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            String operator = null;
            System.out.println("请输入你需要的操作（add、minus、multiply、divide）:");
            operator = scanner.next();
            switch(operator){
                case "add":
                    add();break;
                case "minus":
                    minus();break;
                case "multiply":
                    multiply();break;
                case "divide":
                    divide();break;
                default:
                    System.out.println("输入错误结束程序！");
                    continue;
            }

        }
    }

    private static void divide() {
        System.out.println("请输入第一个数：");
        double a = scanner.nextDouble();
        System.out.println("请输入第二个数：");
        double b = scanner.nextDouble();
        System.out.println("第一个数除以第二个数结果为："+(a/b));
    }

    private static void multiply() {
        System.out.println("请输入第一个数：");
        double a = scanner.nextDouble();
        System.out.println("请输入第二个数：");
        double b = scanner.nextDouble();
        System.out.println("第一个数乘以第二个数结果为："+(a*b));
    }

    private static void minus() {
        System.out.println("请输入第一个数：");
        double a = scanner.nextDouble();
        System.out.println("请输入第二个数：");
        double b = scanner.nextDouble();
        System.out.println("第一个数减第二个数结果为："+(a-b));
    }

    private static void add() {
        System.out.println("请输入第一个数：");
        double a = scanner.nextDouble();
        System.out.println("请输入第二个数：");
        double b = scanner.nextDouble();
        System.out.println("第一个数加第二个数结果为："+(a+b));
    }

}
