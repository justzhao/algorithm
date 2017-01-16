package com.zhaopeng.question.StringQ;

/**
 * 找到第一个不重复的字符
 * Created by zhaopeng on 2017/1/16.
 */
public class FirstUniqueCharacterinString {

    public int firstUniqChar(String s) {
        if (s == null || s.equals("")) {
            return -1;
        }
        int count[] = new int[26];
        char c[] = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            count[c[i] - 'a']++;
        }
        for (int i = 0; i < c.length; i++) {
            if(count[c[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {

        //System.out.println('c' - 'a');
        String s="loveleetcode";
        FirstUniqueCharacterinString r=new FirstUniqueCharacterinString();

        System.out.println(r.firstUniqChar(s));
    }
}
