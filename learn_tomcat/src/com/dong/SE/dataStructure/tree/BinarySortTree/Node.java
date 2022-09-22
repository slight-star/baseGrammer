package com.dong.SE.dataStructure.tree.BinarySortTree;

/**
 * @author dfx
 */
@SuppressWarnings("all")
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //查找节点的高度
    public int height(){
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    //添加节点
    public void add(Node node){
        //如果添加的节点比当前的节点小，放左边，否则右边
        if (node.value < this.value){
            //如果左节点为空
            if (this.left == null){
                this.left = node;
            }else{
                //如果不为空
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }


    public void midShow(Node node) {
        if (node == null){
            return;
        }
        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);
    }

    public Node search(int value) {
        if (this.value == value){
            return this;
        }else if (this.value < value){
            if (this.right != null){
                return this.right.search(value);
            }else {
                return null;
            }
        }else {
            if (this.left != null){
                return this.left.search(value);
            }else{
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //搜索父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else{
            if (this.value < value && this.right != null){
                return this.right.searchParent(value);
            }else if(this.value > value && this.left != null) {
                return this.left.searchParent(value);
            }
            return null;
        }
    }
}
