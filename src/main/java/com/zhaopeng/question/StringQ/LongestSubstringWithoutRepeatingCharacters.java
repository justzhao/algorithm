package com.zhaopeng.question.StringQ;

import java.util.HashMap;

/**
 * 最长非重复子序列的长度
 * Created by zhaopeng on 2017/2/16.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;

        /**
         *  使用map 记录每个元素出现的索引，
         *
         *  使用j来记录子串的首字母，i记录子串的尾部。
         *
         */
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 更新j的位置
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // 记录字符的位置
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void  main(String args[]){
        LongestSubstringWithoutRepeatingCharacters v=new LongestSubstringWithoutRepeatingCharacters();

        String s="abcabcbb";
        System.out.println(v.lengthOfLongestSubstring(s));
    }
}
