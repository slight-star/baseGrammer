package com.dong.SE.dataStructure.tree.BalancedBinaryTree;

/**
 * @author dfx
 */
public class TestBalancedBinaryTree {
    public static void main(String[] args) {
        //创建平衡二叉树
        //右旋转
//        int[] arr = new int[]{8,6,9,5,7,4};
        //左旋转
//        int[] arr = new int[]{5,4,7,6,9,8};
        //双旋转  先当前节点左子树左旋转，再当前节点右旋转
//        int[] arr = new int[]{5,2,6,1,3,4};
        //双旋转  先当前节点右子树右旋转，再当前节左旋转
        int[] arr = new int[]{0,-1,3,2,4,1};


        BalancedBinarySortTree bbst = new BalancedBinarySortTree();
        //添加节点
        for (int i : arr){
            bbst.add(new Node(i)); //添加节点时，自动旋转
        }

        System.out.println(bbst.root);
        bbst.midShow();
        System.out.println("*****");
        //查看根节点的高度
        System.out.println(bbst.root.height());
        System.out.println(bbst.root.left.height());
        System.out.println(bbst.root.right.height());





    }
}
