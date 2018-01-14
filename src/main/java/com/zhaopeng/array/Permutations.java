package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 * Created by zhaopeng on 2017/12/27.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        helper(res, nums, 0);
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }

    //回溯法
    public void helper(List<List<Integer>> res, List<Integer> temp, int nums[]) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        // 不断的取每个元素，已经取过的 就continue
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            helper(res, temp, nums);
            temp.remove(temp.size()-1);
        }

    }

     // 交换法，
    public void helper(List<List<Integer>> res, int[] nums, int index) {

        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) {
                temp.add(n);
            }
            res.add(temp);
        }
        // 每个数字和后面的数字交换，
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(res, nums, index + 1);
            swap(nums, index, i);
        }
    }

    void swap(int nums[], int l, int k) {

        int t = nums[l];
        nums[l] = nums[k];
        nums[k] = t;

    }

}
