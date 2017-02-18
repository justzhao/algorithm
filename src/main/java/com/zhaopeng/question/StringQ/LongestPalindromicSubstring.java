package com.zhaopeng.question.StringQ;

/**
 * 最长回文子串, 奇数和偶数中心扩展法
 * Created by zhaopeng on 2017/2/18.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0 || s.length() == 1) return s;

        int len = s.length();

        int maxlen = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < len; i++) {

            int j = i - 1;
            int l = i + 1;
            while (j >= 0 && l < len) {
                if (s.charAt(j) == s.charAt(l)) {
                    if (l - j > maxlen) {
                        maxlen = l - j;
                        start = j;
                        end = l;
                    }
                } else {
                    break;
                }

                j--;
                l++;
            }
        }

        for (int i = 0; i < len; i++) {

            int j = i;
            int l = i + 1;
            while (j >= 0 && l < len) {
                if (s.charAt(j) == s.charAt(l)) {
                    if (l - j > maxlen) {
                        maxlen = l - j;
                        start = j;
                        end = l;
                    }
                } else {
                    break;
                }

                j--;
                l++;
            }
        }


        return s.substring(start, end + 1);


    }


    public String longestPalindromeByDP(String s) {

        if (s == null || s.length() == 0 || s.length() == 1) return s;

        int len = s.length();
        boolean[][] palind = new boolean[len][len];

        int maxlen = 1;
        int start = 0;
        int end = 0;

        boolean findTwo = false;
        for (int i = 0; i < len; i++) {

            palind[i][i] = true;
            if (i < len - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    palind[i][i + 1] = true;
                    if (!findTwo) {
                        start = i;
                        end = i + 1;
                        findTwo = true;
                    }
                    maxlen = 2;
                }
            }
        }


        for (int i = 3; i <= len; i++) { //长度

            for (int j = 0; j <= len - i; j++) {
                // j是子串开始的地方
                int k = j + i - 1;//串结束

                if (palind[j + 1][k - 1] && s.charAt(j) == s.charAt(k)) {
                    palind[j][k] = true;
                    start = j;
                    end = k;
                    maxlen = len;
                }
            }

        }
        return s.substring(start, end + 1);
    }

    public static void main(String args[]) {

        LongestPalindromicSubstring v = new LongestPalindromicSubstring();
        String s = "ccc";
        System.out.println(v.longestPalindromeByDP(s));
    }
}
