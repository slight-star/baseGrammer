package com.dong.SE.dataStructure.tree.HuffmanTree;

/**
 * @author dfx
 */
public class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;



    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "TestHuffmanCode{" +
                "value=" + value +
//                ", left=" + left +
//                ", right=" + right +
                '}';
    }
}
