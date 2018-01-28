package com.zhaopeng.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 给两个数组，找出相交的数字，可不重复
 * Created by zhaopeng on 2018/1/21.
 */
public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int n : nums1) {
            if (bs(nums2, n)) {
                set.add(n);
            }
        }
        int res[] = new int[set.size()];
        int k = 0;
        for (int n : set) {
            res[k++] = n;
        }
        return res;
    }

    public boolean bs(int nums[], int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target || nums[right] == target;
    }

    /**
     *  o（n）
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> ret=new HashSet<>();
        for(int n:nums1){
            set.add(n);
        }
        for(int n:nums2){
            if(set.contains(n)){
                ret.add(n);
            }
        }
        int res[] = new int[ret.size()];
        int k = 0;
        for (int n : ret) {
            res[k++] = n;
        }
        return res;

    }
}
