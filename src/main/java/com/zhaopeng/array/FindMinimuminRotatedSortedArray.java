package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * Created by zhaopeng on 2017/12/31.
 */
public class FindMinimuminRotatedSortedArray {

    public static void main(String args[]) {
        int a[] = {1, 2, 3};

        FindMinimuminRotatedSortedArray o = new FindMinimuminRotatedSortedArray();

        System.out.println(o.findMin(a));
    }

    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;
        //升序   (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
        int mid = 0;
        while (l != r) {
                //找到 左边小于右边
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            mid = (l + r) / 2;

            // 如果中间的数字大于 右边，说明最小值区间一定在[mid+1,r],否则在[l,r]
            if (nums[mid] >= nums[r]) {
                l = mid + 1;
            } else if (nums[mid] <= nums[r]) {
                r = mid;
            }
        }

        return nums[l];
    }

}
