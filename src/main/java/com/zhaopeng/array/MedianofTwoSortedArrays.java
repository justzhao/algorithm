package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * 两个排序数组求中位数，中位数，如果是数组长度为奇数则求取 index=len/2的数字，否则是中间两个数字的平均值
 * <p>
 * 思想是使用数组1和数组2 切点
 * nums1    3  5  |8  9                cut1 ： 数组1的切点
 * nums2    1  2  7 |  10  11  12      cut2：数组2的切点
 * <p>
 * Created by zhaopeng on 2018/1/28.
 */
public class MedianofTwoSortedArrays {


    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        // cut1 数组1的切点
        int cut1 = 0;
        // cut2 数组2的切点
        int cut2 = 0;
        // cutL CutR 是binarySearch 的范围
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length) {
            //cut1 是数字1 的切点。cut2 数组2的切点， 要保证， 两份数切了之后，左边的数字的个数等于右边的个数
            // 第一轮肯定是且中点
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            //L1 表示 数组1 cut左边的值
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            // L2 表示数组2 cut左边的值,R1,R2同理
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            // R1 表示数组1 切点右边的值。
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            // R2 表示数组2 切点右边的值
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            // 如果数组1 左边的数字，大于数组2右边的数字， 说明 cut1 要变小，cut2会变大
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {// 如果 数组2左边的数字大于数组1右边的数字，说明cut1要变大，cut2要变小
                cutL = cut1 + 1;
            } else { //L1<=R2, 且 L2<=R1 的情况
                if (len % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                } else {
                    R1 = (R1 < R2) ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }
}
