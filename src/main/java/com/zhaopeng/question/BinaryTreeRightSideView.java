package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，假设你站在二叉树的右边，给出你看到的节点
 * Created by zhaopeng on 2016/12/18.
 * <p>
 * 层次遍历，从右边开始,
 * 出队列的时候，可以记录到下一层中的节点的个数
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);
        int count = 1;
        int nextcount = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count--;
            if (node.right != null) {
                queue.add(node.right);
                nextcount += 1;
            }
            if (node.left != null) {
                queue.add(node.left);
                nextcount += 1;
            }
            if (count == 0) {
                if(queue.peek()!=null) result.add(queue.peek().val);
                count=nextcount;
                nextcount=0;
            }

        }
        return result;
    }

    public  static  void  main(String args[]){
        TreeNode root=new TreeNode(1);
        TreeNode root2=new TreeNode(2);
        TreeNode root3=new TreeNode(3);
        TreeNode root4=new TreeNode(4);
        root.left=root2;
        root.right=root3;
        root2.left=root4;
        BinaryTreeRightSideView binaryTreeRightSideView=new BinaryTreeRightSideView();
        System.out.println(binaryTreeRightSideView.rightSideView(root));
    }
}
