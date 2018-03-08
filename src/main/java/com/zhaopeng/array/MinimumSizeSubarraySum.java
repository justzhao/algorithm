package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Created by zhaopeng on 2018/2/4.
 */
public class MinimumSizeSubarraySum {

    /**
     * 滑动窗口的思想
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {

        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

