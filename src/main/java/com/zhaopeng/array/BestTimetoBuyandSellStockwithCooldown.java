package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * Created by zhaopeng on 2018/1/11.
 * <p>
 * <p>
 * transactions = [buy, sell, cooldown, buy, sell]
 * // 此次买获取的利润是 前一次买获取的和 此次买的利润的最大值， 而此次买的利润等于 前前次卖的利润减去当前价格
 * buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
 * // 此次买的利润 是 前次卖的利润和此次卖的利润的最大值。
 * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
 */
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int sell[] = new int[prices.length];
        int buy[] = new int[prices.length];

        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sell2 = i - 2 < 0 ? 0 : sell[i - 2];
            buy[i] = Math.max(buy[i - 1], sell2 - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
