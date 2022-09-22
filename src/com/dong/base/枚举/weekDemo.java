package com.dong.base.枚举;

public class weekDemo {

}

class Week{
    private final String weekName;
    private final String weekDesc;

    private Week(String weekName, String weekDesc){
        this.weekName = weekName;
        this.weekDesc = weekDesc;
    }

    public static final Week Mon = new Week("周一","星期一");
    public static final Week Feb = new Week("周二","星期二");
    public static final Week Wed = new Week("周三","星期三");
    public static final Week Thu = new Week("周四","星期四");

    public String getWeekName(){
        return weekName;
    }

    public String getWeekDesc() {
        return weekDesc;
    }
}
