package com.zhaopeng.question.StringQ;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 * Created by zhaopeng on 2018/1/27.
 *
 *
 *The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */
public class BasicCalculatorII {

    public static void main(String args[]) {
        BasicCalculatorII o = new BasicCalculatorII();
        String a = "3+2*2";
        System.out.println(o.calculate(a));
    }

    public int calculate(String s) {

        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (' ' != c && (c < '0' || c > '9') || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;

    }
}
