package com.dong.SE.dataStructure.tree.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dfx
 */
public class TestHuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[]{3,7,8,29,5,11,23,14};
        Node huffmanTree = createHuffmanTree(arr);
        System.out.println(huffmanTree);
    }

    private static Node createHuffmanTree(int[] arr) {
        //先使用数组中所有的元素创建若干个二叉树，(每棵树只有一个节点)
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr){
            nodes.add(new Node(value));
        }
        //循环处理
        while (nodes.size() > 1){
            //排序
            Collections.sort(nodes);
            //取出来权值最小的两个二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //创建一个新二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            //把取出来的两个二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树集合
            nodes.add(parent);
        }

        return nodes.get(0);
    }
}
