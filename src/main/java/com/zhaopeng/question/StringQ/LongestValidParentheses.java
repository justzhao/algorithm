package com.zhaopeng.question.StringQ;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * Created by zhaopeng on 2018/1/7.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    res = Math.max(res, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
