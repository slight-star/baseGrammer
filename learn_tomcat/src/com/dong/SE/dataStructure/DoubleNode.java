package com.dong.SE.dataStructure;

/**
 * @author dfx
 */
public class DoubleNode {
    private DoubleNode pre = this;
    private int data;
    private DoubleNode next = this;

    public DoubleNode(int data){
        this.data = data;
    }

    public DoubleNode(){}

    //插入节点
    public void insertNode(DoubleNode node){
        node.next = this.next;
        node.pre = this;
        this.next = node;
    }

    //遍历节点
    public void bianli(){
        DoubleNode node = this;
        while (node.next != this){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    //得到数据
    public int getData(){
        return this.data;
    }

}
