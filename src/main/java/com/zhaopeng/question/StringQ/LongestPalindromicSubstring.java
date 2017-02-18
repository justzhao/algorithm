package com.zhaopeng.question.StringQ;

/**
 * 最长回文子串
 * Created by zhaopeng on 2017/2/18.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) return s;

        int len = s.length();
        /**
         *  二维数组 中的 sum[i][j]
         *  =1 是回文，
         *  =0， 未知，
         *  =-1 不是回文
         */

        int sum[][] = new int[len][len];
        // 两组坐标点

        for (int i = 0; i < len; i++) {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            // 横纵坐标 加起来等于当前所在的索引
            // 记录当前是否第一次遍历此斜行
            boolean isStart = true;
            if (i % 2 == 0) {
                //偶数位置
                x1 = x2 = i / 2;
                y1 = y2 = i - x1;
            } else {
                // 奇数位置
                x1 = y2 = i / 2;
                y1 = i - x1;
                x2 = i - y2;
            }
            while (x1 >= 0 && y1 < len && x2 < len && y2 >= 0) {
                char a = s.charAt(x1);
                char b = s.charAt(x2);
                if (isStart) {

                    if (a == b) {
                        sum[x1][y1] = 1;
                        sum[x2][y2] = 1;
                    } else {

                        sum[x1][y1] = -1;
                        sum[x2][y2] = -1;

                    }
                } else {
                    // 查看上一次是否为 回文的
                    int a1 = x1 + 1;
                    int b1 = y1 - 1;
                    int a2 = x2 - 1;
                    int b2 = y2 + 1;
                    if (sum[a1][b1] != 1 && sum[a2][b2] != 1) {
                        sum[x1][y1] = -1;
                        sum[x2][y2] = -1;
                    } else {
                        if (a == b) {
                            sum[x1][y1] = 1;
                            sum[x2][y2] = 1;
                        } else {
                            sum[x1][y1] = -1;
                            sum[x2][y2] = -1;
                        }
                    }

                }
                isStart = false;
                x1--;
                y1++;
                x2++;
                y2--;
            }
        }


        for (int i = len - 1; i >= 0; i--) {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            // 横纵坐标 加起来等于当前所在的索引
            // 记录当前是否第一次遍历此斜行
            boolean isStart = true;
            if (i % 2 == 0) {
                //偶数位置
                x1 = x2 = (i + len - 1) / 2;
                y1 = y2 = (i + len - 1) - x1;
            } else {
                // 奇数位置
                x1 = y2 = (i + len - 1) / 2;
                y1 = (i + len - 1) - x1;
                x2 = (i + len - 1) - y2;
            }
            while (x1 > 0 && y1 < len && x2 < len && y2 > 0) {
                char a = s.charAt(x1);
                char b = s.charAt(x2);
                if (isStart) {

                    if (a == b) {
                        sum[x1][y1] = 1;
                        sum[x2][y2] = 1;
                    } else {

                        sum[x1][y1] = -1;
                        sum[x2][y2] = -1;

                    }
                } else {
                    // 查看上一次是否为 回文的
                    int a1 = x1 + 1;
                    int b1 = y1 - 1;
                    int a2 = x2 - 1;
                    int b2 = y2 + 1;
                    if (sum[a1][b1] != 1 && sum[a2][b2] != 1) {
                        sum[x1][y1] = -1;
                        sum[x2][y2] = -1;
                    } else {
                        if (a == b) {
                            sum[x1][y1] = 1;
                            sum[x2][y2] = 1;
                        } else {
                            sum[x1][y1] = -1;
                            sum[x2][y2] = -1;
                        }
                    }

                }
                isStart = false;
                x1--;
                y1++;
                x2++;
                y2--;
            }
        }

        /**
         * 遍历索引结果
         */
        int max = -1, maxi = -1, maxj = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {

                if (sum[i][j] == 1) {

                    if (j - i > max) {
                        maxi = i;
                        maxj = j;
                        max = j - i;
                    }
                }
            }
        }

        System.out.println("res is "+maxi+" :　"+maxj);
        return s.substring(maxi, maxj + 1);

    }

    public static void main(String args[]) {

        LongestPalindromicSubstring v = new LongestPalindromicSubstring();
        String s = "2424sknksofdgsdg";
        System.out.println(v.longestPalindrome(s));
    }
}
