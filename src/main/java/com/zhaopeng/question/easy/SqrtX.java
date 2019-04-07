package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2017/7/4.
 */
public class SqrtX {


    public static void main(String args[]) {
        SqrtX o=new SqrtX();

        int x=o.mySqrt11(2147395599);

        System.out.println(x);
    }


    public int mySqrt11(int x) {


        if (x <= 0) {
            return 0;
        }
        int left = 0;
        int right = x;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (x/mid == mid) {
                return mid;
            } else if (x/mid< mid) { //mid太大了。
                right = mid - 1;
            } else { // x/mid>mid// mid太小啦
                if (x/(mid+1)<(mid+1)) {
                    return mid + 1;
                }
                left = mid + 1;
            }


        }

        return 0;
    }

    public int mySqrt(int x) {


        if (x <= 0) {
            return 0;
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            // 当前mid 太大了。为什么这样写，除法防止溢出
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
