package com.dong.SE.digui;

/**
 * @author dfx
 */
public class XnFang {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int x = 16;
        int n = 7;
        System.out.println(function1(x,n));
        System.out.println(function2(x,n));
        System.out.println(function3(x,n));

        System.out.println(function4(x,n));

        long r = System.currentTimeMillis();

        System.out.println(r-l);
    }

    private static int function4(int x, int n) {
        if (n == 1){
            return x;
        }
        int t = function4(x, n/2);
        if (n % 2 == 1){
            return t * t * x;
        }
        return t * t;
    }

    private static int function3(int x, int n) {
        if (n == 1){
            return x;
        }
        if (n % 2 == 1){
            return function2(x, n/2) * function2(x, n/2) * x;
        }
        return function2(x, n/2) * function2(x, n/2);
    }

    private static int function2(int x, int n) {
        if (n == 1){
            return x;
        }
        return function2(x, n - 1) * x;
    }

    //求x的n次方
    public static int function1(int x, int n){
        int result = 1;
        for (int i = 0; i < n; i++){
            result *= x;
        }
        return result;
    }


}
