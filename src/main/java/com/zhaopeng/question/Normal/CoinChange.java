package com.zhaopeng.question.Normal;

import java.util.Arrays;

/**
 * 找零钱，给定一些零钱和一个数值，使用最少的零钱组成这个数字
 * Created by zhaopeng on 2017/5/24.
 */
public class CoinChange {

    public static int result = 0;

    public int coinChange(int[] coins, int amount) {


        Arrays.sort(coins);
        doChanage(coins, amount, coins.length - 1);

        return result;

    }

    public void doChanage(int[] coins, int amount, int index) {

        if (index == -1) {
            result = -1;
            return;
        }
        if (amount == 0) {
            return;
        }

        int j = -1;
        for (int i = index; i >= 0; i--) {
            if (coins[i] == amount) {
                result++;
                return;
            }
            if (coins[i] < amount) {
                j = i;
                break;
            }

        }
        if (j < 0) {
            result = -1;
            return;
        }
        result++;
        doChanage(coins, amount - coins[j], j);

    }

    public static void main(String args[]) {
        CoinChange c = new CoinChange();
        int coins[] = new int[1];
        coins[0] = 1;
        int amount = 2;
        System.out.println(c.coinChange(coins, amount));
    }


    //动态规划
    public static int coinChange11(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        // 用来保存结果
        int[] minNumber = new int[amount + 1];
        //  当amount= i的时候最小组成的个数.
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                // 当前
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                    // 当前 数字i的最少组成个数要么是当前不变，要么是前面的1 + minNumber[i - coins[j]]
                    minNumber[i] = Math.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
        if (minNumber[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return minNumber[amount];
    }
}
