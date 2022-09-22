package com.dong.SE.digui;

/**
 * @author dfx
 */
public class FeiBoNaQi {
    public static void main(String[] args) {
        int n = 45;
        for (int i = 1; i < n; i++){
            System.out.println(feiBoNaQi(1,1,i));
        }
        System.out.println("/////////////////////////");
        for (int i = 1; i < n; i++){
            System.out.println(feiBoNaQi_(i));
        }
    }

    private static int feiBoNaQi(int first, int second, int n) {
        if (n <= 0){
            return 0;
        }else if (n <= 2){
            return 1;
        }else if(n == 3){
            return first + second;
        }else{
            int third = first + second;
            return feiBoNaQi(second, third, n-1);
        }
    }

    public static int feiBoNaQi_(int n){
        if (n <= 0){
            return 0;
        }else if (n <= 2){
            return 1;
        }
        return feiBoNaQi_(n - 1) + feiBoNaQi_(n - 2);
    }



}
