package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * Created by zhaopeng on 2018/2/14.
 */
public class Searcha2DMatrix {


    public static void main(String args[]) {

        Searcha2DMatrix o = new Searcha2DMatrix();

        int a[][] = {{1, 1}};
        int target = 0;
        System.out.println(o.searchMatrix(a, target));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int s = 0;
        int e = rows * cols - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            int value = matrix[mid / cols][mid % cols];
            if (value == target) {
                return true;
            } else if (value < target) { //value 的值太小了，需要编导。
                s = mid + 1;
            } else {// value 值太大了。
                e = mid;
            }
        }

        return matrix[s / cols][s % cols] == target;
    }

}
