package com.dong.SE.dataStructure;

import org.junit.Test;

/**
 * @author dfx
 */
public class MyLinkedListTest {
    @Test
    public void test(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);
        linkedList.addAtHead(2);

        /*
        linkedList.addAtTail(1);
        linkedList.get(0);

        /*
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);

        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);

        linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);

        linkedList.addAtHead(6);
        */
    }
}
