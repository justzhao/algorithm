package com.zhaopeng.question;

/**
 * https://leetcode.com/problems/largest-palindrome-product/description/
 * Created by zhaopeng on 2017/12/29.
 *

 n = 2
 upperBound = 99 -> generate max number (99 * 99) -> found potential max palindrom
 lowerBound = 10
 99 * 99 = 9801 -> 9889

 */

public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1, min = max / 10 + 1;
        long maxNumber = (long) max * (long) min;
        int half = (int) (maxNumber / (long) Math.pow(10, n));
        boolean found = false;
        long palindrome = 0;
        while (!found) {
            palindrome = create(half);
            for (long i = max; i >= min; i--) {
                if (i * i < palindrome) {
                    break;
                }
                if (palindrome % i == 0) {
                    found = true;
                    break;
                }
            }
            half--;
        }
        return (int) palindrome % 1337;
    }

    public long create(int n) {
        String str=String.valueOf(n) + new StringBuilder().append(n).reverse().toString();
        return Long.parseLong(str);
    }



}
