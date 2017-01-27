package com.zhaopeng.question.StringQ;

import java.util.Stack;

/**
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".  abcabccdcdcdef
 * 不需要验证字符串的合法性
 * Created by zhaopeng on 2017/1/27.
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ']') {
                while (!stack.isEmpty()) {
                    char p = stack.pop();
                    if (p != '[') {
                        sb.insert(0, p);
                    } else {
                        // 存在倍数为10,100等
                        StringBuilder nums = new StringBuilder();
                        while (!stack.isEmpty()) {
                            p = stack.peek();
                            if (p >= '0' && p <= '9'){
                                nums.insert(0,stack.pop());
                            }else {
                                break;
                            }

                        }
                        int count =Integer.valueOf(nums.toString());
                        int a = 0;
                        String temp = sb.toString();
                        while (a < count) {
                            int len = temp.length();
                            for (int j = 0; j < len; j++) {
                                stack.push(temp.charAt(j));
                            }
                            a++;
                        }
                        // 重置
                        sb = new StringBuilder();
                        break;
                    }
                }
            } else {
                if (c == '[') {
                    char p = stack.peek();
                    if (p < '0' && p > '9') {
                        stack.push('1');
                    }
                }
                stack.push(c);
            }
            i++;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String args[]) {

        DecodeString v = new DecodeString();
        //   String s = "2[abc]3[cd]ef";
        // String s = "3[a]2[bc]";
        String s = "100[a]";
        System.out.println(v.decodeString(s).length());

    }
}
