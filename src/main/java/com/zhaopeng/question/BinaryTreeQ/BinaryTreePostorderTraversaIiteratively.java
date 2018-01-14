package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**  https://leetcode.com/problems/binary-tree-postorder-traversal/description/s
 * 非递归后续遍历二叉树
 * Created by zhaopeng on 2017/1/2.
 */
public class BinaryTreePostorderTraversaIiteratively {

    class NodeWrapper {
        TreeNode node;

        boolean visited = false;

        public NodeWrapper(TreeNode node) {
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<NodeWrapper> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                NodeWrapper w = new NodeWrapper(cur);
                stack.push(w);
                cur = w.node.left;
            }
            NodeWrapper w = stack.pop();
            if (!w.visited) {
                w.visited = true;
                stack.push(w);
                cur = w.node.right;
            } else {
                res.add(w.node.val);
            }
        }
        return res;
    }


    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;
        TreeNode last = root; //用来保存上一次访问的节点，如果当前节点的右子树是上一次的访问节点，就可以出栈
        stack.push(root);
        /**
         * 栈不为空，左子树进栈
         */
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if ((node.left == null && node.right == null) || (node.left == last && node.right == null) || node.right == last) {
                result.add(node.val);
                last = node;
                stack.pop();
                continue;
            }
            //栈是先进后出
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;

        BinaryTreePostorderTraversaIiteratively v = new BinaryTreePostorderTraversaIiteratively();
        System.out.println(v.postorderTraversal(root));
    }
}
