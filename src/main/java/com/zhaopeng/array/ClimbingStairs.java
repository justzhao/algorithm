package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * Created by zhaopeng on 2018/1/13.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;

        int i = 1;
        int j = 2;
        for (int index = 3; index <= n; index++) {
            res = i + j;
            i = j;
            j = res;
        }
        return res;
    }
}
