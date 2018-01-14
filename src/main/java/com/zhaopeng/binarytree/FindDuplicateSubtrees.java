package com.zhaopeng.binarytree;

import com.zhaopeng.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaopeng on 2017/12/24.
 * <p>
 * https://leetcode.com/problems/find-duplicate-subtrees/description/,
 * test case 有问题
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> res = new ArrayList<>();

        find(root, res, new HashMap<String, Integer>());

        return res;
    }

    public String find(TreeNode node, List<TreeNode> res, Map<String, Integer> count) {

        if (node == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(",");
        sb.append(find(node.left, res, count)).append(",");
        sb.append(find(node.right, res, count));
        if (count.get(sb.toString()) == null) {
            count.put(sb.toString(), 1);

        } else {
            if (count.get(sb.toString()) == 1) {
                res.add(node);
            }
            count.put(sb.toString(), count.get(sb.toString()) + 1);
        }
        return sb.toString();

    }

}
