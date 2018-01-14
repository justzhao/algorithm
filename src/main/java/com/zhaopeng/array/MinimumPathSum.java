package com.zhaopeng.array;

/**
 *
 *  数组中的子子数组 求和 可以用map存放和结果。
 * https://leetcode.com/problems/minimum-path-sum/description/
 * Created by zhaopeng on 2017/12/31.
 */
public class MinimumPathSum {



    public static void main(String args[]) {
        MinimumPathSum o = new MinimumPathSum();

        int a[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(o.minPathSum(a));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = grid[i][j];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    res[i][j] += Math.min(res[i][j - 1], res[i - 1][j]);
                } else if (i - 1 >= 0) {
                    //j-1<0
                    res[i][j] += res[i - 1][j];
                } else if (j - 1 >= 0) {
                    res[i][j] += res[i][j - 1];
                }
            }
        }

        return res[m - 1][n - 1];
    }



}
