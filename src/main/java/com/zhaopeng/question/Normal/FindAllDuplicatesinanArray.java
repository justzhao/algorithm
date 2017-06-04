package com.zhaopeng.question.Normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaopeng on 2017/6/4.
 */
public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 1) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                res.add(nums[i]);
            }
        }

        return res;
    }
}
