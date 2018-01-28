package com.zhaopeng.question.StringQ;

/**
 * https://leetcode.com/problems/wildcard-matching/description/
 * * 可以匹配连续的字符串，不能代表0个
 * Created by zhaopeng on 2018/1/16.
 */
public class WildcardMatching {

    public static void main(String args[]) {
        WildcardMatching o = new WildcardMatching();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(o.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        /**
         * dp[i][j]代表 长度为i的s 是否匹配长度为j的p
         */
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //当s的长度为0的时候，对于j做如下遍历
        for (int i = 1; i <= p.length(); i++) {
            // i-1表示当前字符，如果当前字符为 *
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[0][i] = true;
        }

        // 以长度为基准遍历  isMatch("aab", "c*a*b") → false
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //如果当前两个字符相等，则以前面的为基准
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 如果p的当前字符为 *, 任意匹配符
                } else if (p.charAt(j - 1) == '*') {
                    //* 可以匹配前面任意的字符串。 长度 ｉ和长度　j-1 可以匹配， 长度i-1和长度j 匹配。
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
