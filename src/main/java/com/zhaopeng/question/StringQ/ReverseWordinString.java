package com.zhaopeng.question.StringQ;

/**
 * Created by zhaopeng on 2017/2/23.
 */
public class ReverseWordinString {

    public String reverseWords(String s) {

        if (s == null || s.equals("") ) return s;
        String ss[] = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = ss.length - 1; i >= 0; i--) {
            if(ss[i].equals(" ")||ss[i].equals("")) continue;
            if (builder.length() != 0) {
                builder.append(" ");
            }
            builder.append(ss[i]);
        }
        return builder.toString();
    }

    public static void main(String args[]) {
        ReverseWordinString r = new ReverseWordinString();

        String s = " 1";

        System.out.println(r.reverseWords(s));

    }
}
