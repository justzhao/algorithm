package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/6/18.
 */

/**
 * 求取最长回文子序列的长度,不需要连续
 * <p>
 * 建立数组result[len][len]
 * 对于字符串中任意两个位置i,j ,i<=j
 * <p>
 * 如果s.char[i]=s.char[j]  result[i][j]=result[i+1][j-1] +2;
 * 否则  result[i][j]=max(result[i][j-1],result[i+1][j])
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.equals("")) {
            return 1;
        }
        int result[][] = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            // 初始化
            result[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result[i][j] = result[i + 1][j - 1] + 2;
                } else {
                    result[i][j] = Math.max(result[i][j - 1], result[i + 1][j]);
                }
            }
        }
        return result[0][s.length() - 1];
    }


    public static void main(String args[]) {
        //bbbab

        LongestPalindromicSubsequence s = new LongestPalindromicSubsequence();
        String a = "bbbab";
        System.out.println(s.longestPalindromeSubseq(a));
    }

}
