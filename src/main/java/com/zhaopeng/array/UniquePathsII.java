package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 * Created by zhaopeng on 2017/12/31.
 */
public class UniquePathsII {


    public static void main(String args[]){

        UniquePathsII o=new UniquePathsII();

        int a[][]={{0,0},{0,0}};

        System.out.println(o.uniquePathsWithObstacles(a));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int res[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                        res[i][j] = 0;
                    } else if (obstacleGrid[i - 1][j] == 1) {
                        res[i][j] = res[i][j - 1];
                    } else if(obstacleGrid[i][j-1]==1) {
                        res[i][j] = res[i - 1][j];
                    }else {
                        res[i][j]=res[i-1][j]+res[i][j-1];
                    }
                } else if (i - 1 >= 0) {
                    //j-1<=0
                    if (obstacleGrid[i - 1][j] == 1) {
                        res[i][j] = 0;
                    } else {
                        res[i][j] = res[i - 1][j];
                    }

                } else if (j - 1 >= 0) {
                    //i-1<=0;
                    if (obstacleGrid[i][j - 1] == 1) {

                        res[i][j] = 0;
                    } else {
                        res[i][j] = res[i][j - 1];
                    }
                } else {

                    res[i][j] = 1;
                }
            }
        }

        return res[m - 1][n - 1];
    }
}
