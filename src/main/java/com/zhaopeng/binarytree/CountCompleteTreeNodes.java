package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 * Created by zhaopeng on 2018/2/6.
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = heigh(root, true);
        int right = heigh(root, false);
        if (left == right) {
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int heigh(TreeNode node, boolean isleft) {
        if (node == null) {
            return 0;
        }
        return isleft ? heigh(node.left, true) + 1 : heigh(node.right, false) + 1;
    }

}
