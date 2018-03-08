package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 * Created by zhaopeng on 2018/2/4.
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //结果
        int res = 0;
        // 当前能走到的最大位置
        int curMax = 0;
        // 能走到的最大位置
        int nextMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == curMax) {
                res++;
                curMax = nextMax;
            }
        }
        return res;
    }

    public int jump1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //第level层
        int level = 0;
        //当前最大能到的位置
        int currentMax = 0;
        //下轮最大能到的位置
        int nextMax = 0;
        int i = 0;


        while (currentMax - i + 1 > 0) {        //  当前层能到达的节点数字
            level++;
            for (; i <= currentMax; i++) {    // 遍历当前层次的节点，更新下轮最大能到的节点 t
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1)
                    return level;   // 如果最后一个节点在最大能到的节点中，就返回
            }
            currentMax = nextMax;
        }
      return 0;
    }
}
