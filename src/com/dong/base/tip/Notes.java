package com.dong.base.tip;


public class Notes {
    String name;

    public static void main(String[] args) {
        float f = 0.1f;
        double d = 1.0/10;

        System.out.println(f==d);//false

        float f1 = 212555235265315646548f;
        float f2 = f1+1;

        System.out.println(f1==f2);//true

        /*
        注意不能用float类型比较大小
        要用BigDecimal类
         */

        int money = 10_0000_0000;
        int years = 20;
        int total = money*years;
        long total2 = money*years;  //默认是int，赋给long之前就已经溢出了
        long total3 = (long)money*years;

        System.out.println(total);
        System.out.println(total2);
        System.out.println(total3);

        Notes notes = new Notes();
        System.out.println(notes.name);


        int salary = 50000;
        System.out.println(salary);

        int x = 300;
        byte bx = (byte)x;
        System.out.println(bx); //值为44
    }
}
