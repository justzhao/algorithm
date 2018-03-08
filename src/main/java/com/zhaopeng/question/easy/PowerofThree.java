package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2018/2/3.
 */
public class PowerofThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    /**
     * It follows that 3^X == N
     It follows that log (3^X) == log N
     It follows that X log 3 == log N
     It follows that X == (log N) / (log 3)
     For the basis to hold, X must be an integer.
     * @param n
     * @return
     */

    public boolean isPowerOfThree1(int n) {
        return Math.log10(n) / Math.log10(3) % 1 == 0;
    }
}
