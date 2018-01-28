package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * Created by zhaopeng on 2018/1/22.
 */
public class IncreasingTripletSubsequence {

    public static void main(String args[]) {
        IncreasingTripletSubsequence o = new IncreasingTripletSubsequence();
        int nums[] = {1, 1, -2, 6};
        System.out.println(o.increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secmin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > min && nums[i] < secmin) {
                secmin = nums[i];
            } else if (nums[i] > secmin) {
                return true;
            }

        }
        return false;
    }
}
