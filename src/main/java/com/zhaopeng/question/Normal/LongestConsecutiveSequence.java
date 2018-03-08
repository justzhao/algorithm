package com.zhaopeng.question.Normal;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/discuss/
 * Created by zhaopeng on 2017/5/30.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            int down = n - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = n + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }

        return res;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int count[] = new int[nums.length + 1];

        count[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count[i] = count[i - 1] + 1;
            } else if (nums[i] == nums[i - 1]) {
                count[i] = count[i - 1];
            } else {
                count[i] = 1;
            }

            if (max < count[i]) {
                max = count[i];
            }
        }

        return max;
    }

    public static void main(String args[]) {
        LongestConsecutiveSequence s = new LongestConsecutiveSequence();

   /*     int nums[] = new int[6];
        nums[0] = 100;
        nums[1] = 4;
        nums[2] = 200;
        nums[3] = 1;
        nums[4] = 3;
        nums[5] = 2;*/
        int nums[] = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 0;
        nums[3] = 1;

        System.out.println(s.longestConsecutive(nums));
    }
}
