package com.dong.SE.dataStructure;

import org.junit.Test;

/**
 * @author dfx
 */
public class TestDemos {

    @Test
    public void testNode(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        //追加
        n1.append(n2);
        n1.append(n3);

        System.out.println(n1.next().getData());
        System.out.println(n1.next().next().getData());

        System.out.println();

//        System.out.println(n1.isLast());
//        System.out.println(n2.isLast());
//        System.out.println(n3.isLast());

//        //显示所有节点
//        n1.show();
//        //删除n2
//        n1.removeNext();
//        n1.show();

        n1.show();
        //2后面插入4
        n2.insertNode(new Node(4));
        n1.show();
    }

    @Test
    public void testLoopNode(){
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);

        n1.insertNode(n2);
        n2.insertNode(n3);
        n3.insertNode(n4);
        System.out.println(n1.size());
        n1.bianli();

        n3.bianli();
    }

    @Test
    public void testDoubleNode(){
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);

        n1.insertNode(n2);
        System.out.println(n1.getData());
        System.out.println(n1);
        n2.insertNode(n3);

        n3.insertNode(n4);
        System.out.println(n3.getData());

        n1.bianli();
        n3.bianli();
    }
}
