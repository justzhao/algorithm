package com.zhaopeng.dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * Created by zhaopeng on 2018/6/2.
 */
public class MinCostClimbingStairs {


    /**
     * dp[i]=min(dp[i-1],dp[i-2]) +cost[i]
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) {
            return 0;
        }
        int dp[] = new int[cost.length + 1];

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = cost[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 1];
            }
        }
        return dp[cost.length - 1] < dp[cost.length] ? dp[cost.length - 1] : dp[cost.length];
    }
}
