package com.dong.SE.dataStructure.sort;

import java.util.Arrays;

/**
 * @author dfx
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{9,6,8,7,0,1,10,4,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void heapSort(int[] arr) {
        //最后一个父节点的下标
        int start = (arr.length-1 -1)/2;
        //调整为大顶堆
        for (int i = start; i>=0; i--){
            maxHeap(arr,arr.length,i);
        }
        //调整为大顶堆后，将下标0的元素与最后一个元素交换，固定住最后一位，然后用最后一位之前的元素再次进行调整为大顶堆
        for (int i = arr.length-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //将下标i前面的元素再次调成大顶堆
            maxHeap(arr, i, 0);
        }
    }


    /**
     *
     * @param arr  要转换成大顶堆的数组
     * @param size 数组的长度
     * @param index 从哪个节点开始转换
     */
    public static void maxHeap(int[] arr,int size, int index){
        //先找到最后一个父节点，在其与子节点中找到最大节点,让父节点是最大值
        int max = index;
        int left = 2*index +1;
        int right = 2*index +2;

        if (left < size && arr[left] > arr[max]){
            max = left;
        }
        if (right < size && arr[right] > arr[max]){
            max = right;
        }

        //交换位置
        if (max != index){
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            //交换后改变了排列，子树可能不是大顶堆了，要递归一下
            maxHeap(arr,size,max);
        }
    }


    //极客时间 堆排序2
    public static void sort(int[] arr){
        int size = arr.length -1;
        buildHeap(arr,size);
        for (int i = arr.length - 1; i > 0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void buildHeap(int[] arr, int size){
        for (int i = (size-1)/2; i >= 0; i--){
            heapify(arr, size, i);
        }
    }

    //从上往下堆化
    private static void heapify(int[] arr, int size,int i) {

        while (true){
            int maxPos = i;
            int left = i*2 + 1;
            int right = i*2 +2;
            //如果i有左节点,并且父节点小于子节点，
            if (left <= size && arr[maxPos] < arr[left]){
                maxPos = left;
            }
            //如果i有右节点，且父节点小于右节点
            if (right <= size && arr[maxPos] < arr[right]){
                maxPos = right;
            }
            if (maxPos == i){
                break;
            }
            //交换
            swap(arr,i,maxPos);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
