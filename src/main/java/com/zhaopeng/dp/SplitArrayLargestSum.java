package com.zhaopeng.dp;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {

        if(nums==null|| m<=0){
            return 0;
        }
        int len=nums.length;

        //dp(i,j)为结果,表示数组(0,....i)被分为j份

        /**
         *
         * dp[i][j]= min(dp(i,j),max(sum(k,i),dp(k,j-1)))
         */
        int [][]dp=new int[len][m+1];

        //init
        for(int i=0;i<len;i++){

            for(int j=0;j<=m;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        // 分布求取sum(0,,i);
        dp[0][1]=nums[0];
        for(int i=1;i<len;i++){
            dp[i][1]=dp[i-1][1]+nums[i];
        }
        if(m==1){
            return dp[len-1][m];
        }

        for(int i=1;i<len;i++){
            for(int j=2;j<=m;j++){
                for(int k=0;k<i;k++){
                    //  分成j份可以由 j-1 份加上某段求和组成
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[i][1]-dp[k][1],dp[k][j-1] ));

                }
            }

        }
        return dp[len-1][m];

    }

}
