package com.zhaopeng.question.StringQ;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 * Created by zhaopeng on 2018/1/27.
 */
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean find = false;
        char pre = ' ';
        while (!find) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= index) {
                    find = true;
                    break;
                }
                char c = strs[i].charAt(index);
                if (pre == ' ') {
                    pre = c;
                } else {
                    if (pre != c) {
                        find = true;
                        break;
                    }
                }
                if (i == strs.length - 1) {
                    sb.append(c);
                    pre=' ';
                    index++;
                }
            }
        }
        return sb.toString();
    }
}
