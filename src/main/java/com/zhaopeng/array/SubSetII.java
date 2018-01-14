package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 * Created by zhaopeng on 2017/12/30.
 */
public class SubSetII {


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        helper(nums, res, new ArrayList<Integer>(), 0);

        return res;

    }

    public void helper(int nums[], List<List<Integer>> res, List<Integer> temp, int index) {

        res.add(new ArrayList<Integer>(temp));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            //取当前数字，
            helper(nums, res, temp, i + 1);
            //不取当前数字
            temp.remove(temp.size() - 1);
        }

    }
}
