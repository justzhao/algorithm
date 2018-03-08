package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * Created by zhaopeng on 2018/1/1.
 */
public class SearchinRotatedSortedArrayII {


    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[start] == nums[end]&&nums[mid]==nums[start]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {

                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else { //nums[start]>nums[mid]
                if (nums[end] >= target && nums[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) return true;
        if (nums[end] == target) return true;
        return false;

    }

}



