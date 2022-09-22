package com.dong.base.枚举;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring.toString());
    }
}
// 自定义枚举类
class Season{
    //1.声明season对象的属性，要用private final修饰
    private final String seasonname;
    private final String seasondesc;

    //2.私有化类的构造器,并给对象属性初始化   用private表示对象已经确定了，不能自己新造
    private Season(String seasonname, String seasondesc){
        this.seasonname = seasonname;
        this.seasondesc = seasondesc;
    }

    //3.提供当前枚举类的多个对象:声明为public static final 修饰
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4.其他诉求，获取枚举类的对象的属性

    public String getSeasonname() {
        return seasonname;
    }

    public String getSeasondesc() {
        return seasondesc;
    }

    //4.其他诉求，提供toString方法
    @Override
    public String toString() {
        return "Season{" +
                "seasonname=" + seasonname +
                ", seasondesc=" + seasondesc +
                '}';
    }
}
