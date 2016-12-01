package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2016/12/1.
 * 前序遍历和中序遍历构建二叉树
 */
public class BuildTreeWithPreorderInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {

        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preend || instart == inend) {
            return root;
        }
        int index = getValueIndex(inorder, root.val);
        int leftlen = index - instart;
        // 左子树
        root.left = buildTree(preorder, prestart + 1, prestart + leftlen, inorder, instart, index - 1);
        // 右子树
        root.right = buildTree(preorder, prestart + leftlen + 1, preend, inorder, index + 1, inend);

        return root;
    }

    public int getValueIndex(int order[], int value) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == value) {
                return i;
            }
        }
        return 0;
    }
}
