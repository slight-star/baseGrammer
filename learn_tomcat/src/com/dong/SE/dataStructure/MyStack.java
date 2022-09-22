package com.dong.SE.dataStructure;

import org.junit.Test;

@SuppressWarnings("all")
public class MyStack {
    private int[] elements;
    
    public MyStack(){
        elements = new int[0];
    }
    
    //压入元素
    public void push(int value){
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = value;
        elements = newArr;
    }
    
    //取出栈顶元素
    public int pop(){
        if (elements.length == 0){
            throw new RuntimeException("Stack is empty");
        }
        //取出栈顶元素
        int element = elements[elements.length-1];

        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
        return element;
    }

    //查看栈顶元素
    public int peek(){
        if (elements.length == 0){
            throw new RuntimeException("Stack is empty");
        }
        return elements[elements.length - 1];
    }

    //查看栈是否为空
    public boolean isEmpty(){
        return elements.length == 0;
    }



    @Test
    public void test(){
        MyStack ms = new MyStack();
//        ms.pop();
        ms.push(99);
        ms.push(98);
        ms.push(97);
        ms.push(96);

        System.out.println(ms.pop());
//        System.out.println(ms.pop());
//        System.out.println(ms.pop());
//        System.out.println(ms.pop());

        System.out.println(ms.peek());
        System.out.println(ms.peek());

        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());

        System.out.println(ms.isEmpty());


    }
}
