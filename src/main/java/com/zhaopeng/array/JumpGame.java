package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/jump-game/description/
 * Created by zhaopeng on 2017/12/28.
 * <p>
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {


    public static void main(String args[]) {
        JumpGame o = new JumpGame();

        int a[] = {5,4,0,2,0,1,0,1,0};

        System.out.println(o.canJump(a));
    }

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }
        int steps = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0 && i != nums.length - 1) {
                if (steps == 0) {
                    steps = 1;
                }else {
                    steps++;
                }
            } else {
                if (steps != 0) {
                    steps++;
                    if (nums[i] >= steps) {
                        steps = 0;
                    }

                }
            }
        }
        return steps == 0;
    }
}
