package com.zhaopeng.question.Normal;

/**
 * 判断一个数字是不是回文数字
 * Created by zhaopeng on 2017/6/17.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        int p = x;

        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int sum = 0;
        while (x > 0) {

            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return sum == p;
    }

}


