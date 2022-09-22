package com.dong.SE.leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dfx
 */
public class Test15 {
    @Test
    public void test15(){
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        //List<Integer> result = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<>();

        //对数组排序
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int sum = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > 0){
                return results;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;//去重，代表当前情况在上一轮已经考虑过了
            }
            left = i+1;
            right = nums.length-1;
            sum = nums[i]+nums[left]+nums[right];
            while(left < right){
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{

                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);

                    while(left < right && nums[left] == nums[++left]){}
                    while(left < right && nums[right] == nums[--right]){}
                }
                sum = nums[i]+nums[left]+nums[right];
            }

        }
        return results;
    }
}
