package com.zhaopeng.array;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 * Created by zhaopeng on 2018/1/9.
 */
public class GroupAnagrams {

    public static void main(String args[]){
        GroupAnagrams o=new GroupAnagrams();

        String s[]={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(o.groupAnagrams(s));
    }

    public List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        if (strs == null || strs.length == 0) {
            return res;
        }
        for (int i = 0; i < strs.length; i++) {
            char c[] = strs[i].toCharArray();
            Arrays.sort(c);
            String key=String.valueOf(c);
            if (map.get(key) == null) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);

        }

        for(List<String> s:map.values()){
            res.add(s);
        }
        return res;
    }
}
