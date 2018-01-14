package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * Created by zhaopeng on 2018/1/2.
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {


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

    /**
     * 贪心算法也可以
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }

        return res;

    }
}
