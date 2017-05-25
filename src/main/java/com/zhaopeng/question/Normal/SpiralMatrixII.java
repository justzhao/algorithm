package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/5/26.
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int array[][] = new int[n][n];
        int max = n * n;
        processMatrix(array, 0, n, 1, max);
        return array;

    }

    /**
     * @param matrix
     * @param row    定义了矩阵边界的 小值
     * @param col    定义了矩阵边界的 大值
     * @param value
     * @param max
     */
    public void processMatrix(int[][] matrix, int row, int col, int value, int max) {
        if (row > col || value > max) {
            return;
        }

        for (int i = row; i < col; i++) {

            matrix[row][i] = value;
            value++;
        }
        for (int j = row + 1; j < col; j++) {
            matrix[j][col - 1] = value;
            value++;
        }
        for (int m = col - 2; m > row; m--) {
            matrix[col - 1][m] = value;
            value++;
        }
        for (int n = col - 1; n > row; n--) {
            matrix[n][row] = value;
            value++;
        }
        processMatrix(matrix, row + 1, col - 1, value, max);
    }

}
