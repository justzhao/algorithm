package com.zhaopeng.question;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求二叉树从根节点到叶子节点组成的数字的和
 * Created by zhaopeng on 2016/12/10.
 */
public class SumRootToLeafNumbers {

    List<String> result = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        String res = "0";
        getPath(root, res);
        int count = 0;
        for (String str : result) {
            count += Integer.valueOf(str);
        }
        return count;
    }

    public void getPath(TreeNode node, String res) {
        if(node==null){
            return;
        }
        res = res + node.val;
        if (node.left == null && node.right == null) {
            result.add(res);
            return;
        }
        getPath(node.left, res);
        getPath(node.right, res);
    }

}
