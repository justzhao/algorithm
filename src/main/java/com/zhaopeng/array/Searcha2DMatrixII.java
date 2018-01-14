package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Created by zhaopeng on 2018/1/8.
 */
public class Searcha2DMatrixII {

    public static void main(String args[]) {
        Searcha2DMatrixII o = new Searcha2DMatrixII();

        int a[][] = {{-1, 3}};
        int tagert = 3;
        System.out.println(o.searchMatrix(a, tagert));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, target);
    }
    //类似二分的查找
    public boolean search(int[][] matrix, int target) {

        int row = matrix.length - 1;
        int col = 0;
        // 初始值定义在 左下角
        while (row >= 0 && col < matrix[0].length) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                //target 小了，说明要减小
                row--;
            } else {
                // target大了 说明要增大
                col++;
            }
        }
        return false;
    }

    //这个方法TLE了，时间复杂度太高了
    public boolean helper(int matrix[][], int target, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] > target) {
            return false;
        } else if (helper(matrix, target, i + 1, j)) {
            return true;
        } else {
            return helper(matrix, target, i, j + 1);
        }
    }
}
