package com.dong.SE.dataStructure.tree;

/**
 * @author dfx
 */
public class TreeNode {
    //节点的权
    int value;
    //左儿子
    TreeNode leftNode;
    //右儿子
    TreeNode rightNode;

//    //中序线索树  记录指针类型   前序、后序 类似
//    int leftType ; //0代表左指针指向左子树，1代表指向前驱节点
//    int rightType ;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void frontShow() {
        System.out.print(this.value + " ");

        if (this.leftNode != null){
            this.leftNode.frontShow();
        }

        if (this.rightNode != null){
            this.rightNode.frontShow();
        }
    }

    public void midShow() {
        if (this.leftNode != null){
            this.leftNode.midShow();
        }

        System.out.print(this.value + " ");

        if (this.rightNode != null){
            this.rightNode.midShow();
        }
    }

    public void afterShow() {
        if (this.leftNode != null){
            this.leftNode.afterShow();
        }

        if (this.rightNode != null){
            this.rightNode.afterShow();
        }

        System.out.print(this.value + " ");


    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        if (this.value == i){
            return this;
        }

        //查找左儿子
        if (this.leftNode != null){
            target = leftNode.frontSearch(i);
        }
        if (target != null){
            return target;
        }

        if (this.rightNode != null){
            target = rightNode.frontSearch(i);
        }
        return target;
    }

    public TreeNode midSearch(int i) {
        TreeNode target = null;
        if (this.leftNode != null){
            target = this.leftNode.midSearch(i);
        }
        if (target != null){
            return target;
        }

        if (this.value == i){
            return this;
        }

        if (this.rightNode != null ){
            target = this.rightNode.midSearch(i);
        }
        return target;
    }

    public TreeNode afterSearch(int i) {
        TreeNode target = null;
        if (this.leftNode != null){
            target = this.leftNode.afterSearch(i);
        }
        if (target != null){
            return target;
        }

        if (this.rightNode != null ){
            target = this.rightNode.afterSearch(i);
        }
        if (target != null){
            return target;
        }

        if (this.value == i){
            return this;
        }
        return target;
    }

    public void deleteSubTree(int i) {
        //判断左儿子
        if (this.leftNode != null && this.leftNode.value == i){
            this.leftNode = null;
            return;
        }
        //右儿子
        if (this.rightNode != null && this.rightNode.value == i){
            this.rightNode = null;
            return;
        }
        //左右儿子都不是，进入递归
        if (this.leftNode != null){
            this.leftNode.deleteSubTree(i);
        }
        if (this.rightNode != null){
            this.rightNode.deleteSubTree(i);
        }
    }
}
