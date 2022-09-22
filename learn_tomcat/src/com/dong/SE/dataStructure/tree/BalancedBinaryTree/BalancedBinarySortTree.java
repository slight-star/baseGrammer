package com.dong.SE.dataStructure.tree.BalancedBinaryTree;


/**
 * @author dfx
 */
@SuppressWarnings("all")
public class BalancedBinarySortTree {
    Node root;

    //添加节点
    public void add(Node node){
        if (root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    //中序遍历
    public void midShow(){
        if (root != null){
            root.midShow(root);
        }
    }

    //查找节点
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //删除节点
    public void delete(int value){
        if (root == null){
            return;
        }else {
            //先找到这个节点
            Node target = this.search(value);
            //如果没有这个节点，就不用删了
            if (target == null){
                return;
            }
            //找到它的父节点
            Node parent = this.searchParent(value);
            //如果是叶子节点直接从它的父节点对他删除
            if (target.left == null && target.right == null){
                if (parent.left.value == value){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
            }else if (target.left != null && target.right != null){
                //如果该节点有两个子节点
                //删除右子树中最小的节点，并获取到该节点的值，替换要删掉的节点的值
                int min = deleteMin(target.right);
                //替换目标节点的值
                target.value = min;
            }else{

                //如果该节点只有一个子节点，让该节点的父节点指向该节点的子节点
                if (target.left != null){
                    System.out.println("yige zijiedian 左");
//                    target = target.left;
                    if (parent.left == target){
                        parent.left = target.left;
                    }else {
                        parent.right = target.left;
                    }
                }else {
                    System.out.println("yige zijiedian 右");
//                    target = target.right;
                    if (parent.left == target){
                        parent.left = target.right;
                    }else {
                        parent.right = target.right;
                    }
                }

            }
        }
    }

    //删除一个树中最小的节点
    private int deleteMin(Node node) {
        while (node.left != null){
            node = node.left;
        }
        //删除该最小节点
        delete(node.value);
        return node.value;
    }

    private Node searchParent(int value) {
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }


}
