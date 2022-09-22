package com.dong.base;

public class SparseArray {


    public static void main(String[] args) {
        int[][] arr1 = new int[10][12];
        arr1[2][3] = 6;
        arr1[6][5] = 5;
        System.out.println("原始数组");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("=======================");
        System.out.println("原始数组转换成稀疏数组");
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != 0) {
                    count++;
                }
            }
        }
        int[][] arr2 = new int[count+1][3];
        arr2[0][0] = arr1.length;
        arr2[0][1] = arr1[0].length;
        arr2[0][2] = count;
        count = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != 0) {
                    arr2[count][0] = i;
                    arr2[count][1] = j;
                    arr2[count][2] = arr1[i][j];
                    count++;
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("=======================");
        System.out.println("稀疏数组还原");
        int[][] arr3 = new int[arr2[0][0]][arr2[0][1]];
        for (int i = 1; i <= arr2[0][2]; i++) {
            arr3[arr2[i][0]][arr2[i][1]] = arr2[i][2];
        }
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[0].length; j++) {
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println();
        }

    }
}


