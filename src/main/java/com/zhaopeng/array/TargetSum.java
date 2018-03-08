package com.zhaopeng.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/target-sum/discuss/97334
 * Created by zhaopeng on 2018/1/1
 * <p>
 * The recursive solution is very slow, because its runtime is exponential
 * <p>
 * The original problem statement is equivalent to:
 * Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target
 * <p>
 * Let P be the positive subset and N be the negative subset
 * For example:
 * Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
 * Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
 * <p>
 * Then let’s see how this can be converted to a subset sum problem:
 * <p>
 * sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 * 2 * sum(P) = target + sum(nums)
 * So the original problem has been converted to a subset sum problem as follows:
 * Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
 * <p>
 * Note that the above formula has proved that target + sum(nums) must be even
 * We can use that fact to quickly identify inputs that do not have a solution (Thanks to @BrunoDeNadaiSarnaglia for the suggestion)
 * For detailed explanation on how to solve subset sum problem, you may refer to Partition Equal Subset Sum
 */
public class TargetSum {

    public static void main(String args[]) {
        TargetSum o = new TargetSum();


        int a[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int s = 0;
        System.out.println(o.findTargetSumWays(a,s));
    }


    public int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //sum(P) = (target + sum(nums)) / 2


        if (sum < S || (S + sum) % 2 == 1) {
            return 0;
        }


        Arrays.sort(nums);

        return helper(nums, (S + sum) / 2, 0);
    }

    /**
     * 从nums中寻找一个子集合 和为target 的个数
     *
     * @param nums
     * @param target
     * @return
     */
    public int helper(int nums[], int target, int index) {
        if (target < 0) {
            return 0;
        }

        int count = 0;
        if (target == 0) {
            count++;
        }

        for (int i = index; i < nums.length; i++) {
            count += helper(nums, target - nums[i], i + 1);
            // 为什么不要去重，因为根据题意，所有的组合
/*
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
*/
        }
        return count;
    }

    /**
     * 从nums中寻找一个子集合 和为target 的个数
     * @param nums
     * @param s
     * @return
     */
    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }









    int res=0;
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;

        helper(nums, S,0,0);
        return res;
    }

    public void helper(int[] nums, int S,int sum, int start){
        if(start==nums.length){
            if(sum == S){
                res++;
            }
            return;
        }
        helper(nums,S,sum-nums[start],start+1);
        helper(nums,S,sum+nums[start],start+1);
    }
}
