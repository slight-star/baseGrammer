package com.dong.SE.dataStructure;

/**
 * @author dfx
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(5,'A','B','C');
    }

    private static void hanoi(int n, char a, char b, char c) {
        if (n == 1){
            System.out.println("第1个盘子从"+a+"移到"+c);
        }else {
            //a上面的除了最后一个盘子，剩余全部移到 b 里面
            hanoi(n-1,a,c,b);
            //a上最后一个盘子移到c
            System.out.println("第"+n+"个盘子从"+a+"移到"+c);
            //b上所有盘子移到c
            hanoi(n-1,b,a,c);
        }
    }
}
