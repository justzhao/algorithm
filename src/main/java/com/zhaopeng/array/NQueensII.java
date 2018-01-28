package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens-ii/description/
 * Created by zhaopeng on 2018/1/28.
 */
public class NQueensII {


    private int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return count;
        }
        helper(new int[n], 0);
        return count;
    }
    /**
     * @param res
     * @param queen queen[i]=k 表示第i行的 k列放置一个皇后
     * @param index
     */
    public void helper(int queen[], int index) {
        if (index == queen.length) {
            count++;
            return;
        }
        for (int i = 0; i < queen.length; i++) {
            queen[index] = i;
            if (isValid(queen, index)) {
                helper(queen, index + 1);
            }
        }
    }

    /**
     * 如果出现在同一行，或者同一列，或者同一个对角线 都不能成为n皇后问题
     *
     * @param queen
     * @param index
     * @return
     */
    public boolean isValid(int[] queen, int index) {

        for (int i = 0; i < index; i++) {
            if (queen[i] == queen[index] || Math.abs(i - index) == Math.abs(queen[i] - queen[index])) {
                return false;
            }
        }
        return true;
    }


}
