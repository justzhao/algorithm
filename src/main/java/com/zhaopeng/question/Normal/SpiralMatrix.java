package com.zhaopeng.question.Normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaopeng on 2017/5/25.
 * 打印螺旋数组
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null) {
            return result;
        }


        return result;
    }


    public static direction getNextStep(int rows, int col, direction nowStep, int[][] array, int len) {
        direction nextStep = nowStep;
        //先查看当前的方向
        switch (nextStep) {
            case up:
                if (rows <= 0 || array[--rows][col] != 0) {
                    // 向上走的时候，如果本行是第0行或者 上一行的值不为0.就需要右拐
                    nextStep = direction.right;
                }
                break;
            case down:
                if (rows >= len - 1 || array[++rows][col] != 0) {
                    //向下走的时候，如果本行是第len-1 行或者下一行的值不为0，就需要左拐
                    nextStep = direction.left;
                }
                break;
            case left:
                if (col <= 0 || array[rows][--col] != 0) {
                    // 向左边走的时候，如果本列是第o列或者下一列的值不为0，就需要上拐
                    nextStep = direction.up;
                }
                break;
            case right:
                if (col >= len - 1 || array[rows][++col] != 0) {
                    //向右走的时候，如果本列是第len-1列或者下一列的值部位0，就需要下拐
                    nextStep = direction.down;
                }
                break;
        }


        return nextStep;
    }


    public void initResult(int[][] array, List<Integer> result) {

        int rows = 0;
        int col = 0;
        int value = array.length * array[0].length;
        direction ostep = direction.right;//初始化方向是右边
        direction nstep = ostep;
        while (value > 0) {
            //先从 00 开始
            //System.out.println(value);
            array[rows][col] = value;
            // 根据下一步的方向来决定row和col的加减
            //得到新的方向。
            nstep = getNextStep(rows, col, ostep, array, len);

            switch (ostep) {
                case up:
                    if (ostep == nstep) {
                        rows--;
                    } else {
                        col++;

                    }

                    break;
                case down:
                    if (ostep == nstep) {
                        rows++;
                    } else {
                        col--;
                    }

                    break;
                case left:
                    if (ostep == nstep) {

                        col--;
                    } else {

                        rows--;
                    }

                    break;
                case right:
                    if (ostep == nstep) {

                        col++;
                    } else {

                        rows++;


                    }

                    break;
            }
            ostep = nstep;
            value--;
        }


    }

    enum direction {
        up, down, left, right
    }

    /**
     * int row = 0;
     * int col = matrix.length;
     * processMatrix(matrix, result, row, col);
     * //如果是 对称矩阵可用这样的算法
     *
     * @param matrix
     * @param result
     * @param row    定义了矩阵边界的 小值
     * @param col    定义了矩阵边界的 大值
     */
    public void processMatrix(int[][] matrix, List<Integer> result, int row, int col) {
        if (row > col) {
            return;
        }
        for (int i = row; i < col; i++) {
            result.add(matrix[row][i]);
        }
        for (int j = row + 1; j < col; j++) {
            result.add(matrix[j][col - 1]);
        }
        for (int m = col - 2; m > row; m--) {
            result.add(matrix[col - 1][m]);
        }
        for (int n = col - 1; n > row; n--) {
            result.add(matrix[n][row]);
        }
        processMatrix(matrix, result, row + 1, col - 1);
    }

    public static void main(String args[]) {
        SpiralMatrix m = new SpiralMatrix();

     /*   int len = 3;
        int array[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                array[i][j] = i * len + j + 1;
            }

        }*/

        int array[][] = new int[2][1];

        array[0][0] = 3;
        array[1][0] = 5;

        System.out.println(m.spiralOrder(array));
    }
}
