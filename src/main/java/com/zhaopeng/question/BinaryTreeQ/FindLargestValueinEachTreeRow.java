package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhaopeng on 2017/6/1.
 */
public class FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {


        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        int levelCount = 1;

        int nextCount = 0;
        queue.add(root);

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                nextCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextCount++;
            }

            if (max < node.val) {
                max = node.val;
            }

            levelCount--;
            if (levelCount == 0) {
                //进入下一层;
                result.add(max);
                levelCount = nextCount;
                nextCount = 0;
                max = Integer.MIN_VALUE;
            }

        }


        return result;

    }

    public static void main(String args[]){
        FindLargestValueinEachTreeRow s=new FindLargestValueinEachTreeRow();

    }
}
