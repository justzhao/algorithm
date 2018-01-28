package com.zhaopeng.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhaopeng on 2018/1/21.
 * <p>
 * 所有的相交的数字，可重复
 * <p>
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?  bs
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionofTwoArraysII {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        // 计算每个数字出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        for (int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                ret.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int res[] = new int[ret.size()];
        int k = 0;
        for (int n : ret) {
            res[k++] = n;
        }
        return res;

    }


}
