package com.dong.SE.dataStructure;

import org.junit.Test;

/**
 * @author dfx
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    //伪头结点
    ListNode head;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if(index < 0){
            return -1;
        }
        ListNode node = this.head.next;
        for(int i = 0; i <= index; i++){
            if(node != null) {
                if(i == index){
                    return node.val;
                }else{
                    node = node.next;
                }
            }else{
                //节点为空
                return -1;
            }
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode currNode = this.head;
        while(currNode != null){
            if(currNode.next == null){
                currNode.next = node;
                size++;
                break;
            }else{
                currNode = currNode.next;
            }
        }
    }

    public void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val);
        if(index <= 0){
            head.next = node;
            size++;
        }else if(index <= size ){
            ListNode currNode = this.head.next;
            for(int i = 0; i < index; i++){
                //找到index的前一个节点
                if(i == index-1){
                    node.next = currNode.next;
                    currNode.next = node;
                    size++;
                    break;
                }else{
                    currNode = currNode.next;
                }
            }
        }else {
            return;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size){
            return;
        }
        ListNode currNode = this.head;
        for(int i = 0; i <= index; i++){
            if(i == index){
                currNode.next = currNode.next.next;
                size--;
            }else{
                currNode = currNode.next;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */