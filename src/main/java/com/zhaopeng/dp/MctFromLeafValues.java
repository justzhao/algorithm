package com.zhaopeng.dp;

/**
 * Created by zhaopeng on 2021/1/9 8:07 下午.
 */
public class MctFromLeafValues {


    public static void main(String args[]){


        MctFromLeafValues mctFromLeafValues=new MctFromLeafValues();



        int []arr={6,2,4};

        System.out.println(mctFromLeafValues.mctFromLeafValues(arr));
    }

    public int mctFromLeafValues(int[] arr) {


        int len=arr.length;

        int max[][]=new int[len][len];

        for(int j=0;j<len;j++){

            int cnt=arr[j];
            for(int i=j;i>=0;i--){
                cnt=Math.max(arr[i],cnt);

                max[i][j]=cnt;
            }
        }
        /**

         dp[i][j] 表示 节点 i，j 所有非叶子节点的最小和

         dp[i][j]= Math.min (dp[i][k]+dp[k+1][j] +  max[i][k]*max[k+1][j]) k 从 i+1 到 j-1;


         */

        int dp[][]=new int[len][len];
        for(int j=0;j<len;j++){
            for(int i=j;i>=0;i--){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){

                    min=Math.min(min,dp[i][k]+dp[k+1][j]+max[i][k]*max[k+1][j]);
                    dp[i][j]=min;

                }
            }

        }

        return dp[0][len-1];



    }

}
