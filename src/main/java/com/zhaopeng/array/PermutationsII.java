package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/description/
 * Created by zhaopeng on 2017/12/28.
 * <p>
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * [[1, 1, 2], [1, 2, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 1, 1]]

 */
public class PermutationsII {
    public static void main(String args[]) {
        PermutationsII o = new PermutationsII();
        int a[] = {1, 1, 2};
        System.out.println(o.permuteUnique(a));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    public void helper(List<List<Integer>> res, int nums[], List<Integer> temp, boolean used[]) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            //是否可以用当前的数字
            //如果当前当数字已经用过了，或者和前面的数字相等，且前面的数字没有用过，
            boolean a = used[i];
            boolean b = i > 0 && (nums[i] == nums[i - 1] && !used[i - 1]); //因为回溯的原因，前面的数字已经用过了，然后弹出，user[i-1]=false
            if (a||b ) { //||
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            helper(res, nums, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }

    }

}
