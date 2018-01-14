package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/rotate-image/description/
 * Created by zhaopeng on 2018/1/13.
 */
public class RotateImage {

    public static void main(String args[]) {

        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage o = new RotateImage();

        o.print(a);
        o.rotate(a);

        o.print(a);


    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        helper(0, n, matrix);
        System.out.println("__________________");
        return;
    }

    public void helper(int level, int len, int m[][]) {
        if (level >= len / 2) {
            return;
        }

        for (int i = level; i < len - level - 1; i++) {
            int temp = m[level][i];
            // 左上
            m[level][i] = m[len - i - 1][level];
            // z左下
            m[len - i - 1][level] = m[len - level - 1][len - i - 1];
            // 右下
            m[len - level - 1][len - i - 1] = m[i][len - level - 1];
            //右上，
            m[i][len - level - 1] = temp;
           // print(m);

        }
        helper(level + 1, len, m);

    }

    public void print(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");

            }
            System.out.println();
        }

    }


    // swap(matrix[i][j], matrix[j][i])  swap(matrix[i][j], matrix[i][len-j-1])
    public void rotate1(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}

