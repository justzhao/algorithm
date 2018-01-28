package com.zhaopeng.question.StringQ;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 * Created by zhaopeng on 2018/1/27.
 * <p>
 * <p>
 * <p>
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {


    public static void main(String args[]) {
        BasicCalculator o = new BasicCalculator();

        String a = "2-(5-6)";
        System.out.println(o.calculate(a));
    }

    public int calculate(String s) {
        // 保存前面的运算结果和运算符
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                //栈来保存前面元素的结果和操作服符号
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                //运算此轮结果
                result += sign * num;
                num = 0;
                //获取括号前保存的符号运算
                result *= stack.pop();
                result += stack.pop();
            }
        }
        // 收尾工作
        if (num != 0) result += sign * num;
        return result;
    }
}
