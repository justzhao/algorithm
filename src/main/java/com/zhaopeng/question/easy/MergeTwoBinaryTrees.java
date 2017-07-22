package com.zhaopeng.question.easy;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2017/7/22.
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }


        TreeNode node = new TreeNode(t1.val + t2.val);

        node.right = mergeTrees(t1.right, t2.right);
        node.left = mergeTrees(t1.left, t2.left);

        return node;
    }
}
