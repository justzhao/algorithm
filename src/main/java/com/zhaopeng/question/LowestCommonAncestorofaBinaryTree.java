package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

/**
 * 求二叉树中两个节点的最低的公共祖先
 * Created by zhaopeng on 2017/1/4.
 */
public class LowestCommonAncestorofaBinaryTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
         return  findLca(root, p, q);


    }

    public TreeNode findLca(TreeNode root, TreeNode p, TreeNode q) {
        //不能使用root.va==p.val 怕出现同样值的节点
        if (root== p || root == q) {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            left = findLca(root.left, p, q);
        }
        if (root.right != null) {
            right = findLca(root.right, p, q);
        }
        if (left != null && right != null)
            return root;
        // 如果left 等null。 不关right 是否为null都返回
        return left!=null?left:right;
    }

}
