package com.zhaopeng.question.Normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaopeng on 2017/6/4.
 */

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedinanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            /**
             *  因为元素a[i]不会大于n。
             *  所以索引 index= a[i]-1。 a[index] 可以用来表示 数字i+1 是否存在
             *
             */
            int val = Math.abs(nums[i]) - 1;
            //  int val=nums[i]-1;

            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
