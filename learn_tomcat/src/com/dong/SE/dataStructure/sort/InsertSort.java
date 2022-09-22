package com.dong.SE.dataStructure.sort;

import java.util.Arrays;

/**
 * @author dfx
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 9, 7, 2, 3, 5};
//        insertSort(arr);
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort2(int[] arr) {
        for (int i = 1; i<arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i-1; j>=0; j--){
                if (arr[j] > temp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }

    private static void insertSort(int[] arr) {

        for (int i = 1; i<arr.length; i++){
            int j = i;
            int temp = arr[i];
            while (j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            if (j != i){
                arr[j] = temp;
            }


        }
    }

}
