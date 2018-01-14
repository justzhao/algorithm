package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 * Created by zhaopeng on 2018/1/9.
 */
public class NumberofIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                if (grid[i][j] == '1') {
                    visit(grid, i + 1, j, visited);
                    visit(grid, i - 1, j, visited);
                    visit(grid, i, j + 1, visited);
                    visit(grid, i, j - 1, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void visit(char[][] grid, int i, int j, boolean visited[][]) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j]=true;
        if (grid[i][j] == '1') {
            visit(grid, i + 1, j, visited);
            visit(grid, i - 1, j, visited);
            visit(grid, i, j + 1, visited);
            visit(grid, i, j - 1, visited);
        }

    }

}
