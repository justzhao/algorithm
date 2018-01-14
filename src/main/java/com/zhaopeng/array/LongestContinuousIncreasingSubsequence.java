package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 * Created by zhaopeng on 2017/12/30.
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res[] = new int[nums.length];
        int max = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = 1;
            if (nums[i] > nums[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
            max = Math.max(res[i], max);
        }
        return max;
    }
}
