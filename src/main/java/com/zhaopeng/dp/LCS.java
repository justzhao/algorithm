package com.zhaopeng.dp;

/**
 * 最长公共序列
 * 最长公共子序列与最长公共子串的区别在于最长公共子序列不要求在原字符串中是连续的，比如ADE和ABCDE的最长公共子序列是ADE。
 * Created by zhaopeng on 2018/2/22.
 */
public class LCS {


    public static void main(String[] args) {

        outerloop:
        for (int i = 1; i <5; i++) {
            for (int j = 1; j < 5; j++) {
                if (i * j > 3) {
                    break outerloop;
                }
                System.out.printf("i=%d, j=%d \n", i, j);
            }
        }
    }

    public int lengthofLCS(String A, String B) {

        if (A == null || B == null) {
            return 0;
        }
        int dp[][] = new int[A.length() + 1][B.length() + 1];

        int res = 0;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                 //子序列嘛，前面的结果也能用上
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }


        return res;
    }
}
