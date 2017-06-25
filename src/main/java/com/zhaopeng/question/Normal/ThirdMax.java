package com.zhaopeng.question.Normal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaopeng on 2017/6/25.
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {

        if (nums == null) {
            return 0;

        }

        Arrays.sort(nums);
        Set<Integer> sets = new HashSet<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int a = nums[i];
            if (!sets.contains(a)) {
                sets.add(a);
                if (sets.size() == 3) {
                    return a;
                }
            }

        }

        return nums[nums.length - 1];
    }

    public static void main(String args[]) {

        ThirdMax s = new ThirdMax();

        int nums[] = {3, 2, 1};

        System.out.println(s.thirdMax(nums));

    }
}
