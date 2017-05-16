package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2017/5/16.
 * 重塑矩阵
 */
public class ReshapetheMatrix {


    public int[][] matrixReshape(int[][] nums, int r, int c) {

        if (nums == null) {
            return nums;
        }
        if (nums.length == 0) {
            return nums;
        }

        if (r * c != nums.length * nums[0].length) {
            return nums;
        }

        int result[][] = new int[r][c];

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums[i].length; j++) {

                int index = i * nums[i].length + j;

                int x = index / c;
                int y = index % c;
                result[x][y] = nums[i][j];


            }

        }

        return result;
    }


    public static void main(String args[]){

        int nums[][]=new int[2][2];
        // [[1,2],[3,4]]
        nums[0][0]=1;
        nums[0][1]=2;
        nums[1][0]=3;
        nums[1][1]=4;
        ReshapetheMatrix m=new ReshapetheMatrix();

        int c=1;int r=4;
        System.out.println(m.matrixReshape(nums,c,r));

    }
}
