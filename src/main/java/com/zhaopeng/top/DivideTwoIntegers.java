package com.zhaopeng.top;

/**
 * https://leetcode.com/problems/divide-two-integers/discuss/
 * 除法操作，前者除以后者
 * Created by zhaopeng on 2018/1/19.
 * 1.正负号
 * 2.0
 * 3.越界
 * <p>
 * <p>
 * 19/2= 2/2+ 17/2
 * = 2/2+2/2+15/2
 * = 2/2+2/2+2/2+2/2+2/2+2/2+..........+1/2
 */
public class DivideTwoIntegers {

    public static void main(String args[]) {
        DivideTwoIntegers o = new DivideTwoIntegers();
        int a = -2147483648;
        int b = -1;
        System.out.println(o.divide(a,b));
    }

    public int divide(int dividend, int divisor) {

        long sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        if (d1 == 0 || d1 < d2) {
            return 0;
        }
        long res = div(d1, d2);
        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) (res * sign);
    }

    private long div(long d1, long d2) {
        if (d1 < d2) {
            return 0;
        }
        if (d1 == d2) {
            return 1;
        }
        long sum = d2;
        long muti = 1;
        while ((sum + sum) < d1) {
            sum += sum;
            muti += muti;
        }
        return muti + div(d1 - sum, d2);
    }
}
