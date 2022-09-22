package com.dong.SE.dataStructure.sort;

import com.dong.SE.dataStructure.MyQueue;

import java.util.Arrays;

/**
 * @author dfx
 */
//计数排序 用队列
public class RadixQueueSort {
    public static void main(String[] args) {
        int[] arr = new int[]{56,89,78,98,46,56,23,46,89,456};
        radixSort(arr);
    }

    private static void radixSort(int[] arr) {
        //用队列存放每次的结果
        MyQueue[] queue = new MyQueue[10];
        //为队列数组复制
        for (int k=0;k<10;k++){
            queue[k] = new MyQueue();
        }

        //确定比较的轮数，先找到最大数
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNum){
                maxNum = arr[i];
            }
        }
        int loopCount = (maxNum + "").length();
        //开始比较
        for (int i = 1,n=1; i<= loopCount; i++,n*=10){
            for (int j = 0; j<arr.length; j++){
                //得到余数
                int ys = arr[j]/n%10;
                queue[ys].add(arr[j]);
            }
            //把box里面的数放到arr里
            int index = 0;
            for (int p = 0; p<10; p++){
                while (!queue[p].isEmpty()){
                    arr[index] = queue[p].poll();
                    index++;
                }
//                if (count[p] != 0){
//                    for (int q = 0; q <count[p] ; q++) {
//                        if (index<10){
//                            arr[index] = queue[p][q];
//                            queue[p][q] = 0;
//                            index++;
//                        }else{
//                            break;
//                        }
//                    }
//                    count[p] = 0;
//                }

            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
