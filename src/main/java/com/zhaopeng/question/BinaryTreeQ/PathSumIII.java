package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-iii/description/
 * Created by zhaopeng on 2017/12/30.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        List<List<TreeNode>> res = new ArrayList<>();
        path(root, sum, res);
        return res.size();
    }

    public void path(TreeNode node, int sum, List<List<TreeNode>> res) {
        if (node == null) {
            return;
        }
        path(node.left, sum, res);
        path(node.right, sum, res);
        find(node, sum, new ArrayList<TreeNode>(), res);
    }

    public void find(TreeNode node, int sum, List<TreeNode> temp, List<List<TreeNode>> res) {
        if (node == null) {
            return;
        }
        temp.add(node);
        sum = sum - node.val;
        if (sum == 0) {
            res.add(new ArrayList<TreeNode>(temp));
        }
        find(node.left,sum, temp, res);
        find(node.right, sum, temp, res);

        temp.remove(temp.size() - 1);

    }

    public int pathSum1(TreeNode root, int sum) {

        if (root == null) return 0;
        int count = 0;
        count += pathSum(root.left, sum);
        count += pathSum(root.right, sum);
        count += sum(root, sum);
        return count;
    }

    int sum(TreeNode node, int sum) {
        if (node == null) return 0;
        sum = sum - node.val;
        int count = 0;

        if (sum == 0) count++;

        count += sum(node.left, sum);
        count += sum(node.right, sum);
        return count;


    }


}
