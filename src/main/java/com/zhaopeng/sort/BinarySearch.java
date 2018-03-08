package com.zhaopeng.sort;

/**
 * Created by zhaopeng on 2018/1/19.
 */
public class BinarySearch {

    public static void main(String args[]) {
        int a[] = {1,2};
        int t = 2;
        System.out.println(bs(a, t));

        System.out.println(bs1(a, t));

        System.out.println(bs2(a, t));

        System.out.println(binSearch(a, t));

    }

    /**
     * 有bug
     * int a[] = {1,2};
     * int t = 2; 找不到数据
     * 已修复
     *
     * @param nums
     * @param target
     * @return
     */
    public static int bs(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }


    /**
     * bug
     *
     * @param nums
     * @param target
     * @return
     */
    public static int bs1(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
       if(nums[left]==target) return left;
        return -1;
    }


    /**
     * nice
     * @param srcArray
     * @param key
     * @return
     */
    public static int binSearch(int srcArray[], int key) {
        int mid;
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int bs2(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;

        return -1;
    }
}
