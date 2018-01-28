package com.zhaopeng.question.StringQ;

/**
 * https://leetcode.com/problems/regular-expression-matching/description/
 * <p>
 * 正则匹配。第一个参数正则匹配第二个参数
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * Created by zhaopeng on 2018/1/15.
 */

/**
 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
 * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
 * 3, If p.charAt(j) == '*':
 * here are two sub conditions:
 * 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
 * 2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
 * dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
 * or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
 * or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
 */
public class RegularExpressionMatching {


    /**
     * s 是否能正则匹配 p
     *
     * @param s
     * @param p
     * @return
     */
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
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        // 以长度为基准遍历
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //如果当前两个字符相等，则以前面的为基准
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 如果p的当前字符为 *, 任意匹配符
                } else if (p.charAt(j - 1) == '*') {
                     // 如果当前p字符前面的字符不等于当前 s的字符，则以前面的为基准
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        // 如果当前p字符前面的字符等于当前s的字符，或者 当前p字符前面的字符为万能字符
                        // 那么dp[i][j] 有可能的值为，如下:
                        //dp[i][j-2]表示， * 代表0个任意字符的情况 比如ba* 可以表示 b
                        //dp[i][j-1] 表示  * 代表一个任意字符的情况 比如 ba* 可以表示 ba
                        //dp[i-1][j] 表示  * 代表多个任意字符的情况 比如 ba* 可以表示baaaaaaaaaa (baa  和 ba*)
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
