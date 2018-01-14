package com.zhaopeng.question.StringQ;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/description/
 * Created by zhaopeng on 2018/1/6.
 */
public class WordBreak {

    public static void main(String args[]) {
        WordBreak o = new WordBreak();
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(o.wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        //res[i] 表示 0,i 的字符是否在wordDict中
        boolean res[] = new boolean[s.length()+1];
        res[0]=true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0; j <i; j++) {
                String temp = s.substring(j, i);
                if (wordDict.contains(temp)) {
                    if(res[j]){
                        res[i]=true;
                        break;
                    }
                }
            }

        }
        return res[s.length()];

    }

    //递归时间太长啦，只能dp
    public boolean wordBreak1(String s, List<String> wordDict) {

        return helper(0, s, wordDict);
    }

    public boolean helper(int index, String s, List<String> wordDict) {
        if (index == s.length()) {
            return false;
        }
        for (int i = s.length(); i > index; i--) {
            String temp = s.substring(index, i);
            if (wordDict.contains(temp)) {
                if (i == s.length()) {
                    return true;
                }
                if (helper(i, s, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }


}
