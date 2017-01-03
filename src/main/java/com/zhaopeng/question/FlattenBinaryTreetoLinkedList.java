package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

/**
 * 给定一个二叉树，原地做成右子树列表
 * Created by zhaopeng on 2017/1/3.
 */
public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {

        if (root == null) return;
        turnRight(root);

    }

    public void turnRight(TreeNode node) {
        if(node==null) return;

        if (node.left != null) {
            TreeNode right = node.right;
            node.right = node.left;
            node.left=null;

            TreeNode rNode = node.right;
            while (rNode.right!=null){
                rNode = rNode.right;
            }
            rNode.right=right;

        }
        turnRight(node.right);
    }

    public  static  void  main(String args[]){
        FlattenBinaryTreetoLinkedList v=new FlattenBinaryTreetoLinkedList();
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        root.left=left;
        v.flatten(root);
    }
}
