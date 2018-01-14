package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * Created by zhaopeng on 2017/12/25.
 */
public class KthLargestElementinanArray {

    public static void main(String args[]){
        KthLargestElementinanArray o=new KthLargestElementinanArray();

        int a[]={99,99};
        int k=1;
        System.out.println(o.findKthLargest(a,k));
    }


    public int findKthLargest(int[] nums, int k) {

        k--;

        return partition(nums, 0, nums.length - 1, k);


    }

    int partition(int nums[], int lo, int ho, int k) {

        int left = lo, right = ho;
        if(left==right){
            return nums[lo];
        }

        int priot = nums[lo];
        while (left < right) {
            while (priot >= nums[right] && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (priot <= nums[left] && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = priot;
        if (k == left) {
            return nums[left];
        } else if (k < left) {
            return partition(nums, lo, left-1, k);
        } else {
            return partition(nums, left+1, ho, k);
        }
    }


}
