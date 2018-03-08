package com.zhaopeng.digital;

/**
 * https://leetcode.com/problems/ugly-number-ii/description/
 * Created by zhaopeng on 2018/2/14.
 * <p>
 * <p>
 * 1,
 * 2, 3, 4, 5, 6, 8, 9, 10, 12
 * <p>
 * <p>
 * fac=2,3,5
 */
public class UglyNumberII {

    /**
     * 类似归并排序，每次选取最小的丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        /**
         *  1,2, 3, 4, 5, 6, 8, 9, 10
         */
        int res[] = new int[n];
        int fac2 = 2, index2 = 1;
        int fac3 = 3, index3 = 1;
        int fac5 = 5, index5 = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(fac2, Math.min(fac3, fac5));
            res[i] = min;
            if (fac2 == min) {
                fac2 = 2 * res[index2++];
            }
            if (fac3 == min) {
                fac3 = 3 * res[index3++];
            }
            if (fac5 == min) {
                fac5 = 5 * res[index5++];
            }
        }
        return res[n - 1];

    }
}
