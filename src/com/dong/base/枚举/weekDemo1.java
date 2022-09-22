package com.dong.base.枚举;

public class weekDemo1 {
    public static void main(String[] args) {
        Week1 mon = Week1.Mon;
        System.out.println(mon);
        System.out.println(Week1.class.getSuperclass());
    }
}

enum Week1{

    Mon(1),
    Feb(2),
    Wed(3),
    Thu(4);

    private final int weekName;

    private Week1(int weekName){
        this.weekName = weekName;
    }

    public int getWeekName(){
        return weekName;
    }


}