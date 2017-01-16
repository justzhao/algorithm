package com.zhaopeng.question.BinaryTreeQ;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一组节点的个数，返回所有二叉搜索树
 * Created by zhaopeng on 2016/11/24.
 */
public class UniqueBinarySearchTreesV2 {
    /**
     * 思路：在1-n中任取一个节k点作为根节点，
     * 此节点的左子树在 1到k-1直接组成。右边子树由k+1到n中组成，
     * 左子树1到k-1.。可以有 a中情况，右子树k+1 到n可能有b种情况，所以需要穷举出来
     * 1到k-1 和k+1到n中又可以组成二叉搜索树，以此递归
     */


    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTree(1, n);

    }

    public List<TreeNode> generateTree(int l, int h) {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        if (l > h) {
            // 保存空叶子节点
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = l; i <= h; i++) {
            TreeNode root = new TreeNode(i);
            List<TreeNode> lefts = generateTree(l, i - 1);
            List<TreeNode> rights = generateTree(i + 1, h);
            // 遍历获取root的左右子树
            for (int j = 0; j < lefts.size(); j++) {
                for (int k = 0; k < rights.size(); k++) {

                    //list 中需要注意重复的节点
                    if(treeNodes.contains(root)){
                        root=new TreeNode(i);
                    }
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }



    public static void main(String args[]) {
        UniqueBinarySearchTreesV2 uniqueBinarySearchTreesV2 = new UniqueBinarySearchTreesV2();
        List<TreeNode> treeNodes = uniqueBinarySearchTreesV2.generateTrees(3);
        System.out.println(treeNodes);
    }
}
