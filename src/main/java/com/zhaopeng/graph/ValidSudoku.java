package com.zhaopeng.graph;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 * Created by zhaopeng on 2018/1/30.
 */
public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }
                //每个大方块 对于每个i，表示第 i个大方块。
                int rowIndex = 3 * (i / 3); //每个cube的第一行
                int colIndex = 3 * (i % 3);// 每个cube的第一列
                int row = rowIndex + j / 3;
                int col = colIndex + j % 3;
                if (board[row][col] != '.' && !cube.add(board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }
}
