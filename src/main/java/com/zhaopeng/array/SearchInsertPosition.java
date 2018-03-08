package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 * Created by zhaopeng on 2018/2/20.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        //有可能插入到最后一个
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
