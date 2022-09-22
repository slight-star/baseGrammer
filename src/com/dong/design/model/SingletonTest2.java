package com.dong.design.model;

import org.junit.Test;

public class SingletonTest2 {
    public static void main(String[] args){
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();
        System.out.println(order1 == order2);
    }

    @Test
    public void test(){
        Customer cust1 = Customer.instance;
        Customer cust2 = Customer.instance;
        System.out.println("**********");
        System.out.println(cust1 == cust2);
    }
}

// 懒汉式 将对象设置为null,啥时候用，啥时候new
class Order{
    // 1.私有化类的构造器
    private Order(){

    }

    // 2.内部创建类的对象
    // 4.此对象也必须是静态的
    private static Order instance = null;

    // 3.提供公共的、静态的方法，返回类的对象
    public static Order getInstance(){
        if(instance == null){ // 线程不安全
            instance = new Order();
        }
        return instance;
    }
}

// 另一种
class Customer{
    private Customer(){

    }

    public static final Customer instance = new Customer();
}

