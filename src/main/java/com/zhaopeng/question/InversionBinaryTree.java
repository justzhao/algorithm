package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

/** 反转二叉树
 * Created by zhaopeng on 2016/11/12.
 */

public class InversionBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root==null){
            return null;
        }

        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=right;
        root.right=left;
        invertTree(root.left);
        invertTree(root.right);

        return  root;

    }
}
