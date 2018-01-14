package com.zhaopeng.question.StringQ;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 * Created by zhaopeng on 2018/1/6.
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        // i 和j 是不是回文
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1]);
                if (dp[i][j]) res++;
            }
        }
        return res;
    }

    int count = 0;
    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {

            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return count;
    }

    public void helper(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
        }
    }
}
