package com.dong.SE.digui;

/**
 * @author dfx
 */
public class SumMultiDemo {
    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(multi(25));
    }
    private static int sum(int n){
        if (n == 1){
            return 1;
        }
        return n + sum(n-1);
    }
    private static long multi(int n){
        if (n == 1){
            return 1;
        }
        return n * multi(n-1);
    }
}
