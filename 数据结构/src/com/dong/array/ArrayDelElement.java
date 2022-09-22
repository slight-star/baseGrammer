package com.dong.array;

import java.util.Arrays;

public class ArrayDelElement {
    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5,4};
        int dstIndex = 3;
        System.out.println(Arrays.toString(arr));

        int[] newArr = new int[arr.length - 1];
        for (int i=0; i<newArr.length; i++){
            if (i < dstIndex){
                newArr[i] = arr[i];
            }else{
                newArr[i] = arr[i+1];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
