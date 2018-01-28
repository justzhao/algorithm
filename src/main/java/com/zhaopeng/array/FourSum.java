package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/description/
 * Created by zhaopeng on 2018/1/21.
 */
public class FourSum {

    public static void main(String args[]) {
        FourSum s = new FourSum();
        int a[] = {1, 0, -1, 0, -2, 2};

        int target = 0;
        System.out.println(s.fourSum(a, target));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;

                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }

        }

        return res;
    }

    /**
     * backtracking tle了。
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, res, target, new ArrayList<Integer>());
        return res;
    }

    public void helper(int index, int nums[], List<List<Integer>> res, int target, List<Integer> temp) {
        if (index > nums.length) {
            return;
        }
        if (temp.size() == 4 && target != 0) {
            return;
        }
        if (temp.size() == 4 && target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(i + 1, nums, res, target - nums[i], temp);
            temp.remove(temp.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

        }

    }
}
