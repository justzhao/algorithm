package com.zhaopeng.array;

/** https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Created by zhaopeng on 2018/1/27.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {

        if(nums==null||nums.length==0){
            return 0;
        }
        int res=0;


        for(int i=0;i<nums.length;i++){
            res++;
            nums[res-1]=nums[i];
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }

        }
        return res;
    }
}
