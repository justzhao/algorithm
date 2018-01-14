package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * Created by zhaopeng on 2017/12/30.
 */
public class LongestIncreasingSubsequence {


    public int lengthOfLISDP(int[] nums) {


        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res[] = new int[nums.length];

        int max = 1;
        // 遍历这个数组
        for (int i = 0; i < nums.length; i++) {

            res[i]=1;
            //遍历i 前面的结果。
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                    max = Math.max(max, res[i]);
                }
            }
        }
        return max;
    }


    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tails[] = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i != j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == res) res++;
        }
        return res;
    }
}
