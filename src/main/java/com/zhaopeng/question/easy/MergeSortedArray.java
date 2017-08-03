package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2017/8/4.
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {

    /**
     * @param nums1
     * @param m     nums1此数组有多少个被初始化的元素
     * @param nums2
     * @param n     nums2此数组有多少个被初始化的元素
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m + n - 1;
        // 更新索引
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
        while (n >= 0) {
            nums1[i] = nums2[n];
            i--;
            n--;
        }

    }

}
