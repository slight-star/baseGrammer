package com.dong.SE.dataStructure.tree.BalancedBinaryTree;

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

    //查询左子树的高度
    public int leftHeight(){
        if (this.left == null){
            return 0;
        }
        return this.left.height();
    }

    //查询右子树的高度
    public int rightHeight(){
        if (this.right == null){
            return 0;
        }
        return this.right.height();
    }

    //添加节点
    public void add(Node node){
        if (node == null){
            return;
        }
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
        //判断是否平衡，不平衡的话旋转
        //右旋转
        if (leftHeight() - rightHeight() >= 2){
            //双旋转  当前节点的左子树的左子树高度 < 当前节点左子树的右子树高度
            if (left != null && left.leftHeight() < left.rightHeight()){
                //先当前节点的左子树进行左旋转
                left.leftRotate();
                //当前节点进行右旋转
                rightRotate();
            }else {
                //单旋转 右旋转
                rightRotate();
            }

        }
        //左旋转
        if (rightHeight() - leftHeight() >= 2){
            //双旋转 当前节点的右节点的右子树的高度 < 当前节点右节点的左子树的高度
            if (right != null && right.rightHeight() < right.leftHeight()){
                //先当前节点的右节点右旋转
                right.rightRotate();
                //在当前节点左旋转
                leftRotate();
            }else {
                //单旋转 当前节点左旋转
                leftRotate();
            }

        }


    }

    private void leftRotate() {
        //新建一个子树，存放当前节点的值
        Node newNode = new Node(this.value);
        //设置新节点的左子树为当前节点的左子树
        newNode.left = this.left;
        //设置新节点的右子树为当前节点的右子树的左子树
        newNode.right = this.right.left;
        //设置当前节点的值为当前节点右节点的值
        this.value = this.right.value;
        //设置当前节点的右子树为当前节点右子树的右子树
        this.right = this.right.right;
        //设置当前节点的左子树为新建的子树
        this.left = newNode;
    }

    private void rightRotate() {
        //新建一个子树,存放当前节点的值
        Node newNode = new Node(this.value);
        //设置新子树的右子树为当前节点的右子树
        newNode.right = this.right;
        //设置新字数的左节点为当前节点的左子树的右子树
        newNode.left = this.left.right;
        //设置当前的节点的值为左节点的值
        this.value = this.left.value;
        //设置当前节点的左子树为当前节点的左子树的左子树
        this.left = this.left.left;
        //设置当前节点的右字数为前面新建的子树
        this.right = newNode;
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
