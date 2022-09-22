package com.dong.SE.threads;

/**
 * @author dfx
 */
public class BaoZiPu implements Runnable{
    private BaoZi bz;

    public BaoZiPu() {
    }

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (bz){
                if (bz.isStatus()){
                    //有包子，就进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    //没有包子就开始生产包子
                    if (count % 2 == 0){
                        bz.setPi("薄皮");
                        bz.setXian("三鲜馅");
                    }else{
                        bz.setPi("冰皮");
                        bz.setXian("牛肉馅");
                    }
                    count++;
                    System.out.println("包子铺正在生产"+bz.getPi()+bz.getXian()+"包子");
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bz.setStatus(true);
                    //唤醒吃货线程让吃货吃包子
                    bz.notify();
                    System.out.println("包子铺已经生产出来"+bz.getPi()+bz.getXian()+"包子，吃货可以开吃了！");
                }
            }
        }
    }
}
