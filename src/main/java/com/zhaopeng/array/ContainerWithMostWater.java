package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * <p>
 * 一堆线条，用来盛水，看 哪两个线的面积最大
 * <p>
 * Created by zhaopeng on 2018/1/13.
 */
public class ContainerWithMostWater {

    /**
     * 两端点解法。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) {
            return res;
        }
        int l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[r], height[l]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
