package com.dong.base.array;


public class BinarySearch {
    public static void main(String[] args) {
        //二分查找前提是元素有序
        int[] arr = {0,41,51,61,71,11,21,31};
        bubbleSort(arr);
        int index = binarySearch(arr, 31);
        System.out.println("二分查找的结果下标为："+index);

//        int[] arr = {0,41,51,61,71,11,21,31};
//        bubbleSort(arr);
//        int index = binarySearch(arr, 31);
//        System.out.println("二分查找下标为："+index);
    }

    /**
     * 冒泡排序
     * 将传入的int型数组按升序排序
     * 参数是int类型数组
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (null == arr) {
            System.out.println("传入的参数不能是null");
            return;
        }

        //声明临时变量
        boolean flag;
        //外层循环确定要比较几轮
        for (int i = 0; i< arr.length-1; i++) {
            flag = false;
            //内层循环从前往后依次比较两个数，如果前面的数大于后面的数，则交换位置
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int binarySearch(int[] arr, int num) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int midIndex = (minIndex + maxIndex) / 2;

        //最小下标和最大下标重合了的时候，代表查找了一遍
        while (minIndex <= maxIndex) {
            if (num == arr[midIndex]) {
                return midIndex;
            } else if (num < arr[midIndex]) {
                maxIndex = midIndex - 1;
            } else if (num > arr[midIndex]) {
                minIndex = midIndex + 1;
            }
            midIndex = (minIndex + maxIndex) / 2;
        }
        return -1;
    }


}
