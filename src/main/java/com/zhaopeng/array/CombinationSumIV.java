package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iv/description/
 * Created by zhaopeng on 2018/2/3.
 * <p>
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 */
public class CombinationSumIV {


    public static void main(String args[]) {

    /*    int target = 10;
        int[] nums = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
*/
       int nums[] = {3,1,2,4};
        int target = 4;
        CombinationSumIV o = new CombinationSumIV();
        System.out.println(o.combinationSum41(nums, target));
    }

    /**
     * dp
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (target <= 0) {
            return 0;
        }

        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                int n = i - nums[j];
                if (n < 0) {
                    break;
                }
                if (dp[n] == 0 && n == 0) {
                    dp[i] = dp[i] + 1;
                } else if (dp[n] != 0) {
                    dp[i] += dp[n];
                }

            }
        }
        return dp[target];
    }

    /**
     * backtring  TLE
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum41(int[] nums, int target) {
        if (target <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, target);
        return res.size();
    }

    public void helper(List<List<Integer>> res, List<Integer> temp,  int nums[], int target) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (target - nums[i] < 0) {
                return;
            }
            temp.add(nums[i]);
            helper(res, temp,  nums, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }


}
