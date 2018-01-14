package com.zhaopeng.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * Created by zhaopeng on 2017/12/23.
 */
public class PartitiontoKEqualSumSubsets {



    public static void main(String args[]) {
        PartitiontoKEqualSumSubsets s = new PartitiontoKEqualSumSubsets();


        int nums[] = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(s.canPartitionKSubsets(nums, k));
    }

    /** 1, 2,2,3,3,4,5  k=4;   target=5
     *
     *  1,2,2,3,3,4 k=3 target=5
     *
     *
     * @param nums
     * @param k
     * @return
     */

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k == 1) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int index = nums.length - 1;

        if (nums[index] > target) {
            return false;
        }
        while (index >= 0 && nums[index] == target) {
            k--;
            index--;
        }
        return partition(new int[k], nums, index, target);
    }


    /**
     *  针对每个数字 nums[index ] 依次放入 set[i] 数组里面去
     * @param sets
     * @param nums
     * @param index
     * @param target
     * @return
     */
    public boolean partition(int sets[], int nums[], int index, int target) {

        // 数组已经排序，从后面向前面遍历。
        if (index < 0) {
            //为什么index <0,当所有的数字遍历结束，就能返回true
            return true;
        }
        // 拿出一个数字，尝试放到每一个组里面
        int s = nums[index];
        for (int i = 0; i < sets.length; i++) {
            if (sets[i] + s <= target) {
                sets[i] += s;
                // 继续放入下一个数字
                if (partition(sets, nums, index - 1, target)) {
                    return true;
                }
                sets[i] -= s;
            }
        }

        return false;
    }


}
