package com.dong.SE.dataStructure.tree.BinarySortTree;

/**
 * @author dfx
 */
public class TestBinarySortTree {
    public static void main(String[] args) {
        //创建二叉排序树
//        int[] arr = new int[]{7,3,10,12,5,1,9,};
        int[] arr = new int[]{5,4,7,6,9,8};

        //创建一颗二叉排序树
        BinarySortTree bst = new BinarySortTree();
        //循环添加  添加的时候就已经排好序
        for (int i : arr){
            bst.add(new Node(i));
        }
        //查看树中的值
        bst.midShow();
        System.out.println();
        //查找值
        Node search = bst.search(5);
        System.out.println(search);
        Node search1 = bst.search(20);
        System.out.println(search1);


        //删除5
//        bst.delete(5);
//        bst.midShow();
//        System.out.println("****");
//        bst.delete(3);
//        bst.midShow();
//        System.out.println("****");

        //删除含有两个子节点的7
        bst.delete(7);
        bst.midShow();
        System.out.println("****");


        Node node = new Node(3);
        node.left = new Node(2);
        System.out.println(node);
        node = node.left;
        System.out.println(node);

        //查看根节点的高度
        System.out.println(bst.root.height());
        System.out.println(bst.root.left.height());
        System.out.println(bst.root.right.height());



    }
}
