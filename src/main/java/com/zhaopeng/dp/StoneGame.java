package com.zhaopeng.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaopeng on 2021/1/13 11:52 下午.
 */
public class StoneGame {

    public boolean stoneGame(int[] piles) {

        Map<String,Integer> cache=new HashMap();
        return helper(piles,0,piles.length-1,cache)>=0;


    }
    public int helper(int[] piles,int start,int end, Map<String,Integer> cache){

        if(start==end){
            return piles[start];
        }

        String key=start+"-"+end;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int res=  Math.max(piles[start]-helper(piles,start+1,end,cache),piles[end]-helper(piles,start,end-1,cache));

        cache.put(key,res);
        return res;

    }

    public boolean stoneGame1(int[] piles) {
        /**
         dp[i][j] 表示 从 i到j之间当前玩家 赢下一个玩家多少个。
         dp[i-1][j] 表示下一个玩家赢当前玩家多少个。
         dp[i][j]=max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);

         */

        int len=piles.length;

        int dp[][]=new int[len][len];

        for(int i=len-2;i>=0;i--){

            for(int j=i;j<len;j++){

                if(i==j){
                    dp[i][j]=piles[i];
                }else{

                    dp[i][j]=Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
                }


            }

        }

        return dp[0][len-1]>0;

    }

}
