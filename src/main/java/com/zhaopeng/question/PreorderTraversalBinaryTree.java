package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  前序遍历
 * Created by zhaopeng on 2016/11/15.
 */
public class PreorderTraversalBinaryTree {

    List<Integer> list=new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {

        preOrderTree(root);

        return list;
    }

    public void  preOrderTree(TreeNode node){
        if(node==null){
            return;
        }
        list.add(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
}
