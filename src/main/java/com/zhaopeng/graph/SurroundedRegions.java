package com.zhaopeng.graph;

/**
 * https://leetcode.com/problems/surrounded-regions/description/
 * Created by zhaopeng on 2018/1/23.
 * <p>
 * DFS吗， 怎么DFS
 * 找边界 o 能接触到所有的o，这样的o一定不能被x包住，
 * 其他o一定会被x包住
 * <p>
 * <p>
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 *
 * [["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]]
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        // 行数
        int m = board.length;
        //列数
        int n = board[0].length;
        // 第一列和最后一列
        for (int i = 0; i < m; i++) {
            //第一列
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            //最后一列
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        //第一行和最后一行
        for (int i = 0; i < n; i++) {
            //第一行
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            //最后一行
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        //标记此字符无法被包围
        board[i][j] = 'N';
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);


    }

}
