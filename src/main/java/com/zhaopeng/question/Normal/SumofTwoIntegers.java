package com.zhaopeng.question.Normal;

/**
 * https://leetcode.com/problems/sum-of-two-integers/description/
 * <p>
 * 不使用加减完成加法
 * Created by zhaopeng on 2018/1/28.
 * <p>
 * 0+1 =01  异或操作
 * 1+0 =01  异或操作
 * <p>
 * 1+1 =10  与操作看是否有借位
 */
public class SumofTwoIntegers {

    /**
     * 加法操作，看是否产生借位，如果有借位需要进行下一轮操作
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {

        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
