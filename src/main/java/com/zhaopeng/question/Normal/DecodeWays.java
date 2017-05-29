package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/5/29.
 */
public class DecodeWays {
    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        //长度为i的字符串由sum[i]解码方法
        int n = s.length() + 1;
        int sum[] = new int[s.length() + 1];
        // 空字符1 种解码方法
        sum[0] = 1;
        // 长度为1的字符串1中解码方法
        if (s.charAt(0) == '0') {
            sum[1] = 0;
        } else {
            sum[1] = 1;
        }
            for (int i = 2; i < n; i++) {

                int a = Integer.valueOf(s.substring(i - 1, i));
                int b = Integer.valueOf(s.substring(i - 2, i));
                if (a >= 1 && a <= 9) {
                    sum[i] += sum[i - 1];
                }
                if (b >= 10 && b <= 26) {
                    sum[i] += sum[i - 2];
                }
            }


            return sum[n - 1];
        }


    public static void main(String args[]) {
        DecodeWays d = new DecodeWays();
        String a = "12";
        System.out.println(d.numDecodings(a));
    }
}
