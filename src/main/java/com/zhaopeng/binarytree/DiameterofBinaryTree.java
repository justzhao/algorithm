package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * Created by zhaopeng on 2018/1/1.
 */
public class DiameterofBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        helper(root);

        return max-1;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        int sublen = left > right ? left + 1 : right + 1;
        max = Math.max(max, left+right+1);
        return sublen;
    }
}
