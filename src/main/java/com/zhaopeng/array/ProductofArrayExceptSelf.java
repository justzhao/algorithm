package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * Created by zhaopeng on 2018/1/13.
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int res[] = new int[len];
        res[0] = 1;
        //左边乘积
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // 右边乘积
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            // 保存下一轮(i-1)right的乘积
            right = right * nums[i];
        }
        return res;
    }


}
