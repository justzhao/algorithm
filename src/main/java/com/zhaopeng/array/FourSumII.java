package com.zhaopeng.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/description/
 * Created by zhaopeng on 2018/1/21.
 */
public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.get(sum) == null) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -(C[i] + D[j]);
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }
        return res;

    }
}
