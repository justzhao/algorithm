package com.zhaopeng.array;

/**
 * https://leetcode.com/problems/sort-colors/description/
 * Created by zhaopeng on 2018/1/8.
 */
public class SortColors {

    public static void main(String args[]) {
        SortColors o = new SortColors();

        int a[] = {1, 2};
        o.sortColors(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * 只有 0，1,2 的排序,居然做到了只有0(n)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            //如果当前遇到的数字为0，直接和左边的交换，因为左边的可能存在1，left表示第一个可能存在的1
            if (nums[index] == 0) {

                swap(nums, index, left);
                index++;
                left++;
                //当遇到数字为1，不做变动。
            } else if (nums[index] == 1) {
                index++;
            } else {
                // right 表示最后的2
                swap(nums, index, right);
                right--;
            }

        }

    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
