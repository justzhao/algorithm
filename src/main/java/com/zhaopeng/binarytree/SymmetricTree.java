package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 * Created by zhaopeng on 2018/1/14.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    /**
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     *
     * @param left
     * @param right
     * @return
     */
    public boolean helper(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
