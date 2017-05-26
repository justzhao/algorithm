package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2017/5/26.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);


    }

    public static void main(String args[]){
        ValidateBinarySearchTree s=new ValidateBinarySearchTree();
        TreeNode root=new TreeNode(2147483647);
        System.out.println(s.isValidBST(root));
    }
}
