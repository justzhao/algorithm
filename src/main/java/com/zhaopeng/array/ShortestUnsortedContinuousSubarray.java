package com.zhaopeng.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 * Created by zhaopeng on 2018/1/14.
 * <p>
 * 记录第一个逆序和最后一个逆序
 * <p>      0  1  2  3  4  5   6
 * Input: [2, 6, 4, 8, 10, 9, 15]
 *       [2，4, 6，8, 9，10，15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String args[]) {

        ShortestUnsortedContinuousSubarray o = new ShortestUnsortedContinuousSubarray();
        int a[] = {2, 3, 3, 2, 4};
        System.out.println(o.findUnsortedSubarray(a));
    }

    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        int f = -1, l = 0;
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] || max > nums[i + 1]) {
                if (f == -1) {
                    f = i;
                }
                l = i + 1;
            }
            if (max < nums[i + 1]) {
                maxIndex = i + 1;
                max = nums[i + 1];
            }
        }
        if (f == -1) {
            return 0;
        }
        return Math.max(l - f, l - maxIndex) + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        // 排序后找到首尾最开始出现不一致的索引
        int start = 0;
        while (start < n && nums[start] == temp[start]) {
            start++;
        }
        int end = n - 1;
        while (end > start && nums[end] == temp[end]) {
            end--;
        }

        return end - start + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
