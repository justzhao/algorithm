package com.zhaopeng.graph;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * Created by zhaopeng on 2018/1/30.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //为什么要标记第一行和第一列，因为不确认第一行中的0，是本来就有，还是被赋值的。
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //第一行
        if (row) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }
}
