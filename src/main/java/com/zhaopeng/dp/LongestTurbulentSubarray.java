package com.zhaopeng.dp;

/**
 * Created by zhaopeng on 2021/1/1 11:18 下午.
 */
public class LongestTurbulentSubarray {


    public static void main(String args[]){
        int []a={9,4,2,10,7,8,8,1,9};
        LongestTurbulentSubarray  s=new LongestTurbulentSubarray();
        System.out.println(s.maxTurbulenceSize(a));

    }

    public int maxTurbulenceSize(int[] arr) {
        /**
         dp[i][0] 表示 长度i的数组且结尾为上升的 最长的值
         dp[i][1] 表示 长度i的数组且结尾为下降的 最长的值
         */
        int[][] dp = new int[arr.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            int b=arr[i];
            int a=arr[i-1];
            if (a < b) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (a >b) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(dp[i][0], dp[i][1]);
        }
        return res;

    }
}
