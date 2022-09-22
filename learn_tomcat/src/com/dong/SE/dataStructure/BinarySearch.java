package com.dong.SE.dataStructure;

import org.junit.Test;

@SuppressWarnings("all")
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        //记录目标元素
        int target = 0;
        //记录下标
        int index = -1;

        int left = 0;
        int right = arr.length-1;
        int mid = (left + right) / 2;

        while(left <= right){
            //看中间元素是不是要查找的元素
            if (arr[mid] == target){
                index = mid;
                break;
            }else{
                //看是不是比中间元素左边
                if (target < arr[mid]){
                    right = mid-1;
                }else{
                    //是在中间元素右边
                    left = mid+1;
                }
                mid = (left + right) / 2;
            }
        }
        System.out.println("index:"+index);
    }



    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,8};
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;
        int num = 8;
        int index = -1;

        while (left <= right){
            System.out.println("left:"+left+" right:"+right+" mid:"+mid);
            if (arr[mid] == num){
                index = mid;
                break;
            }else if(num < arr[mid]){
                right = mid-1;
            }else if(num > arr[mid]){
                left = mid+1;
            }
            mid = (left+right)/2;

        }

        System.out.println(index);
    }
}
