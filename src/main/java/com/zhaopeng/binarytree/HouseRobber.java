package com.zhaopeng.binarytree;

/**https://leetcode.com/problems/house-robber/
 * Created by zhaopeng on 2018/1/7.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        int takes = 0;
        int ntakes = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //ntakes表示上次没拿钱，这次要拿枪
            takes = ntakes + nums[i];
            //这次反正不拿，取上次最大的值。
            ntakes = max;
            // 本次不拿， 和拿的最大值。
            max = Math.max(takes, ntakes);
        }
        return max;
    }
}
