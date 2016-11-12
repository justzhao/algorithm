package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  中序遍历二叉树,根在中间
 * Created by zhaopeng on 2016/11/12.
 */
public class InorderTraversalBinaryTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();

        inorderTraversal(root,list);

        return list;
    }
    public void    inorderTraversal(TreeNode node,List<Integer> result){
        if(node==null){
            return;
        }
        inorderTraversal(node.left,result);
        result.add(node.val);
        inorderTraversal(node.right,result);

    }
}
