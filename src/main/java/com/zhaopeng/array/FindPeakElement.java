package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/find-peak-element/description/
 * Created by zhaopeng on 2018/1/21.
 * <p>
 * <p>
 * [1, 2, 3, 1]
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        // 为什么有left+1 ，因为下面有mid+1
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] > nums[right] ? left : right;
    }

}
