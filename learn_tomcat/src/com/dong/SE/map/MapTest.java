package com.dong.SE.map;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author dfx
 */
public class MapTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");

        String text = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<text.length(); i++){
            char key = text.charAt(i);
//            if (map.containsKey(key)){
//                int count = map.get(key);
//                map.put(key,count+1);
//            }else{
//                map.put(key,1);
//            }
            if (map.get(key) != null){
                int count = map.get(key);
                map.put(key,count+1);
            }else{
                map.put(key,1);
            }

        }


        for (Character key: map.keySet()){
            System.out.println(key + ":" + map.get(key));
        }
    }
}
