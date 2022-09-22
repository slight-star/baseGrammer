package com.dong.SE.leetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dfx
 */
public class Test202 {


    @Test
    public void test() {
        int n = 7;
        System.out.println(isHappy(n));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(n != 1){
            n = getSum(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }

    //拿到每一个位上的平方的和
    public int getSum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10) * (n%10);
            n /= 10;
            System.out.println(sum);
        }
        return sum;
    }
}
