package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Created by zhaopeng on 2017/12/31.
 */
public class SearchinRotatedSortedArray {

    public static void main(String args[]){
        SearchinRotatedSortedArray o=new SearchinRotatedSortedArray();

        int a[]={4,5,6,7,8,1,2,3};

        int target=8;

        System.out.println(o.search(a,target));
    }

    public int search(int[] nums, int target) {

        if(nums==null||nums.length==0){
            return -1;
        }

        int l = 0, r = nums.length - 1;

        //升序   (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
        int mid = 0;
        while (l <=r) {

            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;

            } else if(target==nums[r]){
                return  r;
            }  else if(target==nums[l]){

                return l;
                //中间的数字比左边大
            } else if(nums[mid]>=nums[l]){
                if(target<=nums[mid]&&target>=nums[l]){
                    r=mid;
                }else {
                    l=mid+1;
                }
                // 中间的数字比左边小。
            } else {

                if(target>nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid;
                }
            }
        }
        return -1;
    }


    /**
     *
     */

}
