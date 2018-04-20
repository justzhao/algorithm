package com.zhaopeng.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * http://blog.csdn.net/zz7549094/article/details/60468908
 * <p>
 * 一个数组分成三份，两个分割点不算进求和中，使得每份的和要相同。如果可以返回true，
 * Created by zhaopeng on 2018/1/1.
 */
public class ThreeSubArraySumK {

    public boolean canSplitThree(int nums[]) {
        int[] sums = new int[nums.length];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int tmp = 0;
        //map 记录 0到i相加 和为sum。
        for (int i = 0; i < nums.length; ++i) {
            tmp += nums[i];
            sums[i] = tmp;
            hashMap.put(tmp, i);
        }
        for (int pos1 = 1; pos1 < nums.length; ++pos1) {
            int sum = sums[pos1] - nums[pos1];
            if (hashMap.containsKey(sum + sums[pos1])) {
                int pos2 = hashMap.get(sum + sums[pos1]) + 1;
                if (pos2 < nums.length && sums[sums.length - 1] - sums[pos2] == sum) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Input: [1,2,1,2,1,2,1]
     * Output: True
     * Explanation:
     * i = 1, j = 3, k = 5.
     * sum(0, i - 1) = sum(0, 0) = 1
     * sum(i + 1, j - 1) = sum(2, 2) = 1
     * sum(j + 1, k - 1) = sum(4, 4) = 1
     * sum(k + 1, n - 1) = sum(6, 6) = 1
     *
     * @param nums
     * @return
     */
    public boolean canSplitFour(int nums[]) {
        if (nums == null || nums.length < 7) {
            return false;
        }

        int[] sums = new int[nums.length];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int tmp = 0;
        //map 记录 0到i相加 和为sum。
        for (int i = 0; i < nums.length; ++i) {
            tmp += nums[i];
            sums[i] = tmp;
            hashMap.put(tmp, i);
        }
        // for j - middle cut
        for (int j = 3; j < nums.length - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            // for i - left cut
            for (int i = 1; i < j - 1; i++) {
                int sum1 = sums[i - 1];
                int sum2 = sums[j - 1] - sums[i];
                if (sum1 == sum2)
                    set.add(sum1); // add potential answers into set
            }
            // for k - right cut
            for (int k = j + 2; k < nums.length - 1; k++) {
                int sum3 = sums[k - 1] - sums[j];
                int sum4 = sums[nums.length - 1] - sums[k];
                if (sum3 == sum4 && set.contains(sum3)) //
                    return true;
            }

        }
        return false;
    }


    public boolean canSplitFour1(int nums[]) {
        if (nums == null || nums.length < 7) {
            return false;
        }
        int[] sums = new int[nums.length];
        int tmp = 0;
        //map 记录 0到i相加 和为sum。
        for (int i = 0; i < nums.length; ++i) {
            tmp += nums[i];
            sums[i] = tmp;
        }

        //第二个切点
        for (int j = 3; j < nums.length - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            //第一个切点
            for (int i = 1; i < j - 1; i++) {
                int sum1 = nums[i - 1];
                int sum2 = nums[j - 1] - nums[i];
                if (sum1 == sum2) {
                    set.add(sum1);
                }
            }

            //第三个切点
            for (int k = j + 2; k < nums.length - 1; k++) {
                int sum3 = sums[k - 1] - sums[j];
                int sum4 = sums[nums.length - 1] - sums[k];
                if (sum3 == sum4 && set.contains(sum3)) {
                    return true;
                }
            }

        }

        return false;
    }
}
