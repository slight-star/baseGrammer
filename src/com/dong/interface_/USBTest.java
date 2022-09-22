package com.dong.interface_;

public class USBTest {
    public static void main(String[] args) {
        Computer com = new Computer();

        // 1.创建接口的非匿名实现类的非匿名对象
        Printer printer = new Printer();
        com.transferData(printer);

        // 2.创建接口的非匿名实现类的匿名对象
        com.transferData(new Flash());

        // 3.创建接口的匿名实现类的非匿名对象 *******
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("手机启动");
            }

            @Override
            public void stop() {
                System.out.println("手机关机");
            }
        };
        com.transferData(phone);

        // 4.创建接口的匿名实现类的匿名对象 *******
        com.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("mp3启动");
            }

            @Override
            public void stop() {
                System.out.println("mp3关机");
            }
        });
    }
}

class Computer {
    public void transferData(USB usb){ // 提现了接口的多态性
        usb.start();
        System.out.println("传输数据");
        usb.stop();
    }
}

interface USB{
    void start();
    void stop();
}

class Flash implements USB{

    @Override
    public void start() {
        System.out.println("Flash开始");
    }

    @Override
    public void stop() {
        System.out.println("Flash结束");
    }
}

class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开始");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束");
    }
}

