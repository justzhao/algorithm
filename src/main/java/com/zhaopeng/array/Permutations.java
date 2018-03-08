package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.youtube.com/watch?v=TarT5kllaWs
 * https://leetcode.com/problems/permutations/description/
 * Created by zhaopeng on 2017/12/27.
 */
public class Permutations {

    public static void main(String args[]){
        int a[]={1,2,3};
        Permutations o=new Permutations();

        System.out.println(o.permute(a));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        helper(res, nums, 0);
      //  helper(res, new ArrayList<Integer>(), nums);
        return res;
    }

    //回溯法

    /**
     * I’m sure somewhere can be simplified so it’d be nice if anyone can let me know. The pattern was that:

     say n = 4, you have {1, 2, 3, 4}

     If you were to list out all the permutations you have

     1 + (permutations of 2, 3, 4)

     2 + (permutations of 1, 3, 4)

     3 + (permutations of 1, 2, 4)

     4 + (permutations of 1, 2, 3
     * @param res
     * @param temp
     * @param nums
     */
    public void helper(List<List<Integer>> res, List<Integer> temp, int nums[]) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        // 不断的取每个元素，已经取过的 就continue
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            helper(res, temp, nums);
            temp.remove(temp.size()-1);
        }

    }

     // 交换法，
    public void helper(List<List<Integer>> res, int[] nums, int index) {
        // 递归的层数。
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) {
                temp.add(n);
            }
            res.add(temp);
        }
        // 每个数字和后面的数字交换，
        for (int i = index; i < nums.length; i++) {
            // i 分别和i+1,i+2 交换。
            swap(nums, index, i);
            //i和 i+1 i+2交换之后，从 index+1开始。
            helper(res, nums, index + 1);
            swap(nums, index, i);


        }
    }

    void swap(int nums[], int l, int k) {

        int t = nums[l];
        nums[l] = nums[k];
        nums[k] = t;

    }

}
