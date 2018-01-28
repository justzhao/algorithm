package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/description/
 * Created by zhaopeng on 2018/1/28.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        helper(res, new int[n], 0);
        return res;
    }

    /**
     * @param res
     * @param queen queen[i]=k 表示第i行的 k列放置一个皇后
     * @param index
     */
    public void helper(List<List<String>> res, int queen[], int index) {
        if (index == queen.length) {
            res.add(getSolution(queen));
            return;
        }
        for (int i = 0; i < queen.length; i++) {
            queen[index] = i;
            if (isValid(queen, index)) {
                helper(res, queen, index+ 1);
            }
        }
    }

    /**
     * 如果出现在同一行，或者同一列，或者同一个对角线 都不能成为n皇后问题
     * @param queen
     * @param index
     * @return
     */
    public boolean isValid(int[] queen, int index) {

        for (int i = 0; i < index; i++) {
            if(queen[i]==queen[index]||Math.abs(i-index)==Math.abs(queen[i]-queen[index])){
                return false;
            }
        }
        return true;
    }

    public List<String> getSolution(int queen[]) {

        List<String> res=new ArrayList<>();
        //行
        for(int i=0;i<queen.length;i++){
            //列
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<queen.length;j++){
                if(queen[i]==j){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());

        }
        return res;
    }

}
