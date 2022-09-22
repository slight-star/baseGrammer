package com.dong.SE.dataStructure.tree;

/**
 * @author dfx
 */
public class TestArrayBinaryTree {
    public static void main(String[] args) {
        ArrayBinnaryTree tree = new ArrayBinnaryTree(new int[]{1,2,3,4,5,6,7});
        //前序遍历
        tree.frontShow();
        //中序遍历
        tree.midShow();
        //后序遍历
        tree.afterShow();


    }
}
