package com.dong.base;

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(){
        System.out.println("父类无参构造器");
    }

    public Person(int age){
        System.out.println("父类有参构造器");
    }

    public void go() {
        System.out.println("父类go");
    }

    public String show(String nation){
        System.out.println("国籍为："+nation);
        return nation;
    }

    public static void showDesc(){
        System.out.println("我");
    }
}
