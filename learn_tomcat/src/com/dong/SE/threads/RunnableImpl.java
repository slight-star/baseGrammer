package com.dong.SE.threads;

/**
 * @author dfx
 */
public class RunnableImpl implements Runnable{
    private static int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while(true){
//            payTicket();
            payTicketStatic();
        }
    }

    public synchronized void payTicket(){
        if (ticket > 0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
            ticket--;
        }
    }

    public static synchronized void payTicketStatic(){
        if (ticket > 0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
            ticket--;
        }
    }
}
