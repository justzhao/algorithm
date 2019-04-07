package com.zhaopeng.question.Normal;

import java.util.Arrays;

/**
 * 找零钱，给定一些零钱和一个数值，使用最少的零钱组成这个数字.
 * 完全背包问题哦
 * Created by zhaopeng on 2017/5/24.
 */
public class CoinChange {

    public static void main(String args[]) {
        CoinChange c = new CoinChange();
        int coins[] = new int[2];
        //1,2147483647
        coins[0] = 1;
        coins[1]=2147483647;
        int amount = 1;
        System.out.println(c.coinChange22(coins, amount));
    }


    /**
     * 这个应该是最nice的。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange22(int[] coins, int amount) {


        if (coins == null || coins.length < 0 || amount < 0) {
            return 0;
        }

        // f[i][j]表示最 总量为j的时候使用 前i个硬币最小的组成方法。
        //f[i][j]=min(f[i-1][j],f[i][j-coins[i-1]]+1);
        int f[][] = new int[coins.length + 1][amount + 1];

        f[0][0] = 1;

        for (int i = 1; i <= amount; i++) {
            f[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                f[i][j] = f[i-1][j];

                if (j >= coins[i - 1]) {
                    if (f[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i ][j], f[i][j - coins[i - 1]] + 1);
                    }

                }
            }
        }
        return f[coins.length][amount]==Integer.MAX_VALUE?-1:f[coins.length][amount];

    }






        public static int result = 0;


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return result;
        }
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int index = coins.length - 1;
        while (index >= 0) {
            if (coins[index] > amount) {

            } else if (coins[index] == amount) {
                result++;
            } else {
                break;
            }
            index--;
        }
        helper(index, coins, amount);
        return result == 0 ? -1 : result;
    }
    public void helper(int index, int coins[], int amount) {
        if (index < 0) {
            return;
        }
        if (amount == 0) {
            result++;
            return;
        }
        for (int i = index; i >= 0; i--) {
            if (coins[i] > amount) {
                continue;
            } else {
                helper(i, coins, amount - coins[i]);
            }

        }

    }


    public int coinChange1(int[] coins, int amount) {

        // ServiceLoader.

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
