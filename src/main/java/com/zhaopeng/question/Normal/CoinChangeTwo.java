package com.zhaopeng.question.Normal;

/**
 * 找零钱，给定一些零钱和一个数值，最多有多少种方式组成数值
 * Created by zhaopeng on 2017/6/19.
 */
public class CoinChangeTwo {

    public int change(int amount, int[] coins) {

        int res[] = new int[amount + 1];

        res[0] = 1;
        // 动态规划，
        // 对于每个零钱，从1开始，看有几种方式组成数字
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    res[j] = res[j] + res[j - coins[i]];
                }
            }
        }

        return res[amount];
    }

    public static void main(String args[]) {

        CoinChangeTwo s = new CoinChangeTwo();
        int amount = 5;
        int coins[] = {1, 2, 5};
        System.out.println(s.change(amount, coins));
    }

}
