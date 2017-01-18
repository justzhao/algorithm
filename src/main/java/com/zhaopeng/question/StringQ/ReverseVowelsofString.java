package com.zhaopeng.question.StringQ;

/**
 * 交换字符串元音字符 首部和尾部开始
 * Created by zhaopeng on 2017/1/18.
 */
public class ReverseVowelsofString {

    public boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String reverseVowels(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        char c[] = s.toCharArray();

        int i = 0, j = c.length - 1;
        while (i < j) {
            while (i < j && !isVowels(c[j])) {
                j--;
            }
            while (i < j && !isVowels(c[i])) {
                i++;
            }
            //交换
            char temp=c[i];
            c[i]=c[j];
            c[j]=temp;

            i++;
            j--;
        }

        return String.valueOf(c);
    }
    public static void main(String args[]) {
        ReverseVowelsofString r=new ReverseVowelsofString();
        String s="leetcode";
        System.out.println(r.reverseVowels(s));
    }
}
