package com.zhaopeng.question.easy;

/**
 * https://leetcode.com/problems/missing-number/#/description
 * Created by zhaopeng on 2017/7/20.
 */
public class MissingNumber {


    public int missingNumber(int[] nums) {
        int sumArray = 0;
        for (int n : nums) {
            sumArray += n;
        }
        // 为什么+1。因为第一位从0开始。所以长度要加1
        int n = nums.length + 1;
        int sum = (n * (n - 1)) / 2;
        return sum - sumArray;
    }

}





