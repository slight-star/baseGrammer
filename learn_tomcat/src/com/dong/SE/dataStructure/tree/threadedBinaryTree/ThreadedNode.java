package com.dong.SE.dataStructure.tree.threadedBinaryTree;

/**
 * @author dfx
 */
public class ThreadedNode {
    //节点的权
    int value;
    //左儿子
    ThreadedNode leftNode;
    //右儿子
    ThreadedNode rightNode;

    //中序线索树  记录指针类型   前序、后序 类似
    int leftType ; //0代表左指针指向左子树，1代表指向前驱节点
    int rightType ;

    public ThreadedNode(int value) {
        this.value = value;
    }

    public ThreadedNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ThreadedNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ThreadedNode leftNode) {
        this.leftNode = leftNode;
    }

    public ThreadedNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ThreadedNode rightNode) {
        this.rightNode = rightNode;
    }

    public void frontShow(){
        System.out.print(this.value + " ");

        if (this.leftNode != null){
            this.leftNode.frontShow();
        }

        if (this.rightNode != null){
            this.rightNode.frontShow();
        }
    }

    public void midShow(){
        if (this.leftNode != null){
            this.leftNode.midShow();
        }

        System.out.print(this.value + " ");

        if (this.rightNode != null){
            this.rightNode.midShow();
        }
    }

    public void afterShow(){
        if (this.leftNode != null){
            this.leftNode.afterShow();
        }

        if (this.rightNode != null){
            this.rightNode.afterShow();
        }

        System.out.print(this.value + " ");
    }

    //前序查找
    public ThreadedNode frontSearch(int i){
        ThreadedNode target = null;
        if (this.value == i){
            return this;
        }

        if (this.leftNode != null){
            target = this.leftNode.frontSearch(i);
        }
        if (target != null){
            return target;
        }

        if (this.rightNode != null){
            target = this.rightNode.frontSearch(i);
        }
        return target;
    }

    public ThreadedNode midSearch(int i){
        ThreadedNode target = null;
        if (this.leftNode != null){
            target = this.leftNode.midSearch(i);
        }
        if (target != null){
            return target;
        }

        if (this.value == i){
            return this;
        }

        if (this.rightNode != null){
            target = this.rightNode.midSearch(i);
        }
        return target;
    }

    public ThreadedNode afterSearch(int i){
        ThreadedNode target = null;
        if (this.leftNode != null){
            target = this.leftNode.afterSearch(i);
        }
        if (target != null){
            return target;
        }
        if (this.rightNode != null){
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

    //删除除根节点外，其他的节点
    public void deleteSubTree(int i){
        //判断左儿子
        if (this.leftNode != null && leftNode.value == i){
            this.leftNode = null;
            return;
        }
        //右儿子
        if (this.rightNode != null && rightNode.value == i){
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
