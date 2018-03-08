package com.zhaopeng.question.Normal;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/description/
 * Created by zhaopeng on 2018/2/14.
 */
public class ThreeSumCloset {


    public static void main(String args[]){
        ThreeSumCloset o=new ThreeSumCloset();

        int a[]={1,1,-1};
        System.out.println(o.threeSumClosest(a,0));
    }



    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];

        for (int i = 0; i + 2 < nums.length; i++) {
            int a = i;
            int b = i + 1;
            int c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    c--;
                } else if (sum < target) {
                    b++;
                }else {
                    return sum;
                }
            }
        }
        return res;
    }

}
