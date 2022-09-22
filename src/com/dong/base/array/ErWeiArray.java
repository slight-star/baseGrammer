package com.dong.base.array;

public class ErWeiArray {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i=0 ; i<arr.length ; i++) {
            for (int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1==str2);

        for (int i=0 ; i<100 ; i++) {
            if (i%3==1 && i%7==5 && i%5==0) {
                System.out.println(i);
            }
        }

        Sort sort = new Sort();
        int[] arr3 = {1,5,8,6,3,4,7,5,6};
        sort.bubbleSort(arr3);
        //sort.selectSort(arr3);
        for (int i:arr3) {
            System.out.print(i+" ");
        }



    }
}
