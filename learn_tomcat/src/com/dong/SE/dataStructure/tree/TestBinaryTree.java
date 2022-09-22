package com.dong.SE.dataStructure.tree;

/**
 * @author dfx
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);

        binaryTree.setRoot(root);

        //创建左节点
        TreeNode rootL = new TreeNode(2);
        root.setLeftNode(rootL);

        //创建右节点
        TreeNode rootR = new TreeNode(3);
        root.setRightNode(rootR);

        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        //前序遍历
        binaryTree.frontShow();
        System.out.println();

        //中序
        binaryTree.midShow();
        System.out.println();
        //后序
        binaryTree.afterShow();
        System.out.println();

        //前序查找
        TreeNode treeNode = binaryTree.frontSearch(5);
        System.out.println(treeNode);
        System.out.println(rootR == treeNode);

        //中序查找
        treeNode = binaryTree.midSearch(7);
        System.out.println(treeNode);
        System.out.println(rootR == treeNode);

        //后序查找
        treeNode = binaryTree.afterSearch(3);
        System.out.println(treeNode);
        System.out.println(rootR == treeNode);

        //删除子树
        binaryTree.deleteSubTree(1);
        binaryTree.frontShow();
        System.out.println();


    }
}
