package com.zhaopeng.question.StringQ;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 * <p>
 * <p>
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 * Created by zhaopeng on 2018/1/6.
 */
public class WordBreakII {

    public static void main(String args[]) {
        WordBreakII o = new WordBreakII();

        /**
         * "aaaaaaa"
         ["aaaa","aa","a"]
         */
        String s = "aaaaaaa";
        List<String> dicts = Arrays.asList("aaaa","aa","a");
        System.out.println(o.wordBreak(s, dicts));

        System.out.println(dicts);


    }

    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    /**
     * "abcd"
     * ["a","abc","b","cd"]
     * <p>
     * Output:
     * ["a b cd","abc"]
     * Expected:
     * ["a b cd"]
     *
     * @param s
     * @param wordDict
     * @param index
     * @return
     */
    public List<String> helper(String s, List<String> wordDict, int index) {

        if (map.containsKey(index)) {
            return map.get(index);
        }
        List<String> res = new ArrayList<>();
        if (index == s.length()) {
            res.add("");//取完了，，

            return  res;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (wordDict.contains(temp)) {
                List<String> list = helper(s, wordDict, i);
                for(String str:list){
                    res.add(temp+ (str.equals("")?"":" ")+str);
                }
            }
        }
        if (res.size() != 0) {
            map.put(index, res);
        }
        return res;
    }
}
