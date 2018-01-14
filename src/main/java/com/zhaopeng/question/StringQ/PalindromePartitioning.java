package com.zhaopeng.question.StringQ;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * Created by zhaopeng on 2018/1/12.
 */
public class PalindromePartitioning {

    public static void main(String args[]){
        PalindromePartitioning o=new PalindromePartitioning();
        String str="aab";
        System.out.println(o.partition(str));
    }
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        if (s == null || s.equals("")) {
            return res;
        }
        helper(0, s, res, new ArrayList<String>());
        return res;
    }

    public void helper(int index, String s, List<List<String>> res, List<String> temp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String str=s.substring(index,i);
            if (isPalidrom(str)) {
                temp.add(str);
                helper(i, s, res, temp);
                temp.remove(temp.size()-1);
            }
        }

    }

    public boolean isPalidrom(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
