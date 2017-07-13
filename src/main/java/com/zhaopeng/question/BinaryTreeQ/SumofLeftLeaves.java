package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2017/7/14.
 */
public class SumofLeftLeaves {


    public static int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLeftLeaveValue(root);
        return sum;
    }

    public void getLeftLeaveValue(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        if (left != null) {
            if (left.left == null && left.right == null) {
                sum += left.val;
            }
        } else {
            getLeftLeaveValue(node.left);
        }
        getLeftLeaveValue(node.right);
    }

    public static void main(String args[]) {

        SumofLeftLeaves s = new SumofLeftLeaves();
        TreeNode node = new TreeNode(1);
        int sum = s.sumOfLeftLeaves(node);

        System.out.println(sum);
    }
}
