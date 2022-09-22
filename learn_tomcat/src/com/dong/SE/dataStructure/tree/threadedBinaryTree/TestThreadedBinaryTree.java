package com.dong.SE.dataStructure.tree.threadedBinaryTree;

/**
 * @author dfx
 */
public class TestThreadedBinaryTree {
    public static void main(String[] args) {
        ThreadedBinaryTree binTree = new ThreadedBinaryTree();
        //创建一个根节点
        ThreadedNode root = new ThreadedNode(1);
        binTree.setRoot(root);

        //创建一个左节点
        ThreadedNode rootL = new ThreadedNode(2);
        root.setLeftNode(rootL);

        ThreadedNode rootR = new ThreadedNode(3);
        root.setRightNode(rootR);

        rootL.setLeftNode(new ThreadedNode(4));
        ThreadedNode fiveNode = new ThreadedNode(5);
        rootL.setRightNode(fiveNode);
//        rootL.setRightNode(new ThreadedNode(5));

        rootR.setLeftNode(new ThreadedNode(6));
        rootR.setRightNode(new ThreadedNode(7));

        //前序遍历
        binTree.midShow();
        System.out.println();
        //中序线索化二叉树
        binTree.midThreaded();
        //检验是否线索化成功：查找到5节点
//        ThreadedNode fiveNode = binTree.midSearch(5);//这里栈溢出了，因为中序线索化后
        //获取5节点的后继节点
        ThreadedNode afterFive = fiveNode.rightNode;
        System.out.println(afterFive.value);

        //遍历
        binTree.threadIterate();

    }
}
