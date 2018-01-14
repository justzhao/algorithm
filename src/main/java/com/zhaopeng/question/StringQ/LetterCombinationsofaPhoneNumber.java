package com.zhaopeng.question.StringQ;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Created by zhaopeng on 2018/1/12.
 */
public class LetterCombinationsofaPhoneNumber {

    String phone[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String args[]){

        LetterCombinationsofaPhoneNumber o=new LetterCombinationsofaPhoneNumber();
        String n="2";
        System.out.println(o.letterCombinations(n));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.equals("")) {
            return res;
        }
        StringBuilder sb = new StringBuilder();

        helper(0, digits, res, sb);

        return res;
    }

    public void helper(int index, String digits, List<String> res, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int no=digits.charAt(index)-'0';
        String str = phone[no];

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            helper(index + 1, digits, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }

}
