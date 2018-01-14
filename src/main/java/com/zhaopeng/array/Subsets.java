package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 * https://www.youtube.com/watch?v=93Qe_f2aL9E&list=PLvyIyKZVcfAkZLa34w830wzUq7_qhdtBO
 * Created by zhaopeng on 2017/12/27.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        helper(res, new ArrayList<Integer>(), nums, 0);

        return res;


    }

    public void helper(List<List<Integer>> res, List<Integer> temp, int nums[], int index) {

            res.add(new ArrayList<Integer>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            //取当前数字，
            helper(res, temp, nums, i + 1);
            //不取当前数字
            temp.remove(temp.size() - 1);
        }

    }

}
