package com.zhaopeng.question.StringQ;

/**
 * 1.最优子结构
 * 2. 重复子问题
 * https://leetcode.com/problems/edit-distance/description/
 * https://www.youtube.com/watch?v=tNHftNybJ_o
 * Created by zhaopeng on 2018/1/15.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        //dp[i][j] 表示长度为i 变化为长度为j的字符需要的最小步数
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //一次替换操作
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                //当前 ij的最小操作，
                // 可能是
                // dp[i - 1][j]（长度(i-1)到长度j的步数）+ remove 字符i 。
                // dp[i][j - 1]（长度i到长度 j-1的步数）  + insert个字符
                // 最小值

                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
