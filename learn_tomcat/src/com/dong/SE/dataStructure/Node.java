package com.dong.SE.dataStructure;

import org.junit.Test;

/**
 * @author dfx
 */
public class Node {
    private int data;
    private Node next;

    public Node (){

    }
    public Node(int data) {
        this.data = data;
    }

    //插入一个节点
    public void insertNode(Node node){
        //获取当前节点的下个节点
        Node originalNext = this.next;
        this.next = node ;
        node.next = originalNext;
    }

    //显示后面所有节点
    public void show(){
        Node currentNode = this;
        while (true){
            System.out.print(currentNode.getData()+" ");
            currentNode = currentNode.next;
            if (currentNode.next == null){
                System.out.print(currentNode.getData()+" ");
                break;
            }
        }

        System.out.println();
    }

    //删除下一个节点
    public void removeNext(){
        Node currentNode = this;
        currentNode.next = this.next.next;
    }

    //向末尾追加节点
    public Node append(Node node){
        Node currentNode = this;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return currentNode;
    }


    //获取下一个节点
    public Node next(){
        return this.next;
    }

    //获取节点中的数据
    public int getData(){
        return this.data;
    }

    //是否是最后一个节点
    public boolean isLast(){
        if (this.next == null){
            return true;
        }else{
            return false;
        }
    }




}
