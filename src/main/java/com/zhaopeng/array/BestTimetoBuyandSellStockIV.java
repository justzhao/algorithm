package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 * <p>
 * https://www.youtube.com/watch?v=6wjJ404h42E
 * Created by zhaopeng on 2018/1/3.
 */
public class BestTimetoBuyandSellStockIV {

    public static void main(String args[]){
        BestTimetoBuyandSellStockIV o=new BestTimetoBuyandSellStockIV();

        int a[]={2,1,2,0,1};

        int k=2;
        System.out.println(o.maxProfit1(k,a));

    }

    public int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        // k次交易，表示2k次买卖

        if (k >= prices.length / 2) {
            return getPrifit(prices);
        }

        // 进行 i次交易的时候，轮询 每天价格获取到的利润。一次交易包含一次买和卖
        int res[][] = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {

            // 先买为敬
            int buyPrifit = -prices[0];
            // 买卖操作

            for (int j = 1; j < prices.length; j++) {
                // 交易i次数的 前一天  利润 和今天卖的利润 对比
                //卖
                res[i][j] = Math.max(res[i][j - 1], prices[j] + buyPrifit);
                //   前面的利润，和这次执行买的利润的对比。
                // 买
                buyPrifit = Math.max(buyPrifit, res[i - 1][j - 1] - prices[j]);
            }

        }
        return res[k][prices.length - 1];

    }

    public int maxProfit1(int k, int[] prices) {

        int n = prices.length;
        if (2 * k >= n) {
            return getPrifit(prices);
        }
        // 2k次买卖
        int dp[] = new int[2 * k + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < Math.min(i + 1, 2 * k) + 1; j++) {
                if (j % 2 == 1) {
                    // 买
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    //卖
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }

        return dp[dp.length - 1];


    }

    public int getPrifit(int prices[]) {
        int res = 0, i = 0;
        while (i < prices.length) {
            // 找到最小的买入价格
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            int min = prices[i];
            i++;
            // 找到最大的卖出价格。
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            res += i < prices.length ? prices[i] - min : 0;
            i++;
        }
        return res;

    }
}
