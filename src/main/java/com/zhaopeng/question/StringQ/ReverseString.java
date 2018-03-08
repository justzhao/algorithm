package com.zhaopeng.question.StringQ;

/**
 * Created by zhaopeng on 2017/1/16.
 * <p>
 * a = a ^ b；
 * b = b ^ a；
 * a = a ^ b；
 */
public class ReverseString {

    //递归会溢出
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        return helper(s, 0);

    }

    public String helper(String s, int pos) {
        if (pos == s.length() - 1) {
            return String.valueOf(s.charAt(pos));
        }
        String temp = helper(s, pos + 1);
        char c = s.charAt(pos);
        return temp + c;

    }

    public String reverseString1(String s) {

        if (s == null || s.equals("")) {
            return s;
        }
        char c[] = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = c[i];
            c[i] = c[len - 1 - i];
            c[len - 1 - i] = temp;
        }
        return String.valueOf(c);
    }

    public static void main(String args[]) {
        String s = "hello";
        ReverseString r = new ReverseString();
        System.out.println(r.reverseString(s));
    }
}
