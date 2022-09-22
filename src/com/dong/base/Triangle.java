package com.dong.base;

public class Triangle {
    public static void main(String[] args) {
        for (int i=1; i<=5; i++){
            for (int j=1; j<=(5-i); j++){
                System.out.printf(" ");
            }
            for (int j=1; j<=i; j++){
                System.out.printf("*");
            }
            for (int j=1; j<i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
        int sum = add(1,2);

    }

    public static int add(int a, int b){
        return a+b;
    }
}
