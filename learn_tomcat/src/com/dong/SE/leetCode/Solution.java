package com.dong.SE.leetCode;

import org.junit.Test;

import java.util.*;

/**
 * @author dfx
 */
public class Solution {
    //977. 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        int left = 0, right = nums.length - 1;
        int[] arr = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[right] >= nums[left]){
                arr[i] = nums[right];
                right--;
            }else{
                arr[i] = nums[left];
                left++;
            }
        }
        return arr;
    }

    @Test
    public void test977(){
        int[] arr = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        return 0;
    }

    @Test
    public void test27(){
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(arr, val));
    }

    //3.无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 1;
        for (int i = 0 ; i < len; i++){
            HashSet set = new HashSet();
            int j = i+1;
            int count = 1;
            set.add(s.charAt(i));
            while (j < len &&!set.contains(s.charAt(j))){
                count++;
                set.add(s.charAt(j));
                j++;
                max = max > count ? max : count;
            }
        }
        return max;
    }

    @Test
    public void test3(){
        String s = "abcabca";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

//    215. 数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        return nums[nums.length-k];

        /*//快速排序
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
        */

        //大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;//小顶堆
                return o2 - o1;//大顶堆
            }
        });
        for (int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        }

        int result = pq.poll();
        System.out.println(result);
        for (int i = 1; i < k; i++){
            result = pq.poll();
            System.out.println(result);
        }
        return result;

    }

    public void quickSort(int[] nums, int start, int end){
        if(start < end){
            int left = start, right = end;
            int pivot = nums[left];
            while(left < right){
                while(left < right && nums[right] >= pivot){
                    right--;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right]= temp;
                while(left < right && nums[left] <= pivot){
                    left++;
                }
                temp = nums[left];
                nums[left] = nums[right];
                nums[right]= temp;
            }
            quickSort(nums, start, left - 1);
            quickSort(nums, left + 1, end);
        }else{
            return;
        }
    }


    @Test
    public void test215(){
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,5));
    }

    //347. 前 K 个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                int count = map.get(nums[i]);
                map.put(nums[i],++count);
            }else{
                map.put(nums[i],1);
            }
        }

        //创建小顶堆保存map的value
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //return o2.getValue() - o1.getValue();
                return o1.getValue() - o2.getValue();
            }
        });
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.add(entry);
            }else{
                pq.poll();
                pq.add(entry);
            }

        }


        int[] result = new int[k];
        /*
        for (int i = k-1; i >= 0; i--){
            result[i] = pq.poll().getKey();
            System.out.println(result[i]);
        }*/
        System.out.println(pq);
        for (int i = 0; i < k; i++){
            result[i] = pq.poll().getKey();
            System.out.println(result[i]);
        }
        return result;
    }

    @Test
    public void test347(){
        int[] nums = new int[]{3,0,1,0};
        int k = 1;
        topKFrequent(nums, k);
    }
}
