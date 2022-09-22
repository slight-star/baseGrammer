package com.dong.base.tip;

public class PrimeNumber2 {
    public static void main(String[] args) {
        //输出1-10000质数和个数
        int count = 0;
        long start = System.currentTimeMillis();
        label:for (int i = 2; i <= 100000 ; i++)
        {
            for(int j = 2; j <= Math.sqrt(i); j++)
            {
                if (i % j == 0 )
                {
                    continue label;
                }
            }
            count++;
        }
        System.out.println("质数个数："+count);
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start));
    }
}
