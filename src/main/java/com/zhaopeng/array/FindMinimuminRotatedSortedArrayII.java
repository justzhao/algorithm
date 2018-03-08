package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 * Created by zhaopeng on 2018/2/17.
 */
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }


        int l = 0, r = nums.length - 1;
        //升序   (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
        int mid = 0;
        while (l < r) {
            //找到 左边小于右边
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            mid = l + (r - l) / 2;

            // 如果中间的数字大于 右边，说明最小值区间一定在[mid+1,r],否则在[l,r]
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }

        return nums[l];

    }
}
