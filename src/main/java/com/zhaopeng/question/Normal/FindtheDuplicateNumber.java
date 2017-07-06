package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/7/6.
 */
public class FindtheDuplicateNumber {
    //https://leetcode.com/problems/find-the-duplicate-number/#/solutions



    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {

            res = res & nums[i];

        }

        return res;


    }

}
