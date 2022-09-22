package com.dong.array;

import org.junit.Test;

public class MyQueue {
    private int[] elements;

    public MyQueue(){
        elements = new int[0];
    }

    //入队
    public void add(int value){
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = value;
        elements = newArr;
    }

    //出队
    public int poll(){
        if (elements.length == 0){
            throw new RuntimeException("Queue is empty");
        }
        //取出第0个元素
        int element = elements[0];

        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i+1];
        }
        elements = newArr;
        return element;
    }

    //判断是否为空
    public boolean isEmpty(){
        return elements.length == 0;
    }



    @Test
    public void test(){
        MyQueue mq = new MyQueue();
//        mq.poll();
        mq.add(9);
        mq.add(8);
        mq.add(7);

        System.out.println(mq.poll());
        System.out.println(mq.poll());
        System.out.println(mq.isEmpty());
        System.out.println(mq.poll());
    }
}
