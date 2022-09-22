package com.dong.base.tip;

public class Change {
    public static void main(String[] args) {
        int num1 = 11;
        int num2 = 33;

        //交换两个变量
        //方式1：推荐 简单 通用性强
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1="+num1+",num2="+num2);

        //方式2：缺陷：只适用于数值变量；两个数相加后可能超过数值范围
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("num1="+num1+",num2="+num2);

        //方式3：缺陷：只适用于数值类型
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("num1="+num1+",num2="+num2);
    }
}
