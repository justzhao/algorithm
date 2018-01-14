package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Created by zhaopeng on 2018/1/2.
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int res = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {

            res=Math.max(res,prices[i]-min);

            min=Math.min(min,prices[i]);

        }
        return res;
    }


}
