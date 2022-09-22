package com.dong.SE.dataStructure;

import java.util.*;

/**
 * @author dfx
 */
public class DouDiZhuPlus {
    public static void main(String[] args) {
        //准备拍
        ArrayList<String> colors = new ArrayList<String>();
        ArrayList<String> numbers = new ArrayList<String>();

        String[] colorsArr = {"♣","♥","♠","♦"};
        String[] numbersArr = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        for (String color : colorsArr){
            colors.add(color);
        }
        for (String number : numbersArr){
            numbers.add(number);
        }

        HashMap<Integer, String> map = new HashMap<>();

        map.put(0,"大王");
        map.put(1,"小王");
        int index = 1;
        for (String number : numbers){
            for (String color : colors){
                map.put(++index,color+number);
            }
        }

        //洗牌
        ArrayList<Integer> keyList = new ArrayList<>();
        keyList.addAll(map.keySet());
        Collections.shuffle(keyList);
        System.out.println(keyList);

        //分牌
        ArrayList<Integer> dipai = new ArrayList<>();
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();

        for (int i=0; i<keyList.size(); i++){
            if (i>=51){
                dipai.add(keyList.get(i));
            }else if (i % 3 == 0){
                player1.add(keyList.get(i));
            }else if (i % 3 == 1){
                player2.add(keyList.get(i));
            }else if (i % 3 == 2){
                player3.add(keyList.get(i));
            }
        }
        Collections.sort(dipai);
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);

//        for (Integer ind : dipai){
////            System.out.print(map.get(ind));
////        }
////        System.out.println();
////        for (Integer ind : player1){
////            System.out.print(map.get(ind));
////        }
////        System.out.println();
////        for (Integer ind : player2){
////            System.out.print(map.get(ind));
////        }
////        System.out.println();
////        for (Integer ind : player3){
////            System.out.print(map.get(ind));
////        }
        //看牌
        kanPai("底牌",map,dipai);
        kanPai("玩家1",map,player1);
        kanPai("玩家2",map,player2);
        kanPai("玩家3",map,player3);

    }

    public static void kanPai(String payerName, HashMap<Integer,String> map, ArrayList<Integer> list){
        System.out.print(payerName+":");
        for (Integer index : list){
            System.out.print(map.get(index));
        }
        System.out.println();
    }
}
