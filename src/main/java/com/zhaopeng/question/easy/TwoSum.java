package com.zhaopeng.question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组和一个数字B，找出数组中的所有的两个数之和等于B的索引。
 * 数组中所有的数字不会有重复
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * Created by zhaopeng on 2017/5/14.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int a = nums[i];

            int diff = target - a;
            if (map.containsKey(diff)) {
                int index = map.get(diff);

                result[0] = index;
                result[1] = i;

            }
            map.put(a, i);
        }

        return result;
    }


}
