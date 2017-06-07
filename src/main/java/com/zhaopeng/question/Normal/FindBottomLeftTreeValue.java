package com.zhaopeng.question.Normal;

import com.zhaopeng.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaopeng on 2017/6/7.
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        int left = 0;

        if (root == null) {
            return left;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        left = root.val;
        queue.add(root);
        int levelCount = 1;

        int nextLevelCount = 0;

        boolean flag = true;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (nextLevelCount == 0&&flag) {
                left = node.val;
                flag=false;
            }

            levelCount--;
            if (node.left != null) {
                nextLevelCount++;
                queue.add(node.left);
            }
            if (node.right != null) {
                nextLevelCount++;
                queue.add(node.right);

            }
            if (levelCount == 0) {
                flag=true;
                levelCount = nextLevelCount;
                nextLevelCount = 0;
            }


        }

        return left;
    }

    public static void main(String args[]) {
        FindBottomLeftTreeValue s = new FindBottomLeftTreeValue();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(s.findBottomLeftValue(root));
    }
}
