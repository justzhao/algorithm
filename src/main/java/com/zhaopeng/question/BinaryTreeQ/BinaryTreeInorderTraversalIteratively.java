package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树 非递归
 * Created by zhaopeng on 2017/1/2.
 */
public class BinaryTreeInorderTraversalIteratively {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = root;
        //stack.push(root);
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()) {

            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                result.add(node.val);
                node=node.right;
            }


        }
        return result;
    }

    public List<Integer> inorderTraversalv2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
       // stack.push(root);

        TreeNode node=root;
        TreeNode last=root;
        while (node!=null||!stack.isEmpty()){

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null&&last!=node.left){
                stack.push(node.left);
            }
            if((node.left==null&&node.right==null)||last==node.left){
                stack.pop();
                last=node;
                result.add(node.val);
            }
            if(!stack.isEmpty())
            node=stack.peek();
            else
                break;






        }


        return  result;
    }

    public static void main(String args[]) {
        BinaryTreeInorderTraversalIteratively v = new BinaryTreeInorderTraversalIteratively();

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        root.left = new TreeNode(0);
        right.left = left;
        System.out.println(v.inorderTraversalv2(root));

    }
}
