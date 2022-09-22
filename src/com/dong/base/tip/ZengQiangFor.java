package com.dong.base.tip;

public class ZengQiangFor {
    public static void main(String[] args) {
        int[] arr = {1,5,4,6,9};

        //增强for循环，重点是用来循环  数组 集合
        for (int x:arr){
            System.out.println(x);
        }

        int i = 0;
        if (i==0){
            System.out.println(i);
            System.out.println(6);
        }else{
            System.out.println(9);
        }
    }
}
