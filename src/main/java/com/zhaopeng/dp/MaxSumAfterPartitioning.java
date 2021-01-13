package com.zhaopeng.dp;

/**
 * Created by zhaopeng on 2021/1/10 7:32 下午.
 */
public class MaxSumAfterPartitioning {

    public int maxSumAfterPartitioning(int[] arr, int k) {


        /**


         dp[i] 表示 数组中前 i 个 ，被分割 为  子数组个数不超过k 的 子数组最大值的的和。
         那么 dp[i-1] 表示 数组中前 i-1 个 ，被分割 为  子数组个数不超过k 的 子数组最大值的的和。
         dp[i]= dp[i-1] + Max(nums[i-1])*(i-(i-1));

         dp[i]= dp[j] + Max(nums[j...i])*(i-j);
         */
        if(arr==null){
            return 0;
        }
        int len=arr.length;
        int dp[]=new int[len];

        //dp[0]=arr[0];
        for(int i=0;i<len;i++){

            int max=arr[i];

            for(int j=i-1;j>=0&&(i-j<=k);j--){

                max=Math.max(max,arr[j]);

                dp[i]= Math.max(dp[i],dp[j]+(i-j)*max);

            }


        }

        return dp[len-1];


    }
}
