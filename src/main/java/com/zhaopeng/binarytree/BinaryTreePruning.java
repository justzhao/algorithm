package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-pruning/description/
 * Created by zhaopeng on 2018/5/26.
 */
public class BinaryTreePruning {


    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        if (purge(root)) {
            return null;
        }
        return root;
    }

    private boolean purge(TreeNode node) {

        if (node == null) {
            return true;
        }

        boolean left = purge(node.left);
        if (left) {
            node.left = null;
        }
        boolean right = purge(node.right);
        if (right) {
            node.right = null;
        }
        return node.val == 0 && left && right;
    }

}
