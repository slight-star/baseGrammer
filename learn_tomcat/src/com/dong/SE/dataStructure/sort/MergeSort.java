package com.dong.SE.dataStructure.sort;

import com.alibaba.druid.sql.visitor.functions.Left;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author dfx
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {4, 5, 6, 7, 9, 2, 3, 5, 7};
        int[] arr = {23,56,8,7,79,5,9,7,8};


        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high){
        int middle = (low + high)/2;
        if (low<high){
            //处理左边
            mergeSort(arr,low,middle);
            //处理右边
            mergeSort(arr,middle+1,high);
            //归并
            merge(arr, low, middle, high);
        }
    }

    private static void merge(int[] arr, int low, int middle, int high) {
        //用于存储归并后的临时数组
        int[] temp = new int[high-low+1];
        //记录第一个数组要遍历的下标
        int i= low;
        //记录第二个数组要遍历的下标
        int j = middle+1;
        //记录在临时数组中存放的下标
        int index= 0;
        //遍历两个数组取出小的数字，放入临时数组
        while (i<=middle && j<=high){
            if (arr[i]<=arr[j]){
                temp[index++] = arr[i];
                i++;
            }else {
                temp[index++] = arr[j];
                j++;
            }
        }
        //处理多余数据
        while (j<=high){
            temp[index++] = arr[j];
            j++;
        }
        while (i<=middle){
            temp[index++] = arr[i];
            i++;
        }
        //把临时数组数据放入原数组
        for (int k =0; k<temp.length; k++){
            arr[low+k] = temp[k];
        }
    }


}
