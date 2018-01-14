package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-iii/description/
 * Created by zhaopeng on 2017/12/26.
 */

public class FindALLPathSum {

    public static void main(String args[]) {
        FindALLPathSum o = new FindALLPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left=new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        System.out.println(o.pathSum(root,-1));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //[1,-2,-3,1,3,-2,null,-1]


        List<List<Integer>> res = new ArrayList<>();
        find(root, sum, new ArrayList<Integer>(), res);
        return res;

    }

    public void find(TreeNode node, int sum, ArrayList<Integer> temp, List<List<Integer>> res) {

        if (node == null) {
            return;
        }
        temp.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        find(node.left, sum - node.val, temp, res);
        find(node.right, sum - node.val, temp, res);
        // 移除当前的节点
        temp.remove(temp.size() - 1);
    }


/*
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        find(root, target, new ArrayList<Integer>(), res);


        return res;

    }

    public void find(TreeNode node, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {

        if (node == null || sum <= 0) {
            return;
        }
        temp.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        if (sum == node.val) {
            return;
        }
        find(node.left, sum - node.val, temp, res);
        find(node.right, sum - node.val, temp, res);
        // 移除当前的节点
        temp.remove(temp.size()-1);
    }
*/

}
