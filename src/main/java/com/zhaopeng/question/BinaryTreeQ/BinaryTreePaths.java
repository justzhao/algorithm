package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 获取二叉树根到叶子节点的所有路径
 * Created by zhaopeng on 2016/11/13.
 * <p>
 *    1
 * /   \
 * 2     3
 * \
 * 5
 */

public class BinaryTreePaths {

    public Stack<Integer> stack = new Stack<Integer>();


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        traversTreePath(root, list);
        return list;
    }

    public void traversTreePath(TreeNode node, List<String> result) {
        if (node == null) {
            return;
        }
        // 找到叶子节点
        if (node.left == null && node.right == null) {
            int len = stack.size();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < len; i++) {
                buffer.append(stack.get(i) + "->");
            }
            buffer.append(node.val);
            if (buffer.length() != 0) {
                result.add(buffer.toString());
            }
            return;
        }
        stack.push(node.val);
        traversTreePath(node.left, result);
        traversTreePath(node.right, result);

        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
}
