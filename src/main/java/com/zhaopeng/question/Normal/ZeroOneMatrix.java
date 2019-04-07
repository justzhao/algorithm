package com.zhaopeng.question.Normal;

/**https://leetcode.com/problems/01-matrix/description/
 * Created by zhaopeng on 2018/7/1.
 */
public class ZeroOneMatrix {

    /**
     * Example 2:
     * Input:
     * <p>
     * 0 0 0
     * 0 1 0
     * 1 1 1
     * Output:
     * 0 0 0
     * 0 1 0
     * 1 2 1
     *
     * @param matrix
     * @return
     */

    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return matrix;
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !hasNeighborZero(i, j, matrix)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 1) {
                    dfs(i, j, matrix, -1);
                }

            }
        }
        return matrix;
    }

    private void dfs(int x, int y, int[][] matrix, int dis) {
        /**
         * 合法校验
         */
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return;
        }
        // 要么为0要么为1，要么已经遍历了

        if(matrix[x][y]<=dis){
            return;
        }
        if (dis>0) {
            matrix[x][y] = dis;
        }
        dfs(x + 1, y, matrix, matrix[x][y] + 1);
        dfs(x - 1, y, matrix, matrix[x][y] + 1);
        dfs(x, y + 1, matrix, matrix[x][y] + 1);
        dfs(x, y - 1, matrix, matrix[x][y] + 1);

    }

    private boolean hasNeighborZero(int x, int y, int[][] matrix) {

        if (x < 0 || x > matrix.length || y < 0 || y > matrix[0].length) {
            return false;
        }

        if (x > 0 && matrix[x - 1][y] == 0) {
            return true;
        }

        if (x < matrix.length - 1 && matrix[x + 1][y] == 0) {
            return true;
        }

        if (y > 0 && matrix[x][y - 1] == 0) {
            return true;
        }

        if (y < matrix[0].length - 1 && matrix[x][y + 1] == 0) {
            return true;
        }
        return false;
    }
}
