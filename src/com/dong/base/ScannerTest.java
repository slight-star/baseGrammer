package com.dong.base;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据");
        if (scanner.hasNextInt()){
            int i = scanner.nextInt();
            System.out.println("刚刚输入的内容为："+i);
        }else{
            System.out.println("不是整数");
        }
        scanner.close();
    }
}
