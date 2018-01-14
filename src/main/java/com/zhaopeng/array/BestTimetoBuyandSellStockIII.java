package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * Created by zhaopeng on 2018/1/2.
 */
public class BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 四个变量表示操作后剩下的利润
        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;

        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int i = 0; i < prices.length; i++) {

            buy1 = Math.min(buy1, prices[i]);
            // 第一次卖剩下的利润
            sell1 = Math.max(sell1, prices[i] -buy1);
            //第二次买 剩下的利润
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //第二次卖剩下的利润
            sell2 = Math.max(sell2, prices[i] + buy2);
        }

        return sell2;
    }
}
