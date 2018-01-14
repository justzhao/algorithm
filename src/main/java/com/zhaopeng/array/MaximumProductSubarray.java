package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * <p>
 * 最大的连续子数组的乘积
 * Created by zhaopeng on 2018/1/1.
 */
public class MaximumProductSubarray {


    public static void main(String args[]) {
        MaximumProductSubarray o = new MaximumProductSubarray();

        int a[] = {-2, 3, -4};
        System.out.println(o.maxProduct(a));
    }

    /**
     * 记录当前的最小和最大乘积， 无非因为负数的存在
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max[] = new int[nums.length];
        int min[] = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        int maxProduct = max[0];
        for (int i = 1; i < nums.length; i++) {

            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
            maxProduct = Math.max(max[i], maxProduct);
        }
        return maxProduct;

    }

}
