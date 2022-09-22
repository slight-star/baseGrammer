package com.dong.base.tip;

public class DaiMaKuai {
    {
        System.out.println("匿名代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    public DaiMaKuai() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        new DaiMaKuai();
    }
}
