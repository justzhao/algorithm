package com.zhaopeng.study;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2017/6/21.
 */
public class BST {


    private TreeNode parent;

    void deleteNode(TreeNode node, int x) {
        if (node == null) {
            return;
        }
        if (node.val > x) {
            deleteNode(node.left, x);
        } else if (node.val < x) {
            deleteNode(node.right, x);
        } else { //查找到了删除节点
            if (node.left == null) { //左子树为空
                node = node.right;
            } else if (node.right == null) { //右子树为空
                node = node.left;

            } else {  //左右子树都不为空
                //一般的删除策略是左子树的最大数据 或 右子树的最小数据 代替该节点(这里采用查找左子树最大数据来代替)
                TreeNode left = node.left;
                if (left.right != null) {
                    left = left.right;
                }
                node.val = left.val;
                deleteNode(node.left, left.val);


                // 还可以找到左子树的最大节点，然后获取到最大节点。然后替换

            /*    parent = node;
                TreeNode big = findBigNode(node.left, node);

                if (parent == node) {
                    node.val = big.val;
                    parent.left = null;
                } else {
                    node.val = big.val;
                    if (parent.right != null) {
                        parent.right = null;
                    } else {
                        parent.left = null;
                    }
                }*/


            }
        }
    }


    private TreeNode findBigNode(TreeNode node, TreeNode parent) {

        if (node.right != null) {
            return findBigNode(node.right, node);
        }

        if (node.left != null) {
            return findBigNode(node.left, node);
        }

        this.parent = parent;
        return node;

    }

}
