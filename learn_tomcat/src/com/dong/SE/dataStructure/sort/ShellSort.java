package com.dong.SE.dataStructure.sort;

import java.util.Arrays;

/**
 * @author dfx
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 9, 7, 2, 3, 5};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        //划分步长
        for (int step=arr.length/2; step>=1; step /= 2){
            //每个子序列进行插入排序
            for (int i=step; i<arr.length; i+=step){
                int temp = arr[i];
            }
        }
    }
}
