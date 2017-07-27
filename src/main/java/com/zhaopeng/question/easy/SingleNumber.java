package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2017/7/26.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;

        }
        int num = nums[0];


        for (int i = 1; i < nums.length; i++ ){

            num = num ^ nums[i];
        }



        return num;

    }
}
