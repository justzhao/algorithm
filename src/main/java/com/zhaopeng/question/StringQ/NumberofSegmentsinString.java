package com.zhaopeng.question.StringQ;

/**
 * 计一个字符串当中有几个子字符串,用空白字符分割的。当有多个连续的空字符串时候当成一个空字符串。
 * Created by zhaopeng on 2017/1/18.
 */
public class NumberofSegmentsinString {

    public int countSegments(String s) {
        if (s == null || s.equals("")) return 0;

        int count = 0;

        char c[] = s.toCharArray();

        int flag = 1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                flag = 1;
            } else {
                if (flag == 1) {
                    flag = 0;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        NumberofSegmentsinString v = new NumberofSegmentsinString();

       // String s = "Hello, my name is John";
        String s=", , , ,        a, eaefa";
        System.out.println(v.countSegments(s));
    }

}
