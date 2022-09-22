package com.dong.base.array;

public class BubbleSort {
    public BubbleSort() {
    }

    /**
     * 冒泡排序
     * 将传入的int型数组按升序排序
     * 参数是arr,int类型的待排序数组
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (null == arr) {
            System.out.println("传入的参数不能是null");
            return;
        }

        //声明状态变量，若flag经过for循环后一直是false，代表传入的数组本身就是有序的
        boolean flag;
        //外层循环确定要比较几轮
        for (int i = 0; i< arr.length-1; i++) {
            flag = false;
            //内层循环从前往后依次比较两个数，如果前面的数大于后面的数，则交换位置
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    //交换前后的数
                    swap(arr, j, j+1);
                    //将flag置为true，代表传入的数组本身是无序的
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
}
