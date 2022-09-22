package com.dong.base.枚举;

import org.junit.Test;

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println(Season1.class.getSuperclass());
        Season1[] values = Season1.values();
        for (Season1 value:values) {
            System.out.println(value);
        }

        System.out.println("------------------");
        Thread.State[] values1 = Thread.State.values();
        for (Thread.State value : values1) {
            System.out.println(value);
        }

        System.out.println("-----------");
        Season1 summer = Season1.valueOf("SUMMER");
        System.out.println(summer);

    }

//    @Test
//    public void testGetAnnotation(){
//        Class clazz = Student.class;
//        Annotation[] annotations = clazz.getAnnotations();
//        for (Annotation annotation:
//             annotations) {
//            System.out.println(annotation);
//        }
//    }
}

interface Info{
    void show();
}

// enum要先写对象，把对象声明在上面
enum Season1 implements Info{

    //1提供当前枚举类的对象
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天来了");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天来了");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天来了");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天来了");
        }
    };

    //2.声明season对象的属性，要用private final修饰
    private final String seasonname;
    private final String seasondesc;

    //3.私有化类的构造器,并给对象属性初始化   用private表示对象已经确定了，不能自己新造
    private Season1(String seasonname, String seasondesc){
        this.seasonname = seasonname;
        this.seasondesc = seasondesc;
    }

    //4.其他诉求，获取枚举类的对象的属性
    public String getSeasonname() {
        return seasonname;
    }

    public String getSeasondesc() {
        return seasondesc;
    }

//    //4.其他诉求，提供toString方法
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonname=" + seasonname +
//                ", seasondesc=" + seasondesc +
//                '}';
//    }
}
