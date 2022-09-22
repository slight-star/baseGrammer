package com.dong.SE.dataStructure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author dfx
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        int[] arr = {58,79,8,5,4,5,6,68,45};
        quickSort(arr,0,arr.length-1);
        System.out.println();
        arr = new int[]{58,79,8,5,4,5,6,68,45};
        quickSort2(arr,0,arr.length-1);

        System.out.println("3");
        arr = new int[]{58,79,8,5,4,5,6,68,45};
        quickSort3(arr,0,arr.length-1);



    }

    private static void quickSort3(int[] arr, int start, int end) {
        if (start < end){
            int left = start;
            int right = end;
            int pivot = arr[left];
            while (left < right){
                while(left < right && arr[right] >= pivot){
                    right--;
                }
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;

                while (left < right && arr[left] <= pivot){
                    left++;
                }
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
            quickSort3(arr,start,left-1);
            quickSort3(arr,left+1,end);
            System.out.println(Arrays.toString(arr));
        }
    }


    private static void quickSort2(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        int left = start;
        int right = end;
        int pivot = arr[left];
        while (left < right){
            while (left<right && arr[right]>=pivot){
                right--;
            }
            while (left<right && arr[left]<=pivot){
                left++;
            }
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        int temp = arr[left];
        arr[left] = arr[start];
        arr[start] = temp;
        System.out.println(Arrays.toString(arr));
        quickSort2(arr,start,left-1);
        quickSort2(arr,left+1,end);
    }




    public static void quickSort(int[] arr, int start, int end){
        if (start < end){
            int left = start, right = end;
            int pivot = arr[left];
            while(left<right){
                while(left<right && arr[right]>=pivot){
                    right--;
                }
                arr[left] = arr[right];
                while(left<right && arr[left]<=pivot){
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = pivot;
            System.out.println(Arrays.toString(arr));
            quickSort(arr,start,left);
            quickSort(arr,left+1,end);
        }
    }
}
