package com.dong.SE.dataStructure;

import java.util.Arrays;

@SuppressWarnings("all")
public class ArrayAddCapacity {
    public static void main(String[] args) {
        int[] arr = new int[]{99,98,97};
        int length1 = arr.length;
        System.out.println(length1);
        System.out.println(Arrays.toString(arr));

        int[] newArr = new int[length1 + 1];
        for (int i=0; i<length1; i++){
            newArr[i] = arr[i];
        }
        newArr[arr.length] = 100;
        arr = newArr;
        System.out.println(Arrays.toString(arr));
    }
}
