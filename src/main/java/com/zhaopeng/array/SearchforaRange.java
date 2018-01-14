package com.zhaopeng.array;

/**
 * Created by zhaopeng on 2018/1/11.
 */
public class SearchforaRange {


    public static void main(String args[]) {
        SearchforaRange o = new SearchforaRange();

        int a[] = {2, 2};

        int target = 3;
        System.out.println(o.searchRange(a, target));

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                int start = mid - 1;
                int end = mid + 1;
                while (start >= 0) {
                    if (nums[start] == target) {
                        start--;
                    } else {

                        break;
                    }

                }
                while (end < nums.length) {
                    if (nums[end] == target) {
                        end++;
                    } else {

                        break;
                    }
                }
                return new int[]{++start, --end};

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }


}
