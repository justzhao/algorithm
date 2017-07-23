package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2017/7/23.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[last] = nums[i];
                last++;
            }
        }
        for (int i = last ; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
