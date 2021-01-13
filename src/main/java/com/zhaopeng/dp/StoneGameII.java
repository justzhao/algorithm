package com.zhaopeng.dp;

/**
 * Created by zhaopeng on 2021/1/12 11:44 下午.
 */
public class StoneGameII {


    public static void main(String args[]){


        StoneGameII gameII=new StoneGameII();

      // int []a={2,7,9,4,4};

        int []a={1,2,3,4,5,100};
       System.out.println( gameII.stoneGameII(a));
        System.out.println( gameII.stoneGameII2(a));
    }

    public int stoneGameII(int[] piles) {

        int len=piles.length;

        int sum[]=new int[len+1];

        for(int i=0;i<len;i++){

            sum[i+1]=sum[i]+piles[i];
        }

        int res= helper(piles,sum,0,1);

        return  (res+sum[len])/2;

    }

    public int stoneGameII2(int[] piles) {

        int len=piles.length;

        int sum[]=new int[len+1];

        for(int i=0;i<len;i++){

            sum[i+1]=sum[i]+piles[i];
        }

        return dfs(piles,0,1,sum);

    }

    /**
     index 没有选进去了
     */
    private int helper(int []piles,int []sum,int index,int M){
        int len=piles.length;
        if(index == len){
            return 0;
        };
        if ((len - index) <= (2 * M)){

            return sum[len]-sum[index];
        }

        int res=Integer.MIN_VALUE;;

        int minLen = Math.min(2 * M, len - index);
        for(int x=1;x<=minLen;x++){

            // index 是要选进去的
            int cur=sum[index+x]-sum[index];

            res=Math.max(res,cur-helper(piles,sum,index+x,Math.max(x, M)));
        }

        return res;

    }

//https://leetcode-cn.com/problems/stone-game-ii/solution/ji-yi-hua-di-gui-java-by-liweiwei1419/
    private void dp(){
        /*
         *  dp(i,j) 表示  长度为i的石块，在 一次性拿j个的时候 ，第一个人得到的分数
         */

    }

    private int dfs(int[] piles, int begin, int M, int[] preSum) {
        int len = piles.length;
        if (begin >= len) {
            return 0;
        }
        // 当前区间 [begin, len - 1] 的元素个数 len - begin <= 2M 的时候，
        // 全部拿走是利益最大的，这是因为 1 <= piles[i] <= 10 ^ 4
        if (len - begin <= 2 * M) {
            //memo[begin][M] = preSum[len] - preSum[begin];
            return preSum[len] - preSum[begin];
        }

        // 走到这里，可以取的石子堆数 1 <= X <= 2M
        // 区间 [begin, j] 的长度 j - begin + 1 >= 2 * M
        int minLen = Math.min(2 * M, len - begin);
        // 这个初始化很重要，因为有可能是负分，所以不能初始化为 0
        int res = Integer.MIN_VALUE;
        for (int X = 1; X <= minLen; X++) {
            // 区间 [begin, begin + X - 1] 的前缀和 = preSum[begin + X] - preSum[begin - 1]
            int chooseLeft = preSum[begin + X] - preSum[begin];
            res = Math.max(res, chooseLeft - dfs(piles, begin + X, Math.max(M, X), preSum));
        }
        //memo[begin][M] = res;
        return res;
    }


}


