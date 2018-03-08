package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 * Created by zhaopeng on 2018/2/6.
 */
public class SumofLeftLeaves {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        find(root.left, true);
        find(root.right, false);
        return res;
    }

    public void find(TreeNode node, boolean isleft) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (isleft) {
                res += node.val;
            }
            return;
        }
        find(node.left, true);
        find(node.right, false);

    }
}
