package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/unique-paths/description/
 * Created by zhaopeng on 2017/12/31.
 * m行 n列
 */
public class UniquePaths {
    public static void main(String args[]) {
        UniquePaths o = new UniquePaths();

        int m = 1;
        int n = 2;
        System.out.println(o.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {

        int res[][] = new int[m + 1][n + 1];
        res[0][0] = 1;
        for (int i = 1; i < m + 1; i++) {
            res[i][0] = 1;
            for (int j = 1; j < n + 1; j++) {
                res[0][j] = 1;
                if (i - 1 > 0 && j - 1 > 0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                } else if (i - 1 > 0) {
                    //j-1<=0
                    res[i][j] = res[i - 1][j];

                } else if (j - 1 > 0) {
                    //i-1<=0;
                    res[i][j] = res[i][j - 1];
                } else {
                    res[i][j] = 1;
                }
            }
        }
        return res[m][n];
    }
}
