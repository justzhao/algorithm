package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 * Created by zhaopeng on 2018/5/25.
 */
public class AddOneRowtoTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d <= 0 || root == null) {
            return root;
        }
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        addRow(root, v, d, 1);
        return root;
    }

    public void addRow(TreeNode node, int v, int d, int level) {


        if (level + 1 == d) {
            //get it,next level to be insert

            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            TreeNode oleft = node.left;
            TreeNode oright = node.right;
            node.left = left;
            left.left = oleft;
            node.right = right;
            right.right = oright;
            return;
        }

        if (node == null) {
            return;
        }

        addRow(node.left, v, d, level + 1);
        addRow(node.right, v, d, level + 1);
    }
}
