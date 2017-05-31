package com.zhaopeng.question.Normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaopeng on 2017/5/31.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 排序后 遍历查找
            int l = i + 1, h = nums.length - 1;
            // 减去其中一个数字
            int target = 0 - nums[i];
            while (l < h) {
                if (nums[l] + nums[h] == target) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    l++;
                    h--;
                    while (l < h && nums[l] == nums[l - 1]) l++;
                    while (l < h && nums[h] == nums[h + 1]) h--;
                    //
                } else if (nums[l] + nums[h] > target) {
                    h--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
