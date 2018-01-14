package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 * Created by zhaopeng on 2017/12/30.
 */
public class NumberofLongestIncreasingSubsequence {

    public static void main(String args[]) {
        NumberofLongestIncreasingSubsequence o = new NumberofLongestIncreasingSubsequence();


        int a[] = {1, 2, 4, 3, 5, 4, 7, 2};

        System.out.println(o.findNumberOfLIS(a));
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean all = false;

        int res[] = new int[nums.length];
        int ways[] = new int[nums.length];

        int count = 0;
        int max = 1;
        // 遍历这个数组
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
            ways[i] = 1;
            //遍历i 前面的结果。
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (res[i] == res[j] + 1) {
                        ways[i] = ways[j] + ways[i];
                    }
                    if (res[i] < res[j] + 1) {
                        res[i] = res[j] + 1;
                        ways[i] = ways[j];
                    }
                }
            }
            if (max == res[i]) {
                count = ways[i] + count;
            }
            if (max < res[i]) {
                max = res[i];
                count = ways[i];
            }
        }
        return count;

    }
}
