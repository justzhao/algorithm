package com.zhaopeng.question.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * Created by zhaopeng on 2017/7/29.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int sums[] = new int[nums.length + 1];


        sums[0] = nums[0];


        int max = sums[0];

        //[-2,1,-3,4,-1,2,1,-5,4]
        for (int i = 1; i < nums.length; i++) {

            if (sums[i - 1] <= 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = nums[i] + sums[i - 1];
            }
            max = max < sums[i] ? sums[i] : max;
        }

        return max;
    }

    public static void main(String args[]) {
        MaximumSubarray subarray = new MaximumSubarray();

        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(subarray.maxSubArray(a));
    }
}
