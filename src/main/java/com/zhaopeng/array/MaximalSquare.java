package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/maximal-square/description/
 * Created by zhaopeng on 2018/1/4.
 */
public class MaximalSquare {


    public int maximalSquare(char[][] matrix) {

        int res = 0;
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    //上左 对角取最小值
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i][j], dp[i + 1][j]))+1;
                    res = Math.max(res, dp[i + 1][j + 1]);
                }
            }
        }
        return res * res;

    }
}
