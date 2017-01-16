package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 获取二叉树根到叶子节点的所有路径 第二个版本
 * Created by zhaopeng on 2016/11/13.
 * <p>
 *    1
 * /   \
 * 2     3
 * \
 * 5
 */

public class BinaryTreePathsV2 {

    List<String> list = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        String result="";
        traversTreePath(root,result);
        return list;
    }

    public void traversTreePath(TreeNode node, String result) {
         //空树判断
        if(node==null){
            return;
        }
        result+=node.val;
        if(node.left==null&&node.right==null){
            list.add(result);
            return;
        }
        result+="->";
        if(node.left!=null){
            traversTreePath(node.left,result);
        }
        if(node.right!=null){
            traversTreePath(node.right,result);
        }
    }
}
