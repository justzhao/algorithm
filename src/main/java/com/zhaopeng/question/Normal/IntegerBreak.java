package com.zhaopeng.question.Normal;

/**
 * https://leetcode.com/problems/integer-break/description/
 * Created by zhaopeng on 2018/5/6.
 */
public class IntegerBreak {

    public int integerBreak(int n) {

        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i-j)*j,dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
