package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/description/
 * Created by zhaopeng on 2018/2/3.
 * <p>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class CombinationSumIII {

    public static void main(String args[]) {
        CombinationSumIII o = new CombinationSumIII();
        int k = 3;
        int n = 7;
        List<List<Integer>> res = o.combinationSum3(k, n);
        System.out.println(res);
    }


    /**
     * k 个数字 加起来等于 n；
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {

        //dp.get(i)表示 总和为i 的 小于k的组合
        List<List<List<Integer>>> dp = new ArrayList<>();
        // dp.get(0)的情况。
        dp.add(new ArrayList<List<Integer>>());
        // 和等于i的勤快。
        for (int i = 1; i <= n; i++) {
            //dp.add(i,temp)
            List<List<Integer>> res = new ArrayList<>();
            dp.add(res);

            for (int j = 1; j <= 9; j++) {
                int sum = i - j;
                if (sum < 0) {
                    break;
                }
                List<List<Integer>> lists = dp.get(sum);
                if (lists.isEmpty()) {
                    res.add(Arrays.asList(j));
                    continue;
                }
                //添加的时候要去重
                for (List<Integer> list : lists) {
                    int big = list.get(list.size() - 1);
                    if (big >= j) {
                        continue;
                    }
                    List<Integer> l = new ArrayList<>(list);
                    l.add(j);
                    res.add(l);
                }

            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(List<Integer> temp:dp.get(dp.size()-1)){

            if(temp.size()==k) res.add(temp);
        }
        return res;
    }


    /**
     * backTacking
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3B(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }

/*
   从 1到 k中选出数字的解法。
    public List<List<Integer>> combinationSum3(int k, int n) {

        //dp.get(i)表示 总和为i 的 小于k的组合
        List<List<List<Integer>>> dp = new ArrayList<>();
        // dp.get(0)的情况。
        dp.add(new ArrayList<List<Integer>>());
        // 和等于i的勤快。
        for (int i = 1; i <= n; i++) {
            //dp.add(i,temp)
            List<List<Integer>> res = new ArrayList<>();
            dp.add(res);
            //
            for (int j = 1; j <= k; j++) {
                int sum = i - j;
                if (sum < 0) {
                    break;
                }
                List<List<Integer>> lists = dp.get(sum);
                if (lists.isEmpty()) {
                    res.add(Arrays.asList(j));
                    continue;
                }
                //添加的时候要去重
                for (List<Integer> list : lists) {
                    int big = list.get(list.size() - 1);
                    if(big>=j){
                        continue;
                    }
                    List<Integer> l = new ArrayList<>(list);
                    l.add(j);
                    res.add(l);
                }

            }

        }
        return dp.get(dp.size() - 1);
    }
*/

}
