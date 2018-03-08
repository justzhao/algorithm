package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2017/5/26.
 */
public class ValidateBinarySearchTree {

    /**
     * BST 左子树小于根节点，右子树大于根节点。
     * @param root
     * @return
     */
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
        // 当前节点的值， 需要小于最大值，大于最小值。， 最大值一般是表示，当前节点是父节点的左孩子，最小值是当前节点的右孩子。
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
