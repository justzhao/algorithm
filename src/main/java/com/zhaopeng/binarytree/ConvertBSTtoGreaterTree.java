package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 * Created by zhaopeng on 2018/1/14.
 * <p>
 * <p>
 * <p>
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2    13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20   13
 */


public class ConvertBSTtoGreaterTree {

    /**
          2

     0        3

-4       1
     */

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }

}
