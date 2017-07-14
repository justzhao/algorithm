package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

/**
 * Created by zhaopeng on 2017/7/15.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

       if(p.val==q.val){
           return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
       }else {
           return false;
       }

    }



}
