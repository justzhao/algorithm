package com.zhaopeng.array;

import java.util.HashMap;
import java.util.Map;

/** http://blog.csdn.net/zz7549094/article/details/60468908
 *
 * 一个数组分成三份，两个分割点不算进求和中，使得每份的和要相同。如果可以返回true，
 * Created by zhaopeng on 2018/1/1.
 */
public class ThreeSubArraySumK {

    public  boolean canSplitThree(int nums[]){


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
}
