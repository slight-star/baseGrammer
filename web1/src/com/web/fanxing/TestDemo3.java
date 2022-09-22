package com.web.fanxing;

import java.util.Arrays;

public class TestDemo3 {
    public static void main(String[] args) {
        String[] arr = {"aa","bb","cc","dd","ee"};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void reverse(T[] arr){
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            swap(arr,i,length-i-1);
        }
    }

    public static <T> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
