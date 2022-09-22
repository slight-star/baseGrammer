package com.dong.SE.dataStructure;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dfx
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        ArrayList<String> pokers = new ArrayList<>();
        String[] colors = {"♣","♥","♠","♦"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        pokers.add("大王");
        pokers.add("小王");
        for (String color : colors){
            for (String number : numbers){
                pokers.add(color+number);
            }
        }
        System.out.println(pokers);

        //2.洗牌
        Collections.shuffle(pokers);

        //3.发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        for (int i=0; i<54; i++){
            if (i>=51){
                dipai.add(pokers.get(i));
            }else if (i % 3 == 0){
                player1.add(pokers.get(i));
            }else if (i % 3 == 1){
                player2.add(pokers.get(i));
            }else if (i % 3 == 2){
                player3.add(pokers.get(i));
            }
        }

        //4.看一下牌
        System.out.println("刘德华"+player1);
        System.out.println("周润发"+player2);
        System.out.println("周星驰"+player3);
        System.out.println("底牌"+dipai);

    }
}
