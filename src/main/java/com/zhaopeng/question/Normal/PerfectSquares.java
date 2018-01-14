package com.zhaopeng.question.Normal;

/**
 * https://leetcode.com/problems/perfect-squares/description/
 * Created by zhaopeng on 2018/1/8.
 */
public class PerfectSquares {

    /**
     * dp[0] = 0
     * dp[1] = dp[0]+1 = 1
     * dp[2] = dp[1]+1 = 2
     * dp[3] = dp[2]+1 = 3
     * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
     * = Min{ dp[3]+1, dp[0]+1 }
     * = 1
     * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
     * = Min{ dp[4]+1, dp[1]+1 }
     * = 2
     * <p>
     * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
     * = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
     * = 2
     * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        int dp[] = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int j = 1;
            dp[i] = Integer.MAX_VALUE;
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }

    //递归应该能做，找到最大的平方数，选一个，然后继续，

    public int numSquares1(int n){

        return 0;
    }

    public int helper(int target, int n) {

        return 0;
    }
}
