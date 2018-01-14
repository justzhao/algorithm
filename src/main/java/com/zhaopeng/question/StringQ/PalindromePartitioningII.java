package com.zhaopeng.question.StringQ;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 * Created by zhaopeng on 2018/1/13.
 * <p>
 * cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
 * If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
 */
public class PalindromePartitioningII {


    public static void main(String args[]) {

        String s = "aab";
        PalindromePartitioningII o = new PalindromePartitioningII();
        System.out.println(o.minCut(s));
    }

    public int minCut(String s) {

        if (s == null || s.equals("")) {
            return 0;
        }
        int len = s.length();

        boolean isPalid[][] = new boolean[len][len];
        int res[] = new int[len];
        res[0] = 0;
        for (int i = 1; i < len; i++) {
            // 默认几个字符就默认有几个切
            int min = i;
            for (int j = 0; j <= i; j++) {
                boolean isP = i == j || s.charAt(j) == s.charAt(i) && ((j + 1 <= i - 1 && isPalid[j + 1][i - 1]) || j == i - 1);
                if (isP) {
                    isPalid[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, res[j - 1] + 1);
                }
            }
            res[i] = min;
        }
        return res[len - 1];
    }
}
