package com.zhaopeng.dp;

/**
 * http://www.lintcode.com/en/problem/longest-common-substring/#
 * 最长公共子串
 * Created by zhaopeng on 2018/2/22.
 */
public class LongestCommonSubstring {

    /**Input : X = "GeeksforGeeks", y = "GeeksQuiz"
     Output : 5
     The longest common substring is "Geeks" and is of
     length 5.

     Input : X = "abcdxyz", y = "xyzabcd"
     Output : 4
     The longest common substring is "abcd" and is of
     length 4.

     Input : X = "zxabcdezy", y = "yzabcdezx"
     Output : 6
     The longest common substring is "abcdez" and is of
     length 6.
     *
     * @param args
     */
    public static void main(String args[]){

        LongestCommonSubstring o=new LongestCommonSubstring();

        //String  x = "GeeksforGeeks",y = "GeeksQuiz";
       // String x = "abcdxyz", y = "xyzabcd";
        String x = "zxabcdezy", y = "yzabcdezx";

        System.out.println(o.longestCommonSubstring(x,y));
    }


    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        //dp [i][j]是表示 长度i和j 的共同子串，必须包含i和j
        int dp[][] = new int[A.length() + 1][B.length() + 1];

        int result=0;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                //第 i个字符是 i-1
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    //为什么要等于0.因为一旦charAt(i)!=charAt(j),表示当前共同字符串长度为0
                    // String x = "zxabcdezy", y = "yzabcdezx";
                    //dp[i][j] =Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]));
                   dp[i][j]=0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
        //return dp[A.length()][B.length()];
    }
}
