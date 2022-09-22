package com.dong.SE.threads;

/**
 * @author dfx
 */
public class MyThread1 extends Thread{
    private int ticket = 100;
    Object obj = new Object();

    public void run(){
        while(true){
            synchronized (obj){
                if (ticket > 0){
//                    try {
////                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                }
            }
        }
    }
}
