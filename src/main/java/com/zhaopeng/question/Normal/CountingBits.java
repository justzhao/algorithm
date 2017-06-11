package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/6/11.
 * <p>
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 */

/**
 *  以2的倍数为分界点， 比如 区间 2n 到  4n和  区间 n 到2n 相比，前者二进制的最高位为1，其他的都为区间n-2n的二进制组成。
 */
public class CountingBits {

    public int[] countBits(int num) {

        int res[] = new int[num + 1];

        res[0] = 0;

        int d = 1;
        for (int i = 1, j = 0; i <= num; i++, j++) {

            if (i == d) {
                d = d * 2;
                j = 0;
            }


            res[i] = res[j] + 1;
        }

        return res;

    }
}
