package com.zhaopeng.question.Normal;

/**
 * Created by zhaopeng on 2017/6/26.
 * <p>
 * 给定两个字符a，b。 看a是否包含b
 */
public class StrStr {

    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length() && haystack.equals(needle)) {

            return 0;

        }

      //  int diff = haystack.length() - needle.length();

        for (int i = 0; i + needle.length() <= haystack.length(); i++) {

            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        /**
         * "aaabb"
         "baba"
         */

        StrStr s = new StrStr();
        String a = "aaabb";

        String b = "baba";

        System.out.println(s.strStr(a, b));

    }

}
