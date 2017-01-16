package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 在二叉搜素树中，求第k个最小的数字
 * 思想：中顺序遍历
 * Created by zhaopeng on 2016/11/12.
 */
public class KthSmallestBinaryTree {

    public static   int  result;

    public static  int count;

    public int kthSmallest(TreeNode root, int k) {
        count=k;
       findKthSmall(root);
       return result;
    }

    public  boolean  findKthSmall(TreeNode node){


        if(node==null){
            return false;
        }
        if(findKthSmall(node.left))
            return true;
        count--;
        if(count==0){
            result=node.val;
            return true;
        }
       return findKthSmall(node.right);
    }

    public void cal(int i){

        i=i-1;

    }
    public static  void main(String args[]){

        TreeNode root=new TreeNode(2);
        TreeNode left=new TreeNode(1);
        root.left=left;



        KthSmallestBinaryTree k=new KthSmallestBinaryTree();

        k.kthSmallest(root,2);
        System.out.println(result);

/*        int i=1;
        System.out.println(i);
        k.cal(i);
        System.out.println(i);*/

    }
}
