package com.zhaopeng.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Created by zhaopeng on 2018/2/22.
 */
public class LongestPalindromicSubstring {


    public String longestPalindrome1(String s) {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        // 两个索引 一个向前，一个向后
        // 为什么从后面开始
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    public static void main(String args[]){

        LongestPalindromicSubstring o=new LongestPalindromicSubstring();

        String s="babad";

        System.out.println(o.longestPalindrome1(s));

    }

    /**
     * 我写的
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return s;
        }
        boolean dp[][] = new boolean[s.length()][s.length()];
        String res = "";
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
