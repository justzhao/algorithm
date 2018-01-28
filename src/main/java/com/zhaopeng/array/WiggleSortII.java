package com.zhaopeng.array;

import java.util.Arrays;

/**
 * Created by zhaopeng on 2018/1/26.
 */

/**
 * 排序找中位数
 * 大于中位数， 左右，奇
 * <p>
 * 小于中位数  右 左  偶
 * <p>
 * time o(nlogn)
 * space o(n)
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null | nums.length < 3) {
            return;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int mid = (n - 1) / 2;
        int index = 0;
        int temp[] = new int[n];
        //0 到mid
        for (int i = 0; i <= mid; i++) {
            // 小于中位数的数字,从右往左 赋给值偶数项
            temp[index] = nums[mid - 1];
            if (index + 1 < n) {
                //大于中位数的数组,从左往右，赋值奇数项
                temp[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);

    }
}
