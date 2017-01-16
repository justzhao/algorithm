package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2016/11/29.
 * 中序遍历和后续遍历构造二叉树
 */
public class BuildTreeWithInorderPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

         return  createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode createTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        // 取根节点，
        if (instart > inend || poststart > postend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        if (instart == inend || poststart == postend) {
            return root;
        }

        // 寻找根节点在中序遍历中的索引位置
        int index = getValueIndex(inorder, root.val);

        // 分开后序遍历左右子树
        //求右边长度为
        int inorderrightLen = inend - index;
        // 求子树的结束位置
        int postorderEnd = postend - inorderrightLen - 1;
        // 构造左边
        root.left = createTree(inorder, instart, index - 1, postorder, poststart, postorderEnd);
        //构造右边
        root.right = createTree(inorder, index + 1, inend, postorder, postorderEnd + 1, postend - 1);

        return root;
    }

    public int getValueIndex(int inorder[], int value) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value)
                return i;
        }
        return 0;
    }
}
