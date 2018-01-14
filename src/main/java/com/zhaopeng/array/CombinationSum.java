package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaopeng on 2017/12/23.
 * https://leetcode.com/problems/combination-sum/description/
 * https://leetcode.com/problems/combination-sum/discuss/
 */
public class CombinationSum {

    public static void main(String args[]) {
        CombinationSum o = new CombinationSum();
        int nums[] = {2, 3, 6, 7};
        int target = 7;
        System.out.println(o.combinationSum(nums, target));
        System.out.println(o.combinationSum1v(nums, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        // 从i 到target 依次遍历
        for (int i = 1; i <= target; i++) {
            if (i == 7) {
                System.out.println();
            }
            //用来存放 和为 i的list
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // 遍历这个数组
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                // 相等的情况下
                if (i == candidates[j]) {
                    newList.add(Arrays.asList(candidates[j]));
                } else {
                    // 从DP中获取i-i - candidates[j]轮的结果
                    List<List<Integer>> temp = dp.get(i - candidates[j] - 1);
                    for (List<Integer> l : temp) {
                        int c = candidates[j];
                        // 如果不小于第一个数，会出现重复的，为什么
                        int ll = l.get(0);
                        if (c <= ll) {
                            List cl = new ArrayList<>();
                            cl.add(c);
                            cl.addAll(l);
                            newList.add(cl);
                        }
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(target - 1);
    }


    /**
     * 递归
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1v(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        comb(res, target, candidates, new ArrayList<Integer>(), 0);
        return res;
    }

    public void comb(List<List<Integer>> res, int target, int candidates[], List<Integer> tempList, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = index; i < candidates.length ; i++) {
            tempList.add(candidates[i]);
            comb(res, target - candidates[i], candidates, tempList, i);//可以继续选同样的数字。
            tempList.remove(tempList.size() - 1);
        }
    }

}
