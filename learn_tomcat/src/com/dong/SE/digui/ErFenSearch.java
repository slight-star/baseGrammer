package com.dong.SE.digui;

/**
 * @author dfx
 */
public class ErFenSearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(erFenSearch(nums, 0, nums.length-1, target));
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                l = mid + 1;
            }
            if(nums[mid] > target){
                r = mid - 1;
            }
        }
        return -1;
    }

//    public static int erFenSearch(int[] arr, int l, int r, int num){
//        if (r >= l){
//            int mid = l + (r - l) / 2;
//            if (arr[mid] == num){
//                return mid;
//            }
//            if(arr[mid] < num){
//                return erFenSearch(arr, mid+1, r, num);
//            }
//            if(arr[mid] > num){
//                return erFenSearch(arr, l, mid - 1, num);
//            }
//        }
//        return -1;
//    }

    public static int erFenSearch(int[] arr, int l, int r, int target){
        if(r >= l){
            int mid = l + (r-l)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                return erFenSearch(arr, mid+1, r, target);
            }
            if(arr[mid] > target){
                return erFenSearch(arr, l, mid-1, target);
            }
        }
        return -1;
    }
}
