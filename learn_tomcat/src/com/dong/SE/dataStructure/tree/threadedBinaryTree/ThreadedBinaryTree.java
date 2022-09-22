package com.dong.SE.dataStructure.tree.threadedBinaryTree;

/**
 * @author dfx
 */
public class ThreadedBinaryTree {
    ThreadedNode root;
    //用于临时存储前驱节点
    ThreadedNode pre = null;

    //遍历线索二叉树  不需要使用递归，因为已经知道前一个后一个了
    public void threadIterate(){
        ThreadedNode node = root;
        while (node != null){
            //循环找到最开始的节点
            while (node.leftType == 0){
                node = node.leftNode;
            }
            System.out.print(node.value+" ");
            while (node.rightType == 1){
                node = node.rightNode;
                System.out.print(node.value+" ");
            }

            node = node.rightNode;
        }
    }

    //中序线索化二叉树
    public void midThreaded(){
        midThreaded(root);
    }

    private void midThreaded(ThreadedNode node) {
        if(node == null){
            return;
        }
        //处理左子树
        midThreaded(node.leftNode);

        //处理本身 处理前驱节点
        if (node.leftNode == null){
            //让当前节点的左指针指向前驱节点
            node.leftNode = pre;
            //改变当前节点的左指针的类型  1代表左指针指向的是前驱节点
            node.leftType = 1;
        }
        //处理前驱节点的右指针,空的话(没有指向右子树)说明需要处理，不为空不需要处理
        if (pre != null && pre.rightNode == null){
            //让当前节点的右指针指向后继节点
            pre.rightNode = node;
            //改变前驱节点的右指针类型
            pre.rightType = 1;
        }
        //每处理一个节点，当前节点是下一个节点的前驱节点
        pre = node;

        //处理右子树
        midThreaded(node.rightNode);
    }

    public ThreadedBinaryTree() {
    }

    public ThreadedBinaryTree(ThreadedNode root) {
        this.root = root;
    }

    public ThreadedNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    public void frontShow() {
        if (this.root != null){
            this.root.frontShow();
        }
    }

    public void midShow() {
        if (this.root != null){
            this.root.midShow();
        }
    }

    public void afterShow() {
        if (this.root != null){
            this.root.afterShow();
        }
    }

    public ThreadedNode frontSearch(int i) {
        return this.root.frontSearch(i);
    }

    public ThreadedNode midSearch(int i) {
        return this.root.midSearch(i);
    }

    public ThreadedNode afterSearch(int i) {
        return this.root.afterSearch(i);
    }

    public void deleteSubTree(int i) {
        if (root.value == i){
            root = null;
        }else{
            root.deleteSubTree(i);
        }
    }

}
