package com.web.fanxing;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        String[] arr = {"aa","bb","cc","dd"};
        swap1(arr,1,3);
        System.out.println(Arrays.toString(arr));

        Integer[] arr1 = {1,2,3,4};
        swap1(arr1,1,3);
        System.out.println(Arrays.toString(arr1));
    }

    private static <T> void swap1(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
