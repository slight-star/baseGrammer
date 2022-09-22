package com.dong.SE.dataStructure;

/**
 * @author dfx
 */
public class LoopNode {
    private int data;
    private LoopNode next = this;

    public LoopNode(){

    }
    public LoopNode(int data) {
        this.data = data;
    }

    //遍历循环链表
    public void bianli(){
        LoopNode node = this;
        while (node.next != this){
            System.out.print(node.getData()+" ");
            node = node.next;
        }
        System.out.println(node.getData()+" ");
    }

    //获取长度
    public int size(){
        LoopNode node = this;
        int count = 1;
        while (node.next != this){
            count++;
            node = node.next;
        }
        return count;
    }

    //插入一个节点
    public void insertNode(LoopNode node){
        //获取当前节点的下个节点
        LoopNode originalNext = this.next;
        this.next = node ;
        node.next = originalNext;
    }

    //显示后面所有节点


    //删除下一个节点
    public void removeNext(){
        LoopNode currentNode = this;
        currentNode.next = this.next.next;
    }

    //向末尾追加节点



    //获取下一个节点
    public LoopNode next(){
        return this.next;
    }

    //获取节点中的数据
    public int getData(){
        return this.data;
    }

    //是否是最后一个节点





}
