package com.zhaopeng.question.Normal;

/**
 * 做完算法题自己弄几个容易的单侧跑跑，
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 * Created by zhaopeng on 2018/1/29.
 */
public class SumofSquareNumbers {

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        if (c == 0 || c == 1) {
            return true;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        return false;
    }
}
