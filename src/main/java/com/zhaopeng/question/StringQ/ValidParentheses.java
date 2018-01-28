package com.zhaopeng.question.StringQ;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * Created by zhaopeng on 2018/1/14.
 * <p>
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public static void main(String args[]) {
        ValidParentheses o = new ValidParentheses();

        String s="()[]{}";

        System.out.println(o.isValid(s));

    }

    public boolean isValid(String s) {

        if (s == null || s.equals("")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[') {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if(temp==')'&&top!='('){
                    return false;
                }
                if(temp=='}'&&top!='{'){
                    return false;
                }
                if(temp==']'&&top!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
