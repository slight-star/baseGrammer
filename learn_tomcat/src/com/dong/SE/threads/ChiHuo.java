package com.dong.SE.threads;

/**
 * @author dfx
 */
public class ChiHuo implements Runnable{
    private BaoZi bz;

    public ChiHuo() {
    }

    //使用带参构造方法为包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if (bz.isStatus()){
                    System.out.println("吃货开始吃"+bz.getPi()+bz.getXian()+"包子");
                    bz.setStatus(false);
                    System.out.println("吃货已经把"+bz.getPi()+bz.getXian()+"包子吃完了，包子铺开始生产包子");
                    System.out.println("-----------------------");
                    bz.notify();
                }else{
                    //没有包子，唤醒包子铺做包子
                    System.out.println("没有包子，请包子铺生产包子");
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
