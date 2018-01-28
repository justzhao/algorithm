package com.zhaopeng.array;

/**
 * Created by zhaopeng on 2018/1/21.
 */
public class Powerxn {

    public static void main(String args[]) {
        double x = 2.00000;
        int n = 2;
        Powerxn p = new Powerxn();
        System.out.println(p.myPow(x, n));
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    public double power(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double p = power(x, n / 2);
        if (n % 2 == 0) {
            return p * p;
        } else {
            return x * p * p;
        }

    }

    /**
     * 为什么TLE， 因为重复计算powerTLE(d,n/2)
     *
     * @param x
     * @param n
     * @return
     */
    public double powerTLE(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return powerTLE(x, n / 2) * powerTLE(x, n / 2);
        } else {
            return x * powerTLE(x, n / 2) * powerTLE(x, n / 2);
        }

    }
}
