package com.dong.SE.dataStructure;

/**
 * @author dfx
 */
public class DiGuiFeibonacci {
    public static void main(String[] args) {
        for (int i = 1; i<10; i++){
            System.out.println(feibonacci(i));
        }
    }

    public static int feibonacci(int i){
        if (i == 1 || i == 2){
            return 1;
        }else{
            return feibonacci(i-1) + feibonacci( i-2);
        }
    }
}
