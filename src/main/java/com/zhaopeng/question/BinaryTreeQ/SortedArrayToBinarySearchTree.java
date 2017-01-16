package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2016/11/20.
 */
public class SortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums==null||nums.length==0){
            return null;
        }

        return bulidBST(0,nums.length-1,nums);

    }
    public TreeNode bulidBST(int start,int end,int []nums){

        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=bulidBST(start,mid-1,nums);
        root.right=bulidBST(mid+1,end,nums);

        return root;
    }

}
