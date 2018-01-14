package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/house-robber-iii/description/
 * Created by zhaopeng on 2018/1/7.
 */
public class HouseRobberIII {

    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res[] = robOrNoRob(root);
        // 对于该节点 0表示不抢，1 表示抢
        return Math.max(res[0], res[1]);
    }

    public int[] robOrNoRob(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int res[] = new int[2];
        // 左子树
        int left[] = robOrNoRob(node.left);
        // 右子树
        int right[] = robOrNoRob(node.right);
        //该节点表示不抢，那就从左右子树的结果中 选取抢或者不抢的最大值。
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        // 该节点抢，则下个节点一定不抢
        res[1] = node.val + left[0] + right[0];

        return res;
    }


    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
