package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaopeng on 2018/2/6.
 */
public class MaximumWidthofBinaryTree {


    int res = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }
        find(root, 0, new HashMap<Integer, Integer>(), 1);
        return res;
    }

    public void find(TreeNode node, int level, Map<Integer, Integer> map, int order) {
        if (node == null) {
            return;
        }
        //最左边
        if (map.get(level) == null) {
            map.put(level, order);
        }
        res = Math.max(res, order - map.get(level)+1);
        find(node.left, level + 1, map, 2 * order);
        find(node.right, level + 1, map, 2 * order + 1);
    }
}
