package com.zhaopeng.graph;

/**
 * Created by zhaopeng on 2018/1/26.
 */
public class LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int cache[][] = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, i, j, m, n, Integer.MIN_VALUE, cache);
                res = Math.max(res, max);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int min, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n || min >= matrix[i][j]) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int a = dfs(matrix, i + 1, j, m, n, matrix[i][j], cache);
        int b = dfs(matrix, i - 1, j, m, n, matrix[i][j], cache);
        int c = dfs(matrix, i, j + 1, m, n, matrix[i][j], cache);
        int d = dfs(matrix, i, j - 1, m, n, matrix[i][j], cache);
        int res = Math.max(a, Math.max(b, Math.max(c, d))) + 1;
        cache[i][j] = res;
        return res;
    }

}
