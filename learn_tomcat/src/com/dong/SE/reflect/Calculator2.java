package com.dong.SE.reflect;

/**
 * @author dfx
 */
public class Calculator2 {
    @Check
    public void add(){
        String s = null;
        s.toString();
        System.out.println("1 + 0 = "+(1+0));
    }

    @Check
    public void sub(){
        System.out.println("1 - 0 = "+(1-0));
    }

    @Check
    public void mul(){
        System.out.println("1 * 0 = "+(1*0));
    }

    @Check
    public void div(){
        System.out.println("1 / 0 = "+(1/0));
    }

    public void show(){
        System.out.println("没有bug");
    }
}
