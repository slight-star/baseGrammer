package com.web.enumtest;

import org.junit.Test;

public class TestDemo {

    //根据枚举的下标，得到枚举的对象，与名称
    @Test
    public void test3(){
        //获得所有枚举对象的数组
        Color[] values = Color.values();
        //根据下标获取对象
        int idx = 2;
        Color value = values[idx];
        //获取对象的名称
        String name = value.name();
        System.out.println(name);
    }

    //根据枚举的名称，得到对象，与下标
    @Test
    public void test2(){
        String green = "GREEN";
        //得到对象
        Color color = Color.valueOf(green);
        //得到下标
        int ordinal = color.ordinal();
        System.out.println(ordinal);
    }


    //根据枚举的对象，得到枚举的名称与下标
    @Test
    public void test1(){
        //得到枚举的对象
        Color red = Color.RED;
        //得到枚举的对象的名称
        String name = red.name();
        //得到对象的下标
        int ordinal = red.ordinal();
        System.out.println(name+"  "+ordinal);
    }
}

enum Color{
    RED,GREEN,YELLOW;
}
