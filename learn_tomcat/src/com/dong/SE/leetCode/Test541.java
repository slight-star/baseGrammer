package com.dong.SE.leetCode;

import org.junit.Test;

/**
 * @author dfx
 */
public class Test541 {
    @Test
    public void test(){
        String s = "abcd";
        int k = 4;
        System.out.println(reverseStr(s,k));

    }

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();

        int i = 0;

        for(; i < s.length(); i+=2*k){
            int start = i;
            int end = start + k;
            reverse(str, start,end);
        }
        return new String(str);
    }

    public void reverse(char[] s, int start, int end){
        if(end >= s.length){
            end = s.length;
        }
        for(int i = 0; i < (end-start)/2; i++ ){
            char temp = s[start+i];
            s[start+i] = s[end-1-i];
            s[end-1-i] = temp;
        }
    }
}
