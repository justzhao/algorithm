package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/8/10.
 */

//https://leetcode.com/problems/single-number-ii/description/
public class SingleNumberII {


    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 32 个bit表示一个整数
        int sum[] = new int[32];

        int res = 0;

        // 每个数字二进制表示 都加起来
        for (int i = 0; i < 32; i++) {

            for (int j = 0; j < nums.length; j++) {

                // i表示 二进制表示法 第i位
                sum[i] = sum[i] + ((nums[j] >> i) & 1);
            }
        }

        //  如果能被数字3正除，
        for (int i = 0; i < 32; i++) {
            res = res | ((sum[i] % 3) << i);
        }


        return res;

    }
}

