package com.zhaopeng.array;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2018/2/7.
 */
public class MaximumBinaryTree {

    public static void main(String args[]) {
        MaximumBinaryTree o = new MaximumBinaryTree();
        int nums[] = {3, 2, 1, 6, 0, 5};

        TreeNode root=o.constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = findMax(left, right, nums);
        TreeNode node = new TreeNode(nums[index]);
        node.left = construct(nums, left, index - 1);
        node.right = construct(nums, index + 1, right);
        return node;
    }

    public int findMax(int left, int right, int[] nums) {
        int index = left;
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
