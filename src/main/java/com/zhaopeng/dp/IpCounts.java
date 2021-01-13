package com.zhaopeng.dp;

/**
 * Created by zhaopeng on 2021/1/1 8:44 下午.
 */
public class IpCounts {


    public static void main(String args[]) {

        IpCounts ipCounts = new IpCounts();
       // System.out.println("010010".substring(5,6));

       System.out.println(ipCounts.countIp("19216801"));
    }

    /**
     * 给定一个 只包含数字的字符串，看看可以有多少个ip
     * <p>
     * ip 一般是 4 个小于等于255的数字组成。
     *
     * @param s
     * @return
     */
    public int countIp(String s) {
        /**
         * dp(i,j) 表示为 j 个数字，变成 i 个 255以内的 数字有多少种
         *
         * dp[i][j]=
         *         dp[i-1][j-1]    如果j个数是255以内
         *         +  dp[i-1][j-1]   如果j-1,j个数是255以内
         *         +   dp[i-1][j-2 ]   如果j-2, j个数是255以内
         */


        int[][] res = new int[5][s.length() + 1];

        res[0][0] = 1;

        for (int i = 1; i < 5; i++) {

            // j一定要待遇等于i的。
            for (int j = 0; j <= s.length(); j++) {

                int sum = 0;

                for (int k = j; k >= 0 && (k >= j - 2); k--) {

                    if ((k < s.length()) && less255(s.substring(k, j ))) {
                        sum += res[i - 1][k];
                    }
                }
                res[i][j] = sum;

            }
        }


        return res[4][s.length()-1];
    }

    boolean less255(String s) {

        if("".equals(s)){
            return false;
        }
        if(s.startsWith("0")||s.equals('0')){
            return false;
        }



        Integer v = Integer.valueOf(s);

        return v <= 255;

    }


}
