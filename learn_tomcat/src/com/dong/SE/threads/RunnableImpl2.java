package com.dong.SE.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dfx
 */
public class RunnableImpl2 implements Runnable{
    private static int ticket = 100;
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            l.lock();
            if (ticket > 0){
                try {
                    Thread.sleep(20);
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    l.unlock();
                }
            }
        }
    }


}
