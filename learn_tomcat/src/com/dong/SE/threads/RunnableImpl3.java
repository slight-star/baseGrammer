package com.dong.SE.threads;

/**
 * @author dfx
 */
public class RunnableImpl3 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"第二句");
    }
}
