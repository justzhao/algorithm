package com.zhaopeng.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Created by zhaopeng on 2017/12/31.
 */
public class SubarraySumEqualsK {

    public static void main(String args[]) {
        SubarraySumEqualsK o = new SubarraySumEqualsK();

        int nums[] = {1, 1, 1};
        int k = 2;
        System.out.println(o.subarraySum(nums, k));
    }


    public int subarraySum(int[] nums, int k) {

        int count = 0, sum = 0;
        //sum-> count .结果为sum的数组有count个。
        Map<Integer, Integer> map = new HashMap<>();
        //初始化 sum=0，count=1
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // sum-k 表示，前面已经存在sum-k的数组，。现在结果已经相加等于 sum. 所以到i 位置，一定会有和=k的子数组。
            //快速的查找sum-k是否存在，即是否有连续子数组的和为sum-k，如果存在的话，那么和为k的子数组一定也存在
            // 和为 sum-k 的子序列有 n种，那么， 和为k的子序列也有k种。多体会下。
            if (map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        return count;
    }


    //暴力解法
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
