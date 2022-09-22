package com.dong.SE.dataStructure.sort;

import java.util.Arrays;

/**
 * @author dfx
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 9, 7, 2, 3, 5};
        selectSort(arr);
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i<arr.length; i++){
            int minIndex = i;
            for (int j = i;j<arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.println("第"+i+"次排序"+ Arrays.toString(arr));
        }
    }
}
