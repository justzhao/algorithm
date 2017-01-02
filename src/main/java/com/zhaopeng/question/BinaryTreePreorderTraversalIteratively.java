package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 前序遍历二叉树非递归
 * Created by zhaopeng on 2017/1/2.
 */
public class BinaryTreePreorderTraversalIteratively {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return result;
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(node.val);

            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }

        return  result;
    }

    public  static void main(String args[]){
        BinaryTreePreorderTraversalIteratively v=new BinaryTreePreorderTraversalIteratively();
        TreeNode root=new TreeNode(1);
        TreeNode right=new TreeNode(2);
        TreeNode left=new TreeNode(3);
        root.right=right;
        right.left=left;
        System.out.println(v.preorderTraversal(root));
    }

}
