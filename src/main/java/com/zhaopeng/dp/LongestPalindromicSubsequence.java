package com.zhaopeng.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * Created by zhaopeng on 2018/2/22.
 */
public class LongestPalindromicSubsequence {


    public static void main(String args[]) {

        LongestPalindromicSubsequence o = new LongestPalindromicSubsequence();
        //String s = "cbbd";
        String s = "aabaaba";
        System.out.println(o.longestPalindromeSubseq(s));
        System.out.println(o.longestPalindromeSubseq1(s));
    }

    /**
     * if (s == null || s.length() <= 1) {
     * return 1;
     * }
     * //res i ,j 表示在字符串s中， i到j的位置 子字符串的回文的长度
     * int res[][] = new int[s.length()][s.length()];
     * for(int i=0;i<s.length();i++){
     * res[i][i]=1;
     * }
     * for (int i = 0; i < s.length(); i++) {
     * <p>
     * for (int j = i; j < s.length(); j++) {
     * if (s.charAt(i) == s.charAt(j)) {
     * res[i][j] = res[i + 1][j - 1]+2;
     * }else {
     * res[i][j]=Math.max(res[i][j-1],res[i+1][j]);
     * }
     * }
     * }
     * return res[0][s.length() - 1];
     * <p>
     * 这个解法显然是错误滴，为什么？因为动态规划，你需要计算子问题的结果，才能得到后面的结果，上述问题，没有先计算子问题，res[i][j] 首先在j定住的情况下计算所有的结果
     *
     * 下面这个ac了 我写的
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() <= 1) {
            return 1;
        }
        //res i ,j 表示在字符串s中， i到j的位置 子字符串的回文的长度
        int res[][] = new int[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
               //为什么是从后往前？因为 i j  要用到 i+1,j-1
            for (int i = j; i >=0 ; i--) {
                if (i == j) {
                    res[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                  /*  if (j - i == 2) {
                        res[i][j] = 3;
                    }else if(j-i==1){
                        res[i][j]=2;
                    } else {
                        res[i][j] = res[i + 1][j - 1] + 2;
                    }*/
                    res[i][j] = res[i + 1][j - 1] + 2;
                } else {
                    res[i][j] = Math.max(res[i][j - 1], Math.max(res[i + 1][j], res[i + 1][j - 1]));
                }
            }
        }
        return res[0][s.length() - 1];

    }


    /**
     * 中间向两边扩散
     * @param s
     * @return
     */
    public int longestPalindromeSubseq1(String s) {

        if (s == null || s.equals("")) {
            return 1;
        }
        //result[i][j] 表示从i到j最长的回文序列
        int result[][] = new int[s.length()][s.length()];

        // 4,3,2,1
        for (int i = s.length() - 1; i >= 0; i--) {
            // 初始化
            result[i][i] = 1;
            // 2,3,4
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
}
