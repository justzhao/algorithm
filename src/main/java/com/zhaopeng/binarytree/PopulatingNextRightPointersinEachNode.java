package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 * Created by zhaopeng on 2018/1/24.
 * <p>
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    /**
     * 一层一层的来
     *
     * @param root
     */
    public void connect1(TreeLinkNode root) {

        while (root != null) {
            TreeLinkNode node = root;
            while (node != null) {
                if (node.left != null) {
                    node.left.next = node.right;
                }
                if (node.next != null && node.right != null) {
                    node.right.next = node.next.left;
                }
                node=node.next;
            }
            root = root.left;
        }

    }



}
