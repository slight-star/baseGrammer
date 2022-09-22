package com.dong.SE.dataStructure.tree;

/**
 * @author dfx
 */
public class BinaryTree {
    TreeNode root;


    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
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

    public TreeNode frontSearch(int i) {
        return this.root.frontSearch(i);
    }

    public TreeNode midSearch(int i) {
        return this.root.midSearch(i);
    }

    public TreeNode afterSearch(int i) {
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
