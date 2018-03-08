package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2018/2/7.
 */
public class DeleteNodeinaBST {


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }


        delete(root, key);
        return null;
    }

    public TreeNode delete(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val == key) {

            if (node.left == null && node.right == null) {
                //叶子节点
                return node;
            } else if (node.left == null) {
                //有右子树
                node.val = node.right.val;
                node.right.val = key;
                TreeNode temp = node.right;
                node.left = node.right.left;
                node.right = node.right.right;
                return temp;
            } else if (node.right == null) {
                //有左子树
                node.val = node.left.val;
                node.left.val = key;
                TreeNode temp = node.left;
                node.left = node.left.left;
                node.right = node.left.right;
                return temp;

            } else {
                // 有左右子树。
                node.val = node.right.val;
                node.right.val = key;
                TreeNode temp = node.right;

                return temp;
            }


        }
        TreeNode left = deleteNode(node.left, key);
        TreeNode right = deleteNode(node.right, key);

        return left == null ? left : right;

    }
}
