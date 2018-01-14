package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 * Created by zhaopeng on 2017/12/30.
 */
public class SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {


        if(isSame(s,t)){
            return true;
        }
        return  isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    public boolean isSame(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null){
            return false;
        }
        if(t==null){
            return false;
        }
        if(s.val!=t.val){
            return false;
        }
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}
