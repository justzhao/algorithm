package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 * Created by zhaopeng on 2017/12/23.
 */
public class ConstructStringfromBinaryTree {

    public static void main(String args[]) {

        ConstructStringfromBinaryTree o = new ConstructStringfromBinaryTree();

        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);

        t.left.right = new TreeNode(4);
        System.out.println(o.tree2str(t));
    }

    public String tree2str(TreeNode t) {

        StringBuilder sb = new StringBuilder();

        tree2str(t, sb);

        return sb.toString();
    }

    public void tree2str(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }

        sb.append(t.val);
        if (t.left == null && t.right == null) {
            return;
        }

        if (t.left == null) {
            //左子树为空，右子树不空
            sb.append("()").append("(");
            tree2str(t.right, sb);
            sb.append(")");
        } else if (t.right == null) {
            // 右子树为空，左子树不空
            sb.append("(");
            tree2str(t.left, sb);
            sb.append(")");

        } else {
            // 左右子树都不空
            sb.append("(");
            tree2str(t.left, sb);
            sb.append(")");
            sb.append("(");
            tree2str(t.right, sb);
            sb.append(")");

        }

    }

}
