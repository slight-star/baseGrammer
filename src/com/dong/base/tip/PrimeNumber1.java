package com.dong.base.tip;

public class PrimeNumber1 {
    public static void main(String[] args) {
        //输出1-10000质数和个数
        int count = 0;
        long start = System.currentTimeMillis();
        boolean flag;
        for (int i = 2; i <= 100000 ; i++)
        {
            flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++)
            {
                if (i % j == 0 )
                {
                    flag = false;
                    break;
                }
            }
            if (flag == true)
            {
                //System.out.println(i);
                count++;
            }
        }
        System.out.println("质数个数："+count);
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start));
    }
}
