package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

/**
 * 给定一个二叉树，求二叉树两个点直接的最大距离，可以不包括根节点
 * Created by zhaopeng on 2016/12/10.
 */
public class BinaryTreeMaximumPathSum {

    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);

        return max;
    }

    public int maxPath(TreeNode node) {
        if (node == null) return 0;
        int val = node.val;
        max = val > max ? val : max;
        int leftv = maxPath(node.left);
        max = (leftv + val) > max ? (leftv + val) : max;
        int rightv = maxPath(node.right);

        max = (rightv + val) > max ? (rightv + val) : max;
        int result = val + leftv + rightv;
        //  System.out.println(max);
        max = result > max ? result : max;
        return Math.max(val, Math.max(leftv + val, rightv + val));
    }

    public static void main(String args[]) {
        BinaryTreeMaximumPathSum bmps = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(-1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        //  root.right = right;

        System.out.println(bmps.maxPathSum(root));


    }

}
