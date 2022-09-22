package com.dong.base.tip;

public class ZhiShu {
    public static void main(String[] args) {
        //输出1-150的质数
        int m = 0;
        for (int i=1; i<=150; i++){
            int j = 2;
            for (; j<i/2; j++){
                if (i%j==0){
                    break;
                }
            }
            if (i==2 || j==(i/2)){
                System.out.print(i+" ");
                m++;
                if (m%3==0){
                    System.out.println();
                }
            }

        }
    }
}
