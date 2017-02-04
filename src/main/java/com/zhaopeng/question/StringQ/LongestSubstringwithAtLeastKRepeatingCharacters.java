package com.zhaopeng.question.StringQ;

/**
 * 分治法的思想，以不符合要求的字符为切割点，切割字符串
 * Created by zhaopeng on 2017/2/4.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.equals("")) return 0;

        int count[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        boolean isAll = true;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] < k) {
                isAll = false;
                break;
            }
        }
        if (isAll) return s.length();

        int res = 0, index = 0, split = 0;
        while (index < s.length()) {

            char c = s.charAt(index);
            if (count[c - 'a'] > 0 && count[c - 'a'] < k) {
                // 切割点
                res = Math.max(res, longestSubstring(s.substring(split, index), k));
                split = index + 1;
            }
            index++;
        }
        // 结束遍历之后，最右边子串比较
        res = Math.max(res, longestSubstring(s.substring(split, index), k));

        return res;
    }

    public static void main(String args[]) {
        LongestSubstringwithAtLeastKRepeatingCharacters v = new LongestSubstringwithAtLeastKRepeatingCharacters();


        String t = "ababbc";
        int k = 3;
        System.out.println(v.longestSubstring(t, k));
    }
}
