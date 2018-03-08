package com.zhaopeng.digital;

/**
 * https://leetcode.com/problems/ugly-number/description/
 * Created by zhaopeng on 2018/2/14.
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if(num==0){
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }


}
