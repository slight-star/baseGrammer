package com.dong.SE.threads;

/**
 * @author dfx
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象
        Object obj = new Object();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    //要保证等待和唤醒的线程只有一个在执行，要使用同步代码块技术
                    synchronized (obj){
                        System.out.println("顾客1告知老板要吃的包子种类和数量");
                        //调用wait()方法，当前线程进入WAITING状态（无线等待）
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客1吃包子！");
                        System.out.println("-----------");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    //要保证等待和唤醒的线程只有一个在执行，要使用同步代码块技术
                    synchronized (obj){
                        System.out.println("顾客2我想喝粥");
                        //调用wait()方法，当前线程进入WAITING状态（无线等待）
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客2喝粥！");
                        System.out.println("*************");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    //要保证等待和唤醒的线程只有一个在执行，要使用同步代码块技术
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj){
                        System.out.println("包子做好了");
                        obj.notifyAll();
                    }
                }

            }
        }.start();
    }
}
