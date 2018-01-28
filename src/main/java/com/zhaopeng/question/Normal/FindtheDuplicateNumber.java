package com.zhaopeng.question.Normal;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * Created by zhaopeng on 2017/7/6.
 * <p>
 * 数组长度为 n+1， 数字为1-n
 */
public class FindtheDuplicateNumber {
    //https://leetcode.com/problems/find-the-duplicate-number/#/solutions

    // http://www.cnblogs.com/grandyang/p/4843654.html

    public int findDuplicate1(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;
    }

    public int findDuplicate(int[] nums) {

        int l = 1, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;


    }

}
