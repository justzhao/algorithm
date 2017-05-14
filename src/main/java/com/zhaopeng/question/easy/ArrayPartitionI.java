package com.zhaopeng.question.easy;

import java.util.Arrays;

/**
 * Created by zhaopeng on 2017/5/14.
 * <p>
 * 给定一个偶数的数组，大小为2n
 * 从这个数组中获取数据分组 (a1, b1), (a2, b2), ..., (an, bn)。
 * n 一定大于1
 * <p>
 * 取每一对数据中(ai,bi)的最小值 mi ， 使所有的mi之和最大。
 * https://leetcode.com/problems/array-partition-i/#/description
 *
 *  排序之后，两两分成一组，这样取小的数，然后相加就可以得到结果
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int result = 0;

        Arrays.sort(nums);

        result += nums[0];
        for (int i = 2; i < nums.length; i = i + 2) {

            result += nums[i];
        }

        return result;

    }
}
