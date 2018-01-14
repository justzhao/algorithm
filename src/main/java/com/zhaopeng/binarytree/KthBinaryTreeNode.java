package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2017/12/25.
 */
public class KthBinaryTreeNode {

    TreeNode res = null;
    Integer cur=0;
    TreeNode KthNode(TreeNode pRoot, int k) {


        kNode(pRoot, k);
        return res;
    }


    void kNode(TreeNode node, int k) {
        if (node == null || k == 0) {
            return;
        }

        kNode(node.left, k);
        cur++;
        if (k == cur) {
            res = node;
            return;
        }
        kNode(node.right, k);
    }


}
