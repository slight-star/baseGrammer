package com.dong.SE.threads;

/**
 * @author dfx
 */
public class ThreadTest {
    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        MyThread1 myThread2 = new MyThread1();
//        MyThread1 myThread3 = new MyThread1();
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();

//        RunnableImpl run = new RunnableImpl();
//        Thread thread1 = new Thread(run);
//        Thread thread2 = new Thread(run);
//        Thread thread3 = new Thread(run);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();

        //lock锁解决线程安全问题
        RunnableImpl2 run = new RunnableImpl2();
        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);
        Thread thread3 = new Thread(run);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
