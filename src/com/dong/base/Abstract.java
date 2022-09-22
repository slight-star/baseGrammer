package com.dong.base;

public abstract class Abstract {
    public Abstract() {
        System.out.println("抽象方法构造器");
    }

    public abstract void run();

    public void go(){
        System.out.println();
    }
}
