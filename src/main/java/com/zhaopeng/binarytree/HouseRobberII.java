package com.zhaopeng.binarytree;

/**
 * https://leetcode.com/problems/house-robber-ii/description/
 * Created by zhaopeng on 2018/1/7.
 */
public class HouseRobberII {


    /**
     * 区分在于第一个房子抢或者步枪
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        //第一个房间不抢
        int take_nf[] = new int[n];
        // 房子不抢的利润和第一个房子不抢
        int ntake_nf[] = new int[n];
        //第1个房间抢
        int take_f[] = new int[n];
        // 房子不抢的利润
        int ntake_f[] = new int[n];
        //第一个房子固定
        take_f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //第一个房子不抢，本轮房子抢,上轮房子只能不抢
            take_nf[i] = nums[i] + ntake_nf[i - 1];
            //第一个房子不抢，本轮房子不抢, 等于上轮房子抢和不抢的最大值
            ntake_nf[i] = Math.max(ntake_nf[i - 1], take_nf[i - 1]);

            //第一个房子抢，本轮房子抢， 只能上轮房子不抢+本轮价值
            take_f[i] = nums[i] + ntake_f[i - 1];
            //第一个房子抢，本轮房子不抢。等于上轮房子抢或者不抢的最大值
            ntake_f[i] = Math.max(ntake_f[i - 1], take_f[i - 1]);
        }
        //需要过滤掉，对于take_f 。不可能最后一个房子和第一个房子都抢，所以要过滤掉。
        //对于 ntake_nf 一定会小于等于ntake_f
        return Math.max(take_nf[n - 1], ntake_f[n - 1]);
    }
}
