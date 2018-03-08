package com.zhaopeng.array;

/**http://www.cnblogs.com/boring09/p/4248482.html
 * https://leetcode.com/problems/gas-station/description/
 * Created by zhaopeng on 2018/2/1.
 * 求最大连续和做
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        int start = 0;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (sum < 0) {
                sum = (gas[i] - cost[i]);
                start = i;
            } else {
                sum += (gas[i] - cost[i]);
            }
        }
        return total < 0 ? -1 : start;
    }
}
