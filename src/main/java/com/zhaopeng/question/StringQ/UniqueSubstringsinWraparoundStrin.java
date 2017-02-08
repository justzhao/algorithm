package com.zhaopeng.question.StringQ;

/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/?tab=Description
 * 给定一个无限循环长的字符串s 和一个字符串p
 * 求p 在s中不重复的子串
 * <p>
 * 以  某个字符结束的子串来计算
 * Created by zhaopeng on 2017/2/8.
 */
public class UniqueSubstringsinWraparoundStrin {

    public int findSubstringInWraproundString(String p) {

        int count[] = new int[26];

        int len = 0;


        for (int i = 0; i < p.length(); i++) {
            int a = p.charAt(i) - 'a';
            if (i > 0) {

                int b = p.charAt(i - 1) - 'a';
                if (((b + 1) % 26 == a)) {
                    len++;
                } else {
                    len = 1;
                }
                count[a] = Math.max(count[a], len);
            } else {
                // 第一个字符
                len++;
                count[a]++;
            }
        }

        int sum = 0;
        for (int i = 0; i < count.length; i++) {

            sum += count[i];
        }

        return sum;
    }

    public static void main(String args[]) {
        UniqueSubstringsinWraparoundStrin v = new UniqueSubstringsinWraparoundStrin();
        String s = "zab";
        System.out.println(v.findSubstringInWraproundString(s));

        int a = 'z' - 'a';
        int b = 'a' - 'a';

        System.out.println("a== " + a + "  b=" + b + "  " + ((a + 1) % 26 == b));
        System.out.println(26 % 26);
    }
}
