package com.zhaopeng.question.Normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaopeng on 2017/7/2.
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * http://www.cnblogs.com/Dylan-Java-NYC/p/4841951.html
 */


public class Combinations {

    /**
     * C(n,k)=C(n-1,k-1)+C(n-1,k).
     * <p>
     * 当 n=k 或者k=0的时候  C(n,k)=1
     */


    public List<List<Integer>> combine(int n, int k) {

        if (n <= k || k == 0) {

            List<Integer> comb = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                comb.add(i);
            }

            return new ArrayList<>(Arrays.asList(comb));

        }
        //get  C(n-1,k-1)
        List<List<Integer>> result = this.combine(n - 1, k - 1);

        //这里为什么要加这个
        /**
         *  因为求的是具体的组合， combine(n - 1, k - 1) 所求的是k-1 个 数字组合。  ，所以对于每个组合要加上n
         */
        for (List<Integer> item : result) {
            item.add(n);
        }

        //get C(n-1,k)
        result.addAll(combine(n - 1, k));

        return result;
    }
}
