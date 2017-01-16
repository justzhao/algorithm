package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.*;

/**
 * 二叉树的z字形遍历
 * Created by zhaopeng on 2017/1/8.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int levelCount = 1;
        int nextLevelCount = 0;
        List<Integer> order = new ArrayList<>();
        result.add(order);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelCount--;
            order.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelCount++;
            }
            if (levelCount == 0) {
                if (level % 2 == 0) {
                    //右向左
                    Collections.reverse(order);
                }
                // 进入下一次
                levelCount = nextLevelCount;
                nextLevelCount = 0;
                level++;//层级加1
                order = new ArrayList<>(levelCount);
                if (!queue.isEmpty()) {
                    result.add(order);
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        right1.left = left2;
        right1.right = right2;
        BinaryTreeZigzagLevelOrderTraversal v = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(v.zigzagLevelOrder(root));
    }
}
