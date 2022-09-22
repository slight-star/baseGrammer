package com.dong.SE.dataStructure.sort;

/**
 * @author dfx
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {45, 78, 9, 8, 78, 96, 532, 45, 6};

//        int[] new_arr = new int[arr.length];

        for (int i=0; i<arr.length-1; i++){
            for (int j = 0; j<arr.length-i-1;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            for (int a : arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }


    }
}
