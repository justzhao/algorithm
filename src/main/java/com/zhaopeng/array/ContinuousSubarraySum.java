package com.zhaopeng.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 * Created by zhaopeng on 2018/1/1.
 */
public class ContinuousSubarraySum {


    public static void main(String args[]) {

   /*     int a[] = {23, 2, 4, 6, 7};
        int k = -6;*/
   /*
   [23,2,6,4,7]
0

[1,1000000000]
1
    */
        int a[] = {0,1,0};
        int k = 1;
        ContinuousSubarraySum o = new ContinuousSubarraySum();
        System.out.println(o.checkSubarraySum(a, k));
    }


    /**
     *  o(n)
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;

            //前面已经存在 j 对k取余= runingsum。 说明ij之间一定有k的倍数。
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(-1, 0);

        k = Math.abs(k);
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (k == 0) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    return true;
                }
            }
            if (k != 0) {
                for (int j = -1; j < i; j++) {
                    int sums=map.get(j);
                    if ((temp - sums) % k == 0 && i - j > 1) {
                        return true;
                    }
                }

            }
            map.put(i, temp);

        }
        return false;
    }
}
