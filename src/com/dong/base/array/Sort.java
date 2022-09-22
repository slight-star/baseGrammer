package com.dong.base.array;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,6,3,4,7,5,6};
        bubbleSort(arr);
        //selectSort(arr);
        for (int x:arr) {
            System.out.print(x+" ");
        }
        System.out.println();

        int[] arr2 = {1,5,8,6,3,4,7,5,6};
        Arrays.sort(arr2);
        for (int x:arr2) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     * 将传入的int型数组按升序排序
     * 参数是int类型数组
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (null == arr) {
            System.out.println("传入的参数不能是null");
            return;
        }
        //声明临时变量
        int temp = 0;
        boolean flag;
        //外层循环判断要比较几轮
        for (int i=0 ; i<arr.length-1 ; i++) {
            flag = false;
            //内层循环从后往前依次比较两个数，如果后面的数小于前面的数，则交换位置，小的数就浮了出去
            for (int j=arr.length-1 ; j>i ; j--) {
                if (arr[j]<arr[j-1]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                return;
        }
    }

    /**
     * 选择排序
     * 将传入的int型数组按升序排序
     * 参数是int类型数组
     * @param arr
     */
    public static void selectSort(int[] arr) throws Exception{
        //临时变量
        int temp = 0;
        //外层循环表示比较几轮
        for (int i=0 ; i <arr.length-1 ; i++) {
            //记录最小下标
            int minIndex = i;
            //内层循环找到下标i后的最小数字的下标
            for (int j=i+1 ; j<arr.length ; j++) {
                if (arr[minIndex]>arr[j]) {
                    minIndex = j;
                }
            }
            //如果最小下标变了就交换
            if (minIndex != i) {
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
