package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 * Created by zhaopeng on 2018/1/24.
 * <p>
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *      1
 *    /  \
 *   2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        //head是每一层的开始节点
        TreeLinkNode head = null;
        //pre 是当前遍历节的下一层将要指向的后面的节点。
        TreeLinkNode pre = null;
        // 当前遍历的节点
        TreeLinkNode cur = root;
        while (cur != null) {
            //遍历每一层
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;

        }

    }

    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else if (root.next != null) {
                if (root.next.left != null) {
                    root.left.next = root.next.left;
                } else {
                    root.left.next = root.next.right;
                }
            }
        }
        if (root.next != null && root.right != null) {
            if (root.next.left != null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = root.next.right;
            }
        }
        connect(root.left);
        connect(root.right);

    }
}
