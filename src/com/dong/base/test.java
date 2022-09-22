package com.dong.base;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int i=0; i<m; i++)
            {
                arr[i] = sc.nextInt();
            }
        }
        int arr[] = {2,4,6};
    }
}
