package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2017/7/4.
 */
public class SqrtX {

    public int mySqrt(int x) {


        if (x <= 0) {
            return 0;
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            // 当前mid 太大了。
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                // 在mid 和mid+1 之间
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }

        }

        return 0;
    }

}
