package com.dong.SE.threads;

/**
 * @author dfx
 */
public class Demo {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();

        BaoZiPu baoZiPu = new BaoZiPu(bz);
        Thread thread1 = new Thread(baoZiPu);

        ChiHuo chiHuo = new ChiHuo(bz);
        Thread thread2 = new Thread(chiHuo);


        thread1.start();
        thread2.start();



    }
}
