package com.zhaopeng.question;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * Created by zhaopeng on 2017/12/24.
 */
public class PrintMartix {


    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = col - 1;

        while (top <= bottom && left <= right) {

            // 左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            //上到下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            // 额外加条件是防止重复打印
            //右到左
            for (int i = right - 1; i >= left&&bottom>top; i--) {
                res.add(matrix[bottom][i]);
            }
            //下到上
            for (int i = bottom - 1; i > top&&right>left; i--) {
                res.add(matrix[i][left]);
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;

    }



    public ArrayList<Integer> printMatrix2 (int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }

        printMatrixClockWisely(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);

        return result ;
    }

    public void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if(startRow<endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }   //Right
            for(int i=startRow+1; i<=endRow-1; i++) { result.add(matrix[i][endCol]) ; }     //Down
            for(int j=endCol; j>=startCol; j--) { result.add(matrix[endRow][j]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
            printMatrixClockWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }
    }
}
