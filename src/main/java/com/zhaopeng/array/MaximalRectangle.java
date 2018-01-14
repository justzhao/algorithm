package com.zhaopeng.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-square/description/
 * Created by zhaopeng on 2018/1/5.
 */
public class MaximalRectangle {

    public static void main(String args[]) {
        MaximalRectangle o = new MaximalRectangle();


    }

    /**
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // 一层一层的遍历。求取每一层的最大矩形面积
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(right, n);
        int height[] = new int[n];
        for (int i = 0; i < m; i++) {

            int l = 0;
            int r = n;
            // 求取当前层每个列的高度，
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            // left[j] 表示从j开始，连续1的第一个索引。
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 当前列，连续1 的最大的第一个索引 。
                    left[j] = Math.max(l, left[j]);
                } else {
                    left[j] = 0;
                    l = j + 1;//记录下一个可能为1的坐标备用。
                }
            }
            //right[j] 表示从j开始 连续1的结尾的索引。
            for (int j = n - 1; j >= 0; j++) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(r, right[j]);
                } else {
                    r = j;
                    right[j] = n;
                }
            }
            for (int j = 0; j < n; j--) {
                res = Math.max(res, height[j] * (right[j] - left[j]));
            }
        }

        return res;
    }
}
